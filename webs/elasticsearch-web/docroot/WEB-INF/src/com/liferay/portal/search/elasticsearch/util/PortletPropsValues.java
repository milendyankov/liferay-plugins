
package com.liferay.portal.search.elasticsearch.util;

import com.liferay.util.portlet.PortletProps;

/**
 * @author Milen Dyankov
 */
public class PortletPropsValues {

	public static final String ELASTICSEARCH_CLUSTER_NAME = PortletProps.get(
		PortletPropsKeys.ELASTICSEARCH_CLUSTER_NAME);

	public static final String ELASTICSEARCH_INDEX_DOCUMENT_TYPE = PortletProps.get(
		PortletPropsKeys.ELASTICSEARCH_INDEX_DOCUMENT_TYPE);

	public static final String ELASTICSEARCH_INDEX_MAPPINGS = PortletProps.get(
		PortletPropsKeys.ELASTICSEARCH_INDEX_MAPPINGS);

	public static final String ELASTICSEARCH_INDEX_NAME = PortletProps.get(
		PortletPropsKeys.ELASTICSEARCH_INDEX_NAME);

	public static final String ELASTICSEARCH_INDEX_NUMBER_OF_SHARDS = PortletProps.get(
		PortletPropsKeys.ELASTICSEARCH_INDEX_NUMBER_OF_SHARDS);
	
	public static final String ELASTICSEARCH_INDEX_NUMBER_OF_REPLICAS = PortletProps.get(
		PortletPropsKeys.ELASTICSEARCH_INDEX_NUMBER_OF_REPLICAS);

	public static final String ELASTICSEARCH_NODE_NAME = PortletProps.get(
		PortletPropsKeys.ELASTICSEARCH_NODE_NAME);


}