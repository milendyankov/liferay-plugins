
package com.liferay.portal.search.elasticsearch;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.common.text.Text;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHitField;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.facet.range.RangeFacet;
import org.elasticsearch.search.facet.range.RangeFacetBuilder;
import org.elasticsearch.search.facet.terms.TermsFacet;
import org.elasticsearch.search.facet.terms.TermsFacetBuilder;
import org.elasticsearch.search.highlight.HighlightField;
import org.elasticsearch.search.sort.SortOrder;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.search.BaseIndexSearcher;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.DocumentImpl;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.HitsImpl;
import com.liferay.portal.kernel.search.Query;
import com.liferay.portal.kernel.search.QueryConfig;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.facet.Facet;
import com.liferay.portal.kernel.search.facet.config.FacetConfiguration;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.search.elasticsearch.facet.ElasticsearchFacetFieldCollector;

/**
 * 
 * @author Milen Dyankov
 *
 */
public class ElasticsearchIndexSearcher extends BaseIndexSearcher {


	public ElasticsearchNodeClient getClient() {

		return client;
	}

	@Override
	public Hits search(SearchContext searchContext, Query query)
		throws SearchException {

		SearchRequestBuilder searchRequestBuilder = getClient().getClient().prepareSearch();

		QueryConfig queryConfig = query.getQueryConfig();

		addHighlights(searchRequestBuilder, queryConfig);
		addQueryWithCompanyId(searchRequestBuilder, searchContext.getCompanyId(), query);
		searchRequestBuilder.addFields("*");
		addPagination(searchRequestBuilder, searchContext.getStart(), searchContext.getEnd());
		addSort(searchRequestBuilder, searchContext.getSorts());
		addFacets(searchRequestBuilder, searchContext);

		SearchResponse searchResponse = client.search(searchRequestBuilder.request());

		Hits hits = new HitsImpl();
		List<Document> documents = new ArrayList<Document>();
		List<Float> scores = new ArrayList<Float>();
		List<String> snippets = new ArrayList<String>();
		Set<String> queryTerms = new HashSet<String>();

		SearchHits searchHits = searchResponse.getHits();
		if (searchHits.totalHits() > 0) {
			SearchHit[] returnedHits = searchHits.getHits();
			for (SearchHit hit : returnedHits) {

			Document document = extractDocument(hit);
			documents.add(document);

			String snippet = extractHighlightedSnippet(hit, queryConfig);
			snippets.add(snippet);
			queryTerms.add(snippet);
			scores.add(hit.getScore());

		}
		}
		updateFacetCollectors(searchContext, searchResponse);

		hits.setDocs(documents.toArray(new Document[documents.size()]));
		hits.setLength((int) searchHits.getTotalHits());
		hits.setQuery(query);

		hits.setQueryTerms(queryTerms.toArray(new String[queryTerms.size()]));
		hits.setScores(scores.toArray(new Float[scores.size()]));

		hits.setSearchTime((float) searchResponse.getTook().getSecondsFrac());
		hits.setSnippets(snippets.toArray(new String[snippets.size()]));
		// hits.setStart(startTime);

		return hits;
	}

	@Override
	public Hits search(String searchEngineId, long companyId, Query query, Sort[] sort, int start, int end)
		throws SearchException {

		SearchRequestBuilder searchRequestBuilder = getClient().getClient().prepareSearch();

		QueryConfig queryConfig = query.getQueryConfig();

		addHighlights(searchRequestBuilder, queryConfig);
		addQueryWithCompanyId(searchRequestBuilder, companyId, query);
		searchRequestBuilder.addFields("*");
		addPagination(searchRequestBuilder, start, end);
		addSort(searchRequestBuilder, sort);

		SearchResponse searchResponse = client.search(searchRequestBuilder.request());

		Hits hits = new HitsImpl();
		List<Document> documents = new ArrayList<Document>();
		List<Float> scores = new ArrayList<Float>();
		List<String> snippets = new ArrayList<String>();
		Set<String> queryTerms = new HashSet<String>();

		SearchHits searchHits = searchResponse.getHits();
		if (searchHits.totalHits() > 0) {
			SearchHit[] returnedHits = searchHits.getHits();
			for (SearchHit hit : returnedHits) {

			Document document = extractDocument(hit);
			documents.add(document);

			String snippet = extractHighlightedSnippet(hit, queryConfig);
			snippets.add(snippet);
			queryTerms.add(snippet);
			scores.add(hit.getScore());

		}
		}

		hits.setDocs(documents.toArray(new Document[documents.size()]));
		hits.setLength((int) searchHits.getTotalHits());
		hits.setQuery(query);

		hits.setQueryTerms(queryTerms.toArray(new String[queryTerms.size()]));
		hits.setScores(scores.toArray(new Float[scores.size()]));

		hits.setSearchTime((float) searchResponse.getTook().getSecondsFrac());
		hits.setSnippets(snippets.toArray(new String[snippets.size()]));
		// hits.setStart(startTime);

		return hits;
		
		
	}


	public void setClient(ElasticsearchNodeClient client) {

		this.client = client;
	}

