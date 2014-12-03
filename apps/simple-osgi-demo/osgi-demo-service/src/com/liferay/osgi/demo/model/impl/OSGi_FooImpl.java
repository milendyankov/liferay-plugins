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

package com.liferay.osgi.demo.model.impl;

import aQute.bnd.annotation.ProviderType;

/**
 * The extended model implementation for the OSGi_Foo service. Represents a row in the &quot;OSGi_Foo&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.osgi.demo.model.OSGi_Foo} interface.
 * </p>
 *
 * @author milen
 */
@ProviderType
public class OSGi_FooImpl extends OSGi_FooBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. All methods that expect a o s gi_ foo model instance should use the {@link com.liferay.osgi.demo.model.OSGi_Foo} interface instead.
	 */
	public OSGi_FooImpl() {
	}
}