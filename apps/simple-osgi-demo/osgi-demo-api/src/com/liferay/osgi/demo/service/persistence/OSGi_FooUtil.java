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

package com.liferay.osgi.demo.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.osgi.demo.model.OSGi_Foo;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.service.ServiceContext;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the o s gi_ foo service. This utility wraps {@link OSGi_FooPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author milen
 * @see OSGi_FooPersistence
 * @see OSGi_FooPersistenceImpl
 * @generated
 */
@ProviderType
public class OSGi_FooUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(OSGi_Foo osGi_Foo) {
		getPersistence().clearCache(osGi_Foo);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<OSGi_Foo> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<OSGi_Foo> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<OSGi_Foo> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<OSGi_Foo> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static OSGi_Foo update(OSGi_Foo osGi_Foo) {
		return getPersistence().update(osGi_Foo);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static OSGi_Foo update(OSGi_Foo osGi_Foo,
		ServiceContext serviceContext) {
		return getPersistence().update(osGi_Foo, serviceContext);
	}

	/**
	* Returns all the o s gi_ foos where field2 = &#63;.
	*
	* @param field2 the field2
	* @return the matching o s gi_ foos
	*/
	public static java.util.List<com.liferay.osgi.demo.model.OSGi_Foo> findByField2(
		boolean field2) {
		return getPersistence().findByField2(field2);
	}

	/**
	* Returns a range of all the o s gi_ foos where field2 = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.osgi.demo.model.impl.OSGi_FooModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param field2 the field2
	* @param start the lower bound of the range of o s gi_ foos
	* @param end the upper bound of the range of o s gi_ foos (not inclusive)
	* @return the range of matching o s gi_ foos
	*/
	public static java.util.List<com.liferay.osgi.demo.model.OSGi_Foo> findByField2(
		boolean field2, int start, int end) {
		return getPersistence().findByField2(field2, start, end);
	}

	/**
	* Returns an ordered range of all the o s gi_ foos where field2 = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.osgi.demo.model.impl.OSGi_FooModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param field2 the field2
	* @param start the lower bound of the range of o s gi_ foos
	* @param end the upper bound of the range of o s gi_ foos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching o s gi_ foos
	*/
	public static java.util.List<com.liferay.osgi.demo.model.OSGi_Foo> findByField2(
		boolean field2, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.osgi.demo.model.OSGi_Foo> orderByComparator) {
		return getPersistence()
				   .findByField2(field2, start, end, orderByComparator);
	}

	/**
	* Returns the first o s gi_ foo in the ordered set where field2 = &#63;.
	*
	* @param field2 the field2
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching o s gi_ foo
	* @throws com.liferay.osgi.demo.NoSuchOSGi_FooException if a matching o s gi_ foo could not be found
	*/
	public static com.liferay.osgi.demo.model.OSGi_Foo findByField2_First(
		boolean field2,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.osgi.demo.model.OSGi_Foo> orderByComparator)
		throws com.liferay.osgi.demo.exception.NoSuchOSGi_FooException {
		return getPersistence().findByField2_First(field2, orderByComparator);
	}

	/**
	* Returns the first o s gi_ foo in the ordered set where field2 = &#63;.
	*
	* @param field2 the field2
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching o s gi_ foo, or <code>null</code> if a matching o s gi_ foo could not be found
	*/
	public static com.liferay.osgi.demo.model.OSGi_Foo fetchByField2_First(
		boolean field2,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.osgi.demo.model.OSGi_Foo> orderByComparator) {
		return getPersistence().fetchByField2_First(field2, orderByComparator);
	}

	/**
	* Returns the last o s gi_ foo in the ordered set where field2 = &#63;.
	*
	* @param field2 the field2
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching o s gi_ foo
	* @throws com.liferay.osgi.demo.NoSuchOSGi_FooException if a matching o s gi_ foo could not be found
	*/
	public static com.liferay.osgi.demo.model.OSGi_Foo findByField2_Last(
		boolean field2,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.osgi.demo.model.OSGi_Foo> orderByComparator)
		throws com.liferay.osgi.demo.exception.NoSuchOSGi_FooException {
		return getPersistence().findByField2_Last(field2, orderByComparator);
	}

	/**
	* Returns the last o s gi_ foo in the ordered set where field2 = &#63;.
	*
	* @param field2 the field2
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching o s gi_ foo, or <code>null</code> if a matching o s gi_ foo could not be found
	*/
	public static com.liferay.osgi.demo.model.OSGi_Foo fetchByField2_Last(
		boolean field2,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.osgi.demo.model.OSGi_Foo> orderByComparator) {
		return getPersistence().fetchByField2_Last(field2, orderByComparator);
	}

	/**
	* Returns the o s gi_ foos before and after the current o s gi_ foo in the ordered set where field2 = &#63;.
	*
	* @param fooId the primary key of the current o s gi_ foo
	* @param field2 the field2
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next o s gi_ foo
	* @throws com.liferay.osgi.demo.NoSuchOSGi_FooException if a o s gi_ foo with the primary key could not be found
	*/
	public static com.liferay.osgi.demo.model.OSGi_Foo[] findByField2_PrevAndNext(
		long fooId, boolean field2,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.osgi.demo.model.OSGi_Foo> orderByComparator)
		throws com.liferay.osgi.demo.exception.NoSuchOSGi_FooException {
		return getPersistence()
				   .findByField2_PrevAndNext(fooId, field2, orderByComparator);
	}

	/**
	* Removes all the o s gi_ foos where field2 = &#63; from the database.
	*
	* @param field2 the field2
	*/
	public static void removeByField2(boolean field2) {
		getPersistence().removeByField2(field2);
	}

	/**
	* Returns the number of o s gi_ foos where field2 = &#63;.
	*
	* @param field2 the field2
	* @return the number of matching o s gi_ foos
	*/
	public static int countByField2(boolean field2) {
		return getPersistence().countByField2(field2);
	}

	/**
	* Caches the o s gi_ foo in the entity cache if it is enabled.
	*
	* @param osGi_Foo the o s gi_ foo
	*/
	public static void cacheResult(
		com.liferay.osgi.demo.model.OSGi_Foo osGi_Foo) {
		getPersistence().cacheResult(osGi_Foo);
	}

	/**
	* Caches the o s gi_ foos in the entity cache if it is enabled.
	*
	* @param osGi_Foos the o s gi_ foos
	*/
	public static void cacheResult(
		java.util.List<com.liferay.osgi.demo.model.OSGi_Foo> osGi_Foos) {
		getPersistence().cacheResult(osGi_Foos);
	}

	/**
	* Creates a new o s gi_ foo with the primary key. Does not add the o s gi_ foo to the database.
	*
	* @param fooId the primary key for the new o s gi_ foo
	* @return the new o s gi_ foo
	*/
	public static com.liferay.osgi.demo.model.OSGi_Foo create(long fooId) {
		return getPersistence().create(fooId);
	}

	/**
	* Removes the o s gi_ foo with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param fooId the primary key of the o s gi_ foo
	* @return the o s gi_ foo that was removed
	* @throws com.liferay.osgi.demo.NoSuchOSGi_FooException if a o s gi_ foo with the primary key could not be found
	*/
	public static com.liferay.osgi.demo.model.OSGi_Foo remove(long fooId)
		throws com.liferay.osgi.demo.exception.NoSuchOSGi_FooException {
		return getPersistence().remove(fooId);
	}

	public static com.liferay.osgi.demo.model.OSGi_Foo updateImpl(
		com.liferay.osgi.demo.model.OSGi_Foo osGi_Foo) {
		return getPersistence().updateImpl(osGi_Foo);
	}

	/**
	* Returns the o s gi_ foo with the primary key or throws a {@link com.liferay.osgi.demo.NoSuchOSGi_FooException} if it could not be found.
	*
	* @param fooId the primary key of the o s gi_ foo
	* @return the o s gi_ foo
	* @throws com.liferay.osgi.demo.NoSuchOSGi_FooException if a o s gi_ foo with the primary key could not be found
	*/
	public static com.liferay.osgi.demo.model.OSGi_Foo findByPrimaryKey(
		long fooId)
		throws com.liferay.osgi.demo.exception.NoSuchOSGi_FooException {
		return getPersistence().findByPrimaryKey(fooId);
	}

	/**
	* Returns the o s gi_ foo with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param fooId the primary key of the o s gi_ foo
	* @return the o s gi_ foo, or <code>null</code> if a o s gi_ foo with the primary key could not be found
	*/
	public static com.liferay.osgi.demo.model.OSGi_Foo fetchByPrimaryKey(
		long fooId) {
		return getPersistence().fetchByPrimaryKey(fooId);
	}

	public static java.util.Map<java.io.Serializable, com.liferay.osgi.demo.model.OSGi_Foo> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the o s gi_ foos.
	*
	* @return the o s gi_ foos
	*/
	public static java.util.List<com.liferay.osgi.demo.model.OSGi_Foo> findAll() {
		return getPersistence().findAll();
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
	public static java.util.List<com.liferay.osgi.demo.model.OSGi_Foo> findAll(
		int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the o s gi_ foos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.osgi.demo.model.impl.OSGi_FooModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of o s gi_ foos
	* @param end the upper bound of the range of o s gi_ foos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of o s gi_ foos
	*/
	public static java.util.List<com.liferay.osgi.demo.model.OSGi_Foo> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.osgi.demo.model.OSGi_Foo> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the o s gi_ foos from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of o s gi_ foos.
	*
	* @return the number of o s gi_ foos
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static OSGi_FooPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	@Deprecated
	public void setPersistence(OSGi_FooPersistence persistence) {
	}

	private static ServiceTracker<OSGi_FooPersistence, OSGi_FooPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(OSGi_FooUtil.class);

		_serviceTracker = new ServiceTracker<OSGi_FooPersistence, OSGi_FooPersistence>(bundle.getBundleContext(),
				OSGi_FooPersistence.class, null);

		_serviceTracker.open();
	}
}