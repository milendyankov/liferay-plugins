package com.liferay.test;

import java.io.IOException;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.demo.service.FooLocalService;
import com.liferay.demo.service.FooLocalServiceUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;



/**
 * Portlet implementation class OtherPluginsService
 */
public class SamePluginsService extends MVCPortlet {
  
	@Override
	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {

		FooLocalService service = FooLocalServiceUtil.getService();

		renderResponse.getWriter().write("Service is " + service.getClass().getName());
	}

}
