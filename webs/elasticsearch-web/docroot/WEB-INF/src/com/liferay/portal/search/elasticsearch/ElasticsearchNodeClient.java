
package com.liferay.portal.search.elasticsearch;

import static org.elasticsearch.node.NodeBuilder.nodeBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.elasticsearch.action.admin.indices.create.CreateIndexRequestBuilder;
import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
import org.elasticsearch.action.admin.indices.mapping.put.PutMappingRequestBuilder;
import org.elasticsearch.action.admin.indices.mapping.put.PutMappingResponse;
import org.elasticsearch.action.bulk.BulkRequestBuilder;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.deletebyquery.DeleteByQueryRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.client.Client;
import org.elasticsearch.common.settings.ImmutableSettings;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.node.Node;

import com.liferay.compat.portal.util.PortalUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.search.elasticsearch.util.PortletPropsValues;

/**
 * @author Milen Dyankov
 */
public class ElasticsearchNodeClient {

	public void createIndex() {

		Client client = _node.client();
		boolean indexExists =
			client.admin().indices().prepareExists(PortletPropsValues.ELASTICSEARCH_INDEX_NAME).execute().actionGet().isExists();
		if (!indexExists) {
			CreateIndexRequestBuilder createIndexRequestBuilder =
				client.admin().indices().prepareCreate(PortletPropsValues.ELASTICSEARCH_INDEX_NAME);

			Settings settings =
				ImmutableSettings.settingsBuilder().put(
					"number_of_shards", PortletPropsValues.ELASTICSEARCH_INDEX_NUMBER_OF_SHARDS).put(
					"number_of_replicas", PortletPropsValues.ELASTICSEARCH_INDEX_NUMBER_OF_REPLICAS).build();
			createIndexRequestBuilder.setSettings(settings);

			CreateIndexResponse createIndexResponse = createIndexRequestBuilder.execute().actionGet();

			if (!createIndexResponse.isAcknowledged()) {
				log.error("Could not create index " + PortletPropsValues.ELASTICSEARCH_INDEX_NAME +
					"! Search may not work properly!");
				return;
			}

			createMappings();

		}
	}

	public void createMappings() {

		Client client = _node.client();
		String mappingsJSON = null;
		try {
			mappingsJSON = readMappingsFromResource(PortletPropsValues.ELASTICSEARCH_INDEX_MAPPINGS);
		}
		catch (IOException e) {
			log.error("Failed to read Elasticsearch mappings! Search may not work properly!", e);
		}

		PutMappingRequestBuilder putMappingRequestBuilder =
			client.admin().indices().preparePutMapping(PortletPropsValues.ELASTICSEARCH_INDEX_NAME);
		putMappingRequestBuilder.setType(PortletPropsValues.ELASTICSEARCH_INDEX_DOCUMENT_TYPE).setSource(mappingsJSON);
		PutMappingResponse putMappingResponse = putMappingRequestBuilder.execute().actionGet();

		if (!putMappingResponse.isAcknowledged()) {
			log.error("Could not create mappings for " + PortletPropsValues.ELASTICSEARCH_INDEX_NAME +
				"! Search may not work properly!");
			return;
		}
	}

	public void deleteById(Collection<String> uids) {

		BulkRequestBuilder bulkRequestBuilder = getClient().prepareBulk();

		for (String uid : uids) {
			bulkRequestBuilder.add(new DeleteRequest(
				PortletPropsValues.ELASTICSEARCH_INDEX_NAME, PortletPropsValues.ELASTICSEARCH_INDEX_DOCUMENT_TYPE, uid));
		}
		bulkRequestBuilder.execute().actionGet();
	}

	public void deleteById(String uid) {

		if (uid == null) {
			return;
		}

		getClient().delete(
			new DeleteRequest(
				PortletPropsValues.ELASTICSEARCH_INDEX_NAME, PortletPropsValues.ELASTICSEARCH_INDEX_DOCUMENT_TYPE, uid)).actionGet();
	}

	public void deleteByQuery(DeleteByQueryRequest deleteByQueryRequest) {

		getClient().deleteByQuery(deleteByQueryRequest).actionGet();
	}

	public Client getClient() {

		if (_node != null) {
			return _node.client();
		}
		return null;
	};

