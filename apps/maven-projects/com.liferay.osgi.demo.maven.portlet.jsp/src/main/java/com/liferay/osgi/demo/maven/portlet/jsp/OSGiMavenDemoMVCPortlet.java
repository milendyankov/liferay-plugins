package com.liferay.osgi.demo.maven.portlet.jsp;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

@Component(
		immediate = true, 
		property = {
			"com.liferay.portlet.css-class-wrapper=portlet-osgi-demo-maven",
			"com.liferay.portlet.display-category=category.sample",
			"com.liferay.portlet.instanceable=true",
			"com.liferay.portlet.preferences-owned-by-group=true",
			"com.liferay.portlet.private-request-attributes=false",
			"com.liferay.portlet.private-session-attributes=false",
			"com.liferay.portlet.render-weight=50",
			"javax.portlet.display-name=OSGI maven demo portlet",
			"javax.portlet.expiration-cache=0",
            "javax.portlet.init-param.template-path=/",
            "javax.portlet.init-param.view-template=/view.jsp",
			"javax.portlet.security-role-ref=power-user,user" }, 
		service = Portlet.class)

public class OSGiMavenDemoMVCPortlet extends MVCPortlet {


}
