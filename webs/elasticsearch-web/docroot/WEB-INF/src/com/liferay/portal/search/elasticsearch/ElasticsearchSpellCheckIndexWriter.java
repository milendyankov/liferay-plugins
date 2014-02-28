/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.portal.search.elasticsearch;

import org.elasticsearch.action.deletebyquery.DeleteByQueryRequest;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.BaseGenericSpellCheckIndexWriter;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.search.SuggestionConstants;
import com.liferay.portal.util.PortletKeys;

/**
 * @author Milen Dyankov
 */
public class ElasticsearchSpellCheckIndexWriter extends BaseGenericSpellCheckIndexWriter {

	@Override
	public void clearQuerySuggestionDictionaryIndexes(SearchContext searchContext)
		throws SearchException {

		DeleteByQueryRequest deleteQuery = buildDeleteQuery(searchContext, SuggestionConstants.TYPE_QUERY_SUGGESTION);

		try {
			_elasticsearchClient.deleteByQuery(deleteQuery);
		}
		catch (Exception e) {
			if (_log.isDebugEnabled()) {
				_log.debug(e, e);
			}

			throw new SearchException(e.getMessage(), e);
		}
	}

	@Override
	public void clearSpellCheckerDictionaryIndexes(SearchContext searchContext)
		throws SearchException {

		DeleteByQueryRequest deleteQuery = buildDeleteQuery(searchContext, SuggestionConstants.TYPE_SPELL_CHECKER);

		try {
			_elasticsearchClient.deleteByQuery(deleteQuery);

		}
		catch (Exception e) {
			if (_log.isDebugEnabled()) {
				_log.debug(e, e);
			}

			throw new SearchException(e.getMessage(), e);
		}
	}

	/**
	 * @param client
	 *            the client to set
	 */
	public void setElasticsearchClient(ElasticsearchNodeClient client) {

		this._elasticsearchClient = client;
	}

	protected DeleteByQueryRequest buildDeleteQuery(SearchContext searchContext, String type) {

		BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
		boolQueryBuilder.must(QueryBuilders.termQuery(Field.COMPANY_ID, searchContext.getCompanyId()));
		boolQueryBuilder.must(QueryBuilders.termQuery(Field.PORTLET_ID, PortletKeys.SEARCH));
		boolQueryBuilder.must(QueryBuilders.termQuery(Field.TYPE, type));

		DeleteByQueryRequest deleteByQueryRequest = new DeleteByQueryRequest();
		deleteByQueryRequest.query(boolQueryBuilder);

		return deleteByQueryRequest;
	}

	private static Log _log = LogFactoryUtil.getLog(ElasticsearchSpellCheckIndexWriter.class);

	private ElasticsearchNodeClient _elasticsearchClient;

}
