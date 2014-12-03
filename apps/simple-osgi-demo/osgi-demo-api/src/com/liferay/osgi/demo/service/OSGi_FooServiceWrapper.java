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

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link OSGi_FooService}.
 *
 * @author milen
 * @see OSGi_FooService
 * @generated
 */
@ProviderType
public class OSGi_FooServiceWrapper implements OSGi_FooService,
	ServiceWrapper<OSGi_FooService> {
	public OSGi_FooServiceWrapper(OSGi_FooService osGi_FooService) {
		_osGi_FooService = osGi_FooService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _osGi_FooService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_osGi_FooService.setBeanIdentifier(beanIdentifier);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	@Deprecated
	public OSGi_FooService getWrappedOSGi_FooService() {
		return _osGi_FooService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	@Deprecated
	public void setWrappedOSGi_FooService(OSGi_FooService osGi_FooService) {
		_osGi_FooService = osGi_FooService;
	}

	@Override
	public OSGi_FooService getWrappedService() {
		return _osGi_FooService;
	}

	@Override
	public void setWrappedService(OSGi_FooService osGi_FooService) {
		_osGi_FooService = osGi_FooService;
	}

	private OSGi_FooService _osGi_FooService;
}