	private void addFacets(SearchRequestBuilder searchRequestBuilder, SearchContext searchContext) {

		Map<String, Facet> facets = searchContext.getFacets();

		for (Facet facet : facets.values()) {
			if (facet.isStatic()) {
				continue;
			}

			FacetConfiguration facetConfiguration = facet.getFacetConfiguration();

			if (facet instanceof com.liferay.portal.kernel.search.facet.RangeFacet) {

				RangeFacetBuilder facetBuilder = new RangeFacetBuilder(facetConfiguration.getFieldName());
				facetBuilder.field(facetConfiguration.getFieldName());

				JSONObject dataJSONObject = facetConfiguration.getData();
				JSONArray rangesJSONArray = dataJSONObject.getJSONArray("ranges");
				if (rangesJSONArray == null) {
					continue;
				}

				for (int i = 0; i < rangesJSONArray.length(); i++) {
					JSONObject rangeJSONObject = rangesJSONArray.getJSONObject(i);
					String rangeString = rangeJSONObject.getString("range");
					rangeString = rangeString.replace("[", "").replace("]", "");
					String[] rangeArray = rangeString.split(" ");
					facetBuilder.addRange(rangeArray[0], rangeArray[2]);
				}
				searchRequestBuilder.addFacet(facetBuilder);
			}
			else {
				searchRequestBuilder.addFacet(new TermsFacetBuilder(facetConfiguration.getFieldName()).field(facetConfiguration.getFieldName()));
			}
		}
	}

	private void addHighlights(SearchRequestBuilder searchRequestBuilder, QueryConfig queryConfig) {

		if (queryConfig.isHighlightEnabled()) {
			String localizedContentName = DocumentImpl.getLocalizedName(queryConfig.getLocale(), Field.CONTENT);
			String localizedTitleName = DocumentImpl.getLocalizedName(queryConfig.getLocale(), Field.TITLE);
			searchRequestBuilder.addHighlightedField(
				localizedContentName, queryConfig.getHighlightFragmentSize(), queryConfig.getHighlightSnippetSize());
			searchRequestBuilder.addHighlightedField(
				localizedTitleName, queryConfig.getHighlightFragmentSize(), queryConfig.getHighlightSnippetSize());
		}

	}

	private void addPagination(SearchRequestBuilder searchRequestBuilder, int start, int end) {

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS)) {
			searchRequestBuilder.setSize(0);
		}
		else {
			searchRequestBuilder.setSize(end - start);
			searchRequestBuilder.setFrom(start);
		}
	}

	private void addQueryWithCompanyId(
		SearchRequestBuilder searchRequestBuilder, long companyId, Query query) {

		String queryString = query.toString();
		BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
		boolQueryBuilder.must(QueryBuilders.queryString(queryString));
		boolQueryBuilder.must(QueryBuilders.termQuery(Field.COMPANY_ID, companyId));
		searchRequestBuilder.setQuery(boolQueryBuilder);
	}

	private void addSort(SearchRequestBuilder searchRequestBuilder, Sort[] sorts) {

		if (sorts != null) {
			for (Sort sort : sorts) {
				if (sort == null) {
					continue;
				}

				String sortFieldName = sort.getFieldName();

				if (DocumentImpl.isSortableTextField(sortFieldName)) {
					sortFieldName = DocumentImpl.getSortableFieldName(sortFieldName);
				}

				SortOrder order = SortOrder.ASC;

// The following logic is in the Solr plugin but it seams wrong !!!
// why not sort by the tokenized field if a non-tokenized is not available ?!?
				
//				if (Validator.isNull(sortFieldName) || !sortFieldName.endsWith("sortable")) {
//
//					sortFieldName = "_score";
//
//					order = SortOrder.DESC;
//				}

				if (sort.isReverse()) {
					order = SortOrder.DESC;
				}

				searchRequestBuilder.addSort(sortFieldName, order);
			}
		}
	}

	private Document extractDocument(SearchHit hit) {

		Document document = new DocumentImpl();

		// process documents
		Map<String, SearchHitField> hitFields = hit.getFields();
		for (Entry<String, SearchHitField> entry : hitFields.entrySet()) {
			Collection<Object> fieldValues = entry.getValue().getValues();

			Field field =
				new Field(entry.getKey(), ArrayUtil.toStringArray(fieldValues.toArray(new Object[fieldValues.size()])));

			document.add(field);
		}
		return document;
	}

	private String extractHighlightedSnippet(SearchHit hit, QueryConfig queryConfig) {

		String localizedContentName = DocumentImpl.getLocalizedName(queryConfig.getLocale(), Field.CONTENT);
		String localizedTitleName = DocumentImpl.getLocalizedName(queryConfig.getLocale(), Field.TITLE);

		String snippet = null;
		Map<String, HighlightField> highlightFields = hit.getHighlightFields();

		if (highlightFields != null && highlightFields.size() > 0) {
			if (localizedContentName != null) {
				HighlightField highlightField = highlightFields.get(localizedContentName);
				if (highlightField != null) {
					Text[] texts = highlightField.fragments();
					if (texts != null && texts.length > 0) {
						snippet = texts[0].string();
					}
				}
			}

			if (snippet == null && localizedTitleName != null) {
				HighlightField highlightField = highlightFields.get(localizedContentName);
				if (highlightField != null) {
					Text[] texts = highlightField.fragments();
					if (texts != null && texts.length > 0) {
						snippet = texts[0].string();
					}
				}
			}
		}

		if (snippet == null) {
			snippet = StringPool.BLANK;
		}
		return snippet;
	}

	private void updateFacetCollectors(SearchContext searchContext, SearchResponse searchResponse) {

		for (Facet facet : searchContext.getFacets().values()) {
			if (facet.isStatic()) {
				continue;
			}
			org.elasticsearch.search.facet.Facet esFacet = searchResponse.getFacets().facet(facet.getFieldName());
			if (facet instanceof com.liferay.portal.kernel.search.facet.RangeFacet) {
				facet.setFacetCollector(new ElasticsearchFacetFieldCollector((RangeFacet)esFacet));
			} else {
				facet.setFacetCollector(new ElasticsearchFacetFieldCollector((TermsFacet)esFacet));
			}
		}
	}

	private ElasticsearchNodeClient client;

}
