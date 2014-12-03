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

package com.liferay.osgi.demo.service.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.osgi.demo.service.base.OSGi_FooLocalServiceBaseImpl;

/**
 * The implementation of the o s gi_ foo local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.osgi.demo.service.OSGi_FooLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author milen
 * @see com.liferay.osgi.demo.service.base.OSGi_FooLocalServiceBaseImpl
 * @see com.liferay.osgi.demo.service.OSGi_FooLocalServiceUtil
 */
@ProviderType
public class OSGi_FooLocalServiceImpl extends OSGi_FooLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.liferay.osgi.demo.service.OSGi_FooLocalServiceUtil} to access the o s gi_ foo local service.
	 */
}