package com.liferay.portal.search.elasticsearch.servlet;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.liferay.portal.kernel.util.BasePortalLifecycle;
import com.liferay.portal.search.elasticsearch.ElasticsearchNodeClient;
import com.liferay.portal.search.elasticsearch.util.ElasticsearchUtil;

/**
 * 
 * @author Milen Dyankov
 *
 */
public class ElasticsearchServletContextListener extends BasePortalLifecycle implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent servletContextEvent) {

		portalDestroy();
	}

	@Override
	public void contextInitialized(ServletContextEvent servletContextEvent) {

		String servletContext = servletContextEvent.getServletContext().getServletContextName();
		elasticsearchNodeClient = ElasticsearchUtil.getClient(servletContext);
		registerPortalLifecycle();
	}

	@Override
	protected void doPortalDestroy()
		throws Exception {

		if (elasticsearchNodeClient != null) {
			elasticsearchNodeClient.stopLiferayClientNode();
		}
	}

	@Override
	protected void doPortalInit() {

		if (elasticsearchNodeClient != null) {
			elasticsearchNodeClient.startLiferayClientNode();
		}
	}

	private ElasticsearchNodeClient elasticsearchNodeClient;

}
