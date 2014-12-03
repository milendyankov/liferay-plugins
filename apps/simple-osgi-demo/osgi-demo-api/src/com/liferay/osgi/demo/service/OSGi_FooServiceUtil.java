/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
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

package com.liferay.osgi.demo.service;

import aQute.bnd.annotation.ProviderType;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the remote service utility for OSGi_Foo. This utility wraps
 * {@link com.liferay.osgi.demo.service.impl.OSGi_FooServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author milen
 * @see OSGi_FooService
 * @see com.liferay.osgi.demo.service.base.OSGi_FooServiceBaseImpl
 * @see com.liferay.osgi.demo.service.impl.OSGi_FooServiceImpl
 * @generated
 */
@ProviderType
public class OSGi_FooServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.osgi.demo.service.impl.OSGi_FooServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static OSGi_FooService getService() {
		return _serviceTracker.getService();
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	@Deprecated
	public void setService(OSGi_FooService service) {
	}

	private static ServiceTracker<OSGi_FooService, OSGi_FooService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(OSGi_FooServiceUtil.class);

		_serviceTracker = new ServiceTracker<OSGi_FooService, OSGi_FooService>(bundle.getBundleContext(),
				OSGi_FooService.class, null);

		_serviceTracker.open();
	}
}