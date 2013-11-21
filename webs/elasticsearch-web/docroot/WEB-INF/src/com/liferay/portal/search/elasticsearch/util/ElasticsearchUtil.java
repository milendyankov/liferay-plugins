
package com.liferay.portal.search.elasticsearch.util;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.search.elasticsearch.ElasticsearchNodeClient;

/**
 * 
 * @author Milen Dyankov
 *
 */
public class ElasticsearchUtil {

	public static ElasticsearchNodeClient getClient(String servletContextName) {

		if (_client == null) {
			_client = (ElasticsearchNodeClient) PortletBeanLocatorUtil.locate(servletContextName, ElasticsearchNodeClient.class.getName());
		}

		return _client;
	}

	private static ElasticsearchNodeClient _client;
}
