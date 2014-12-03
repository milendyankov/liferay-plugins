package com.liferay.osgi.demo.portlet;

import java.io.IOException;
import java.io.Writer;

import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ReferencePolicy;

import com.liferay.osgi.demo.service.OSGi_FooLocalService;
import com.liferay.osgi.demo.service.OSGi_FooLocalServiceUtil;
import com.liferay.portal.model.Portlet;

@Component(
		immediate = true,
        property = {
                "com.liferay.portlet.css-class-wrapper=portlet-osgi-demo",
                "com.liferay.portlet.display-category=category.sample",
                "com.liferay.portlet.instanceable=true",
                "com.liferay.portlet.preferences-owned-by-group=true",
                "com.liferay.portlet.private-request-attributes=false",
                "com.liferay.portlet.private-session-attributes=false",
                "com.liferay.portlet.render-weight=50",
                "javax.portlet.display-name=OSGI demo portlet",
                "javax.portlet.expiration-cache=0",
                "javax.portlet.security-role-ref=power-user,user"
        },
        service = Portlet.class
)
public class OSGiDemoPortlet extends GenericPortlet {

	private OSGi_FooLocalService service;

	@Override
	protected void doView(RenderRequest request, RenderResponse response)
			throws PortletException, IOException {

		OSGi_FooLocalService service = OSGi_FooLocalServiceUtil.getService();

		Writer writer = response.getWriter();
		writer.write("Service (from service registry) is: "
				+ service.getClass().getName());
		writer.write("Service (from service registry) is: "
				+ service.getClass().getName());

		super.doView(request, response);
	}

	@Reference(
			cardinality = ReferenceCardinality.MANDATORY, 
			policy = ReferencePolicy.STATIC)
	protected void setService(OSGi_FooLocalService service) {
		this.service = service;
	}
}
