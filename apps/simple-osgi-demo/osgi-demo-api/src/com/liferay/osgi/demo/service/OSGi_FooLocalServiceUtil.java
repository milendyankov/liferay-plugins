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
 * Provides the local service utility for OSGi_Foo. This utility wraps
 * {@link com.liferay.osgi.demo.service.impl.OSGi_FooLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author milen
 * @see OSGi_FooLocalService
 * @see com.liferay.osgi.demo.service.base.OSGi_FooLocalServiceBaseImpl
 * @see com.liferay.osgi.demo.service.impl.OSGi_FooLocalServiceImpl
 * @generated
 */
@ProviderType
public class OSGi_FooLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.osgi.demo.service.impl.OSGi_FooLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the o s gi_ foo to the database. Also notifies the appropriate model listeners.
	*
	* @param osGi_Foo the o s gi_ foo
	* @return the o s gi_ foo that was added
	*/
	public static com.liferay.osgi.demo.model.OSGi_Foo addOSGi_Foo(
		com.liferay.osgi.demo.model.OSGi_Foo osGi_Foo) {
		return getService().addOSGi_Foo(osGi_Foo);
	}

	/**
	* Creates a new o s gi_ foo with the primary key. Does not add the o s gi_ foo to the database.
	*
	* @param fooId the primary key for the new o s gi_ foo
	* @return the new o s gi_ foo
	*/
	public static com.liferay.osgi.demo.model.OSGi_Foo createOSGi_Foo(
		long fooId) {
		return getService().createOSGi_Foo(fooId);
	}

	/**
	* Deletes the o s gi_ foo with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param fooId the primary key of the o s gi_ foo
	* @return the o s gi_ foo that was removed
	* @throws PortalException if a o s gi_ foo with the primary key could not be found
	*/
	public static com.liferay.osgi.demo.model.OSGi_Foo deleteOSGi_Foo(
		long fooId) throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteOSGi_Foo(fooId);
	}

	/**
	* Deletes the o s gi_ foo from the database. Also notifies the appropriate model listeners.
	*
	* @param osGi_Foo the o s gi_ foo
	* @return the o s gi_ foo that was removed
	*/
	public static com.liferay.osgi.demo.model.OSGi_Foo deleteOSGi_Foo(
		com.liferay.osgi.demo.model.OSGi_Foo osGi_Foo) {
		return getService().deleteOSGi_Foo(osGi_Foo);
	}

	/**
	* @throws PortalException
	*/
	public static com.liferay.portal.model.PersistedModel deletePersistedModel(
		com.liferay.portal.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deletePersistedModel(persistedModel);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.osgi.demo.model.impl.OSGi_FooModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.osgi.demo.model.impl.OSGi_FooModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.liferay.osgi.demo.model.OSGi_Foo fetchOSGi_Foo(long fooId) {
		return getService().fetchOSGi_Foo(fooId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return getService().getActionableDynamicQuery();
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Returns the o s gi_ foo with the primary key.
	*
	* @param fooId the primary key of the o s gi_ foo
	* @return the o s gi_ foo
	* @throws PortalException if a o s gi_ foo with the primary key could not be found
	*/
	public static com.liferay.osgi.demo.model.OSGi_Foo getOSGi_Foo(long fooId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getOSGi_Foo(fooId);
	}

	/**
	* Returns a range of all the o s gi_ foos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.osgi.demo.model.impl.OSGi_FooModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of o s gi_ foos
	* @param end the upper bound of the range of o s gi_ foos (not inclusive)
	* @return the range of o s gi_ foos
	*/
	public static java.util.List<com.liferay.osgi.demo.model.OSGi_Foo> getOSGi_Foos(
		int start, int end) {
		return getService().getOSGi_Foos(start, end);
	}

	/**
	* Returns the number of o s gi_ foos.
	*
	* @return the number of o s gi_ foos
	*/
	public static int getOSGi_FoosCount() {
		return getService().getOSGi_FoosCount();
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	/**
	* Updates the o s gi_ foo in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param osGi_Foo the o s gi_ foo
	* @return the o s gi_ foo that was updated
	*/
	public static com.liferay.osgi.demo.model.OSGi_Foo updateOSGi_Foo(
		com.liferay.osgi.demo.model.OSGi_Foo osGi_Foo) {
		return getService().updateOSGi_Foo(osGi_Foo);
	}

	public static OSGi_FooLocalService getService() {
		return _serviceTracker.getService();
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	@Deprecated
	public void setService(OSGi_FooLocalService service) {
	}

	private static ServiceTracker<OSGi_FooLocalService, OSGi_FooLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(OSGi_FooLocalServiceUtil.class);

		_serviceTracker = new ServiceTracker<OSGi_FooLocalService, OSGi_FooLocalService>(bundle.getBundleContext(),
				OSGi_FooLocalService.class, null);

		_serviceTracker.open();
	}
}