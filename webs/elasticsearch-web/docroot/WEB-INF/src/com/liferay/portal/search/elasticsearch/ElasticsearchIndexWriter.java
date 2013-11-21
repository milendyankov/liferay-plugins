
package com.liferay.portal.search.elasticsearch;

import static org.elasticsearch.common.xcontent.XContentFactory.jsonBuilder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.elasticsearch.action.deletebyquery.DeleteByQueryRequest;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.BaseIndexWriter;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.DocumentImpl;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.Validator;

/**
 * 
 * @author Milen Dyankov
 *
 */
public class ElasticsearchIndexWriter extends BaseIndexWriter {

	@Override
	public void addDocument(SearchContext searchContext, Document document)
		throws SearchException {

		try {
			client.index(getElasticsearchDocument(document));
		}
		catch (Exception e) {
			throw new SearchException("Failed to index entity!", e);
		}
	}
	@Override
	public void addDocuments(SearchContext searchContext, Collection<Document> documents)
		throws SearchException {

		// FIXME Change it to do this in chunks !!!
		// FIXME add option to skip failed docs instead of failing the whole

		List<ElasticsearchDocument> esDocuments = new ArrayList<ElasticsearchDocument>();

		try {
			for (Document document : documents) {
				esDocuments.add(getElasticsearchDocument(document));
			}
			client.index(esDocuments);
		}
		catch (Exception e) {
			throw new SearchException("Failed to index entity!", e);
		}

	}

	@Override
	public void deleteDocument(SearchContext searchContext, String uid)
		throws SearchException {

		try {
			client.deleteById(uid);
		}
		catch (Exception e) {
			throw new SearchException("Failed to delete entity from index!", e);
		}
	}

	@Override
	public void deleteDocuments(SearchContext searchContext, Collection<String> uids)
		throws SearchException {

		try {
			client.deleteById(uids);
		}
		catch (Exception e) {
			throw new SearchException("Failed to delete entity from index!", e);
		}

	}

	@Override
	public void deletePortletDocuments(SearchContext searchContext, String portletId)
		throws SearchException {

		long companyId = searchContext.getCompanyId();

		BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
		if (companyId > 0) {
			boolQueryBuilder.must(QueryBuilders.termQuery(Field.COMPANY_ID, companyId));
		}
		boolQueryBuilder.must(QueryBuilders.termQuery(Field.PORTLET_ID, portletId));

		DeleteByQueryRequest deleteByQueryRequest = new DeleteByQueryRequest();
		deleteByQueryRequest.query(boolQueryBuilder);

		try {
			client.deleteByQuery(deleteByQueryRequest);
		}
		catch (Exception e) {
			throw new SearchException("Failed to delete portlet data from index for portlet " + portletId + "!", e);
		}
	}

	/**
	 * @return the client
	 */
	public ElasticsearchNodeClient getClient() {

		return client;
	}

	/**
	 * @param client
	 *            the client to set
	 */
	public void setClient(ElasticsearchNodeClient client) {

		this.client = client;
	}

	@Override
	public void updateDocument(SearchContext searchContext, Document document)
		throws SearchException {

		try {
			client.update(getElasticsearchDocument(document));
		}
		catch (Exception e) {
			throw new SearchException("Failed to update document !", e);
		}
	}

	@Override
	public void updateDocuments(SearchContext searchContext, Collection<Document> documents)
		throws SearchException {

		// FIXME Change it to do this in chunks !!!
		// FIXME add option to skip failed docs instead of failing the whole

		List<ElasticsearchDocument> esDocuments = new ArrayList<ElasticsearchDocument>();

		try {
			for (Document document : documents) {
				esDocuments.add(getElasticsearchDocument(document));
			}
			client.update(esDocuments);
		}
		catch (Exception e) {
			throw new SearchException("Failed to index entity!", e);
		}

	}

	private ElasticsearchDocument getElasticsearchDocument(Document document)
		throws IOException {

		XContentBuilder builder = jsonBuilder().startObject();
		ElasticsearchDocument esDocument = new ElasticsearchDocument();

		Collection<Field> fields = document.getFields().values();

		for (Field field : fields) {
			String name = field.getName();

			// TODO need to figure out how to use boost in elasticsearch !!!
			float boost = field.getBoost();

			if (ArrayUtil.contains(Field.UNSCORED_FIELD_NAMES, name)) {
				boost = _UNSCORED_FIELDS_BOOST;
			}

			if (name.equals(DOCUMENT_ID_FIELD)) {
				esDocument.setId(field.getValue());
			}

			if (!field.isLocalized()) {
				for (String value : field.getValues()) {
					if (Validator.isNull(value)) {
						continue;
					}

					// TODO add the boost somehow !!!

					builder.field(name, value.trim() /* , boost */);
				}
			}
			else {
				Map<Locale, String> localizedValues = field.getLocalizedValues();

				for (Map.Entry<Locale, String> entry : localizedValues.entrySet()) {

					String value = entry.getValue();

					if (Validator.isNull(value)) {
						continue;
					}

					Locale locale = entry.getKey();

					String languageId = LocaleUtil.toLanguageId(locale);

					String defaultLanguageId = LocaleUtil.toLanguageId(LocaleUtil.getDefault());

					if (languageId.equals(defaultLanguageId)) {

						// TODO add the boost somehow !!!
						builder.field(name, value.trim() /* , boost */);
					}

					String localizedName = DocumentImpl.getLocalizedName(locale, name);

					// TODO add the boost somehow !!!
					builder.field(localizedName, value.trim() /* , boost */);
				}
			}
		}

		esDocument.setJson(builder.endObject().string());
		return esDocument;
	}

	private static final Log _log = LogFactoryUtil.getLog(ElasticsearchIndexWriter.class);

	private static final float _UNSCORED_FIELDS_BOOST = 1;

	private static final String DOCUMENT_ID_FIELD = "uid";

	private ElasticsearchNodeClient client;

}
