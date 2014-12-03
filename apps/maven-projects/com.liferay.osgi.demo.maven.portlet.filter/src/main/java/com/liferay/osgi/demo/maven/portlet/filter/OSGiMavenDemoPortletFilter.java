package com.liferay.osgi.demo.maven.portlet.filter;

import java.io.IOException;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.filter.FilterChain;
import javax.portlet.filter.FilterConfig;
import javax.portlet.filter.PortletFilter;
import javax.portlet.filter.RenderFilter;

import org.osgi.service.component.annotations.Component;

@Component(
		immediate = true, 
		property = {
				"javax.portlet.name=com_liferay_osgi_demo_maven_portlet_OSGiMavenDemoPortlet"	
		}, 
		service = PortletFilter.class)
public class OSGiMavenDemoPortletFilter implements RenderFilter {

	@Override
	public void doFilter(RenderRequest request, RenderResponse response,
			FilterChain chain) throws IOException, PortletException {
		System.out.println("Before filter");
		request.setAttribute("CUSTOM_ATTRIBUTE", "my custom attribute value");
		chain.doFilter(request, response);
		System.out.println("After filter");
	}

	@Override
	public void init(FilterConfig filterConfig) throws PortletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	

}