	public void index(Collection<ElasticsearchDocument> esDocuments) {

		BulkRequestBuilder bulkRequestBuilder = getClient().prepareBulk();

		for (ElasticsearchDocument esDocument : esDocuments) {
			bulkRequestBuilder.add(getIndexRequest(esDocument));
		}
		BulkResponse response = bulkRequestBuilder.execute().actionGet();
		if (response.hasFailures()) {
			log.warn("Some docments weren't indexed: /n" + response.buildFailureMessage());
		}
	}

	public void index(ElasticsearchDocument esDocument) {

		getClient().index(getIndexRequest(esDocument)).actionGet();
	}

	public SearchResponse search(SearchRequest searchRequest) {

		return getClient().search(searchRequest).actionGet();
	}

	public void startLiferayClientNode() {

		String nodeName = getClientNodeName();
		Settings nodeSettings =
			ImmutableSettings.settingsBuilder().put("cluster.name", "elasticsearch").put("node.name", nodeName).build();
		_node = nodeBuilder().settings(nodeSettings).client(true).node();

		createIndex();

	}

	public void stopLiferayClientNode() {

		if (_node != null) {
			_node.close();
		}
	}

	public void update(Collection<ElasticsearchDocument> esDocuments) {

		BulkRequestBuilder bulkRequestBuilder = getClient().prepareBulk();

		for (ElasticsearchDocument esDocument : esDocuments) {
			bulkRequestBuilder.add(getUpdateRequest(esDocument));
		}
		BulkResponse response = bulkRequestBuilder.execute().actionGet();
		if (response.hasFailures()) {
			log.warn("Some docments weren't updated: /n" + response.buildFailureMessage());
		}
	}

	public void update(ElasticsearchDocument esDocument) {

		getClient().update(getUpdateRequest(esDocument)).actionGet();
	}

	private String getClientNodeName() {

		String nodeName = PortletPropsValues.ELASTICSEARCH_NODE_NAME;
		nodeName =
			nodeName.replaceAll("\\$\\{host\\}", PortalUtil.getComputerName()).replaceAll(
				"\\$\\{port\\}", "" + PortalUtil.getPortalPort(false)).replaceAll(
				"\\$\\{path\\}", PortalUtil.getPathContext()).replaceAll(
				"\\$\\{companyId\\}", "" + PortalUtil.getDefaultCompanyId());

		Pattern pattern = Pattern.compile("\\$\\{system:([^\\}]*)\\}");
		Matcher matcher = pattern.matcher(nodeName);
		StringBuffer sb = new StringBuffer();

		while (matcher.find()) {
			String sysProperty = matcher.group(1);
			String value = System.getProperty(sysProperty);
			if (value == null) value = sysProperty;
			matcher.appendReplacement(sb, value);
		}
		matcher.appendTail(sb);

		return sb.toString();
	};

	private IndexRequest getIndexRequest(ElasticsearchDocument esDocument) {

		IndexRequest indexRequest =
			new IndexRequest(
				PortletPropsValues.ELASTICSEARCH_INDEX_NAME, PortletPropsValues.ELASTICSEARCH_INDEX_DOCUMENT_TYPE);
		if (esDocument.getId() != null) {
			indexRequest.id(esDocument.getId());
		}
		indexRequest.source(esDocument.getJson());
		return indexRequest;
	}

	private UpdateRequest getUpdateRequest(ElasticsearchDocument esDocument) {

		if (esDocument.getId() == null) {
			return null;
		}

		UpdateRequest updateRequest =
			new UpdateRequest(
				PortletPropsValues.ELASTICSEARCH_INDEX_NAME, PortletPropsValues.ELASTICSEARCH_INDEX_DOCUMENT_TYPE,
				esDocument.getId());
		updateRequest.doc(esDocument.getJson()).upsert(esDocument.getJson());
		return updateRequest;
	}

	private String readMappingsFromResource(String resource)
		throws IOException {

		InputStream mappingsInputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(resource);
		InputStreamReader ipsr = new InputStreamReader(mappingsInputStream);
		BufferedReader br = new BufferedReader(ipsr);
		StringBundler mappings = new StringBundler();
		String line;

		while ((line = br.readLine()) != null) {
			mappings.append(line);
		}
		br.close();
		return mappings.toString();
	}

	private static Node _node;

	private static final Log log = LogFactoryUtil.getLog(FinderCacheUtil.class);

}
