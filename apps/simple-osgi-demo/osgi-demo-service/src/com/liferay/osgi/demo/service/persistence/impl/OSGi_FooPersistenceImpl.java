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

package com.liferay.osgi.demo.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.osgi.demo.exception.NoSuchOSGi_FooException;
import com.liferay.osgi.demo.model.OSGi_Foo;
import com.liferay.osgi.demo.model.impl.OSGi_FooImpl;
import com.liferay.osgi.demo.model.impl.OSGi_FooModelImpl;
import com.liferay.osgi.demo.service.persistence.OSGi_FooPersistence;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the o s gi_ foo service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author milen
 * @see OSGi_FooPersistence
 * @see OSGi_FooUtil
 * @generated
 */
@ProviderType
public class OSGi_FooPersistenceImpl extends BasePersistenceImpl<OSGi_Foo>
	implements OSGi_FooPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link OSGi_FooUtil} to access the o s gi_ foo persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = OSGi_FooImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(OSGi_FooModelImpl.ENTITY_CACHE_ENABLED,
			OSGi_FooModelImpl.FINDER_CACHE_ENABLED, OSGi_FooImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(OSGi_FooModelImpl.ENTITY_CACHE_ENABLED,
			OSGi_FooModelImpl.FINDER_CACHE_ENABLED, OSGi_FooImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(OSGi_FooModelImpl.ENTITY_CACHE_ENABLED,
			OSGi_FooModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_FIELD2 = new FinderPath(OSGi_FooModelImpl.ENTITY_CACHE_ENABLED,
			OSGi_FooModelImpl.FINDER_CACHE_ENABLED, OSGi_FooImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByField2",
			new String[] {
				Boolean.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FIELD2 =
		new FinderPath(OSGi_FooModelImpl.ENTITY_CACHE_ENABLED,
			OSGi_FooModelImpl.FINDER_CACHE_ENABLED, OSGi_FooImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByField2",
			new String[] { Boolean.class.getName() },
			OSGi_FooModelImpl.FIELD2_COLUMN_BITMASK |
			OSGi_FooModelImpl.FIELD1_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_FIELD2 = new FinderPath(OSGi_FooModelImpl.ENTITY_CACHE_ENABLED,
			OSGi_FooModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByField2",
			new String[] { Boolean.class.getName() });

	/**
	 * Returns all the o s gi_ foos where field2 = &#63;.
	 *
	 * @param field2 the field2
	 * @return the matching o s gi_ foos
	 */
	@Override
	public List<OSGi_Foo> findByField2(boolean field2) {
		return findByField2(field2, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<OSGi_Foo> findByField2(boolean field2, int start, int end) {
		return findByField2(field2, start, end, null);
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
	@Override
	public List<OSGi_Foo> findByField2(boolean field2, int start, int end,
		OrderByComparator<OSGi_Foo> orderByComparator) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FIELD2;
			finderArgs = new Object[] { field2 };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_FIELD2;
			finderArgs = new Object[] { field2, start, end, orderByComparator };
		}

		List<OSGi_Foo> list = (List<OSGi_Foo>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (OSGi_Foo osGi_Foo : list) {
				if ((field2 != osGi_Foo.getField2())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_OSGI_FOO_WHERE);

			query.append(_FINDER_COLUMN_FIELD2_FIELD2_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(OSGi_FooModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(field2);

				if (!pagination) {
					list = (List<OSGi_Foo>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<OSGi_Foo>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first o s gi_ foo in the ordered set where field2 = &#63;.
	 *
	 * @param field2 the field2
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching o s gi_ foo
	 * @throws com.liferay.osgi.demo.NoSuchOSGi_FooException if a matching o s gi_ foo could not be found
	 */
	@Override
	public OSGi_Foo findByField2_First(boolean field2,
		OrderByComparator<OSGi_Foo> orderByComparator)
		throws NoSuchOSGi_FooException {
		OSGi_Foo osGi_Foo = fetchByField2_First(field2, orderByComparator);

		if (osGi_Foo != null) {
			return osGi_Foo;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("field2=");
		msg.append(field2);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchOSGi_FooException(msg.toString());
	}

	/**
	 * Returns the first o s gi_ foo in the ordered set where field2 = &#63;.
	 *
	 * @param field2 the field2
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching o s gi_ foo, or <code>null</code> if a matching o s gi_ foo could not be found
	 */
	@Override
	public OSGi_Foo fetchByField2_First(boolean field2,
		OrderByComparator<OSGi_Foo> orderByComparator) {
		List<OSGi_Foo> list = findByField2(field2, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last o s gi_ foo in the ordered set where field2 = &#63;.
	 *
	 * @param field2 the field2
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching o s gi_ foo
	 * @throws com.liferay.osgi.demo.NoSuchOSGi_FooException if a matching o s gi_ foo could not be found
	 */
	@Override
	public OSGi_Foo findByField2_Last(boolean field2,
		OrderByComparator<OSGi_Foo> orderByComparator)
		throws NoSuchOSGi_FooException {
		OSGi_Foo osGi_Foo = fetchByField2_Last(field2, orderByComparator);

		if (osGi_Foo != null) {
			return osGi_Foo;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("field2=");
		msg.append(field2);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchOSGi_FooException(msg.toString());
	}

	/**
	 * Returns the last o s gi_ foo in the ordered set where field2 = &#63;.
	 *
	 * @param field2 the field2
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching o s gi_ foo, or <code>null</code> if a matching o s gi_ foo could not be found
	 */
	@Override
	public OSGi_Foo fetchByField2_Last(boolean field2,
		OrderByComparator<OSGi_Foo> orderByComparator) {
		int count = countByField2(field2);

		if (count == 0) {
			return null;
		}

		List<OSGi_Foo> list = findByField2(field2, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public OSGi_Foo[] findByField2_PrevAndNext(long fooId, boolean field2,
		OrderByComparator<OSGi_Foo> orderByComparator)
		throws NoSuchOSGi_FooException {
		OSGi_Foo osGi_Foo = findByPrimaryKey(fooId);

		Session session = null;

		try {
			session = openSession();

			OSGi_Foo[] array = new OSGi_FooImpl[3];

			array[0] = getByField2_PrevAndNext(session, osGi_Foo, field2,
					orderByComparator, true);

			array[1] = osGi_Foo;

			array[2] = getByField2_PrevAndNext(session, osGi_Foo, field2,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected OSGi_Foo getByField2_PrevAndNext(Session session,
		OSGi_Foo osGi_Foo, boolean field2,
		OrderByComparator<OSGi_Foo> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_OSGI_FOO_WHERE);

		query.append(_FINDER_COLUMN_FIELD2_FIELD2_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(OSGi_FooModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(field2);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(osGi_Foo);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<OSGi_Foo> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the o s gi_ foos where field2 = &#63; from the database.
	 *
	 * @param field2 the field2
	 */
	@Override
	public void removeByField2(boolean field2) {
		for (OSGi_Foo osGi_Foo : findByField2(field2, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(osGi_Foo);
		}
	}

	/**
	 * Returns the number of o s gi_ foos where field2 = &#63;.
	 *
	 * @param field2 the field2
	 * @return the number of matching o s gi_ foos
	 */
	@Override
	public int countByField2(boolean field2) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_FIELD2;

		Object[] finderArgs = new Object[] { field2 };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_OSGI_FOO_WHERE);

			query.append(_FINDER_COLUMN_FIELD2_FIELD2_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(field2);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_FIELD2_FIELD2_2 = "osGi_Foo.field2 = ?";

	public OSGi_FooPersistenceImpl() {
		setModelClass(OSGi_Foo.class);
	}

	/**
	 * Caches the o s gi_ foo in the entity cache if it is enabled.
	 *
	 * @param osGi_Foo the o s gi_ foo
	 */
	@Override
	public void cacheResult(OSGi_Foo osGi_Foo) {
		EntityCacheUtil.putResult(OSGi_FooModelImpl.ENTITY_CACHE_ENABLED,
			OSGi_FooImpl.class, osGi_Foo.getPrimaryKey(), osGi_Foo);

		osGi_Foo.resetOriginalValues();
	}

	/**
	 * Caches the o s gi_ foos in the entity cache if it is enabled.
	 *
	 * @param osGi_Foos the o s gi_ foos
	 */
	@Override
	public void cacheResult(List<OSGi_Foo> osGi_Foos) {
		for (OSGi_Foo osGi_Foo : osGi_Foos) {
			if (EntityCacheUtil.getResult(
						OSGi_FooModelImpl.ENTITY_CACHE_ENABLED,
						OSGi_FooImpl.class, osGi_Foo.getPrimaryKey()) == null) {
				cacheResult(osGi_Foo);
			}
			else {
				osGi_Foo.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all o s gi_ foos.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(OSGi_FooImpl.class.getName());
		}

		EntityCacheUtil.clearCache(OSGi_FooImpl.class);

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the o s gi_ foo.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(OSGi_Foo osGi_Foo) {
		EntityCacheUtil.removeResult(OSGi_FooModelImpl.ENTITY_CACHE_ENABLED,
			OSGi_FooImpl.class, osGi_Foo.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<OSGi_Foo> osGi_Foos) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (OSGi_Foo osGi_Foo : osGi_Foos) {
			EntityCacheUtil.removeResult(OSGi_FooModelImpl.ENTITY_CACHE_ENABLED,
				OSGi_FooImpl.class, osGi_Foo.getPrimaryKey());
		}
	}

	/**
	 * Creates a new o s gi_ foo with the primary key. Does not add the o s gi_ foo to the database.
	 *
	 * @param fooId the primary key for the new o s gi_ foo
	 * @return the new o s gi_ foo
	 */
	@Override
	public OSGi_Foo create(long fooId) {
		OSGi_Foo osGi_Foo = new OSGi_FooImpl();

		osGi_Foo.setNew(true);
		osGi_Foo.setPrimaryKey(fooId);

		return osGi_Foo;
	}

	/**
	 * Removes the o s gi_ foo with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param fooId the primary key of the o s gi_ foo
	 * @return the o s gi_ foo that was removed
	 * @throws com.liferay.osgi.demo.NoSuchOSGi_FooException if a o s gi_ foo with the primary key could not be found
	 */
	@Override
	public OSGi_Foo remove(long fooId) throws NoSuchOSGi_FooException {
		return remove((Serializable)fooId);
	}

	/**
	 * Removes the o s gi_ foo with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the o s gi_ foo
	 * @return the o s gi_ foo that was removed
	 * @throws com.liferay.osgi.demo.NoSuchOSGi_FooException if a o s gi_ foo with the primary key could not be found
	 */
	@Override
	public OSGi_Foo remove(Serializable primaryKey)
		throws NoSuchOSGi_FooException {
		Session session = null;

		try {
			session = openSession();

			OSGi_Foo osGi_Foo = (OSGi_Foo)session.get(OSGi_FooImpl.class,
					primaryKey);

			if (osGi_Foo == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchOSGi_FooException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(osGi_Foo);
		}
		catch (NoSuchOSGi_FooException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected OSGi_Foo removeImpl(OSGi_Foo osGi_Foo) {
		osGi_Foo = toUnwrappedModel(osGi_Foo);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(osGi_Foo)) {
				osGi_Foo = (OSGi_Foo)session.get(OSGi_FooImpl.class,
						osGi_Foo.getPrimaryKeyObj());
			}

			if (osGi_Foo != null) {
				session.delete(osGi_Foo);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (osGi_Foo != null) {
			clearCache(osGi_Foo);
		}

		return osGi_Foo;
	}

	@Override
	public OSGi_Foo updateImpl(com.liferay.osgi.demo.model.OSGi_Foo osGi_Foo) {
		osGi_Foo = toUnwrappedModel(osGi_Foo);

		boolean isNew = osGi_Foo.isNew();

		OSGi_FooModelImpl osGi_FooModelImpl = (OSGi_FooModelImpl)osGi_Foo;

		Session session = null;

		try {
			session = openSession();

			if (osGi_Foo.isNew()) {
				session.save(osGi_Foo);

				osGi_Foo.setNew(false);
			}
			else {
				session.merge(osGi_Foo);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !OSGi_FooModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((osGi_FooModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FIELD2.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						osGi_FooModelImpl.getOriginalField2()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FIELD2, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FIELD2,
					args);

				args = new Object[] { osGi_FooModelImpl.getField2() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_FIELD2, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_FIELD2,
					args);
			}
		}

		EntityCacheUtil.putResult(OSGi_FooModelImpl.ENTITY_CACHE_ENABLED,
			OSGi_FooImpl.class, osGi_Foo.getPrimaryKey(), osGi_Foo, false);

		osGi_Foo.resetOriginalValues();

		return osGi_Foo;
	}

	protected OSGi_Foo toUnwrappedModel(OSGi_Foo osGi_Foo) {
		if (osGi_Foo instanceof OSGi_FooImpl) {
			return osGi_Foo;
		}

		OSGi_FooImpl osGi_FooImpl = new OSGi_FooImpl();

		osGi_FooImpl.setNew(osGi_Foo.isNew());
		osGi_FooImpl.setPrimaryKey(osGi_Foo.getPrimaryKey());

		osGi_FooImpl.setFooId(osGi_Foo.getFooId());
		osGi_FooImpl.setGroupId(osGi_Foo.getGroupId());
		osGi_FooImpl.setCompanyId(osGi_Foo.getCompanyId());
		osGi_FooImpl.setUserId(osGi_Foo.getUserId());
		osGi_FooImpl.setUserName(osGi_Foo.getUserName());
		osGi_FooImpl.setCreateDate(osGi_Foo.getCreateDate());
		osGi_FooImpl.setModifiedDate(osGi_Foo.getModifiedDate());
		osGi_FooImpl.setField1(osGi_Foo.getField1());
		osGi_FooImpl.setField2(osGi_Foo.isField2());
		osGi_FooImpl.setField3(osGi_Foo.getField3());
		osGi_FooImpl.setField4(osGi_Foo.getField4());
		osGi_FooImpl.setField5(osGi_Foo.getField5());

		return osGi_FooImpl;
	}

	/**
	 * Returns the o s gi_ foo with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the o s gi_ foo
	 * @return the o s gi_ foo
	 * @throws com.liferay.osgi.demo.NoSuchOSGi_FooException if a o s gi_ foo with the primary key could not be found
	 */
	@Override
	public OSGi_Foo findByPrimaryKey(Serializable primaryKey)
		throws NoSuchOSGi_FooException {
		OSGi_Foo osGi_Foo = fetchByPrimaryKey(primaryKey);

		if (osGi_Foo == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchOSGi_FooException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return osGi_Foo;
	}

	/**
	 * Returns the o s gi_ foo with the primary key or throws a {@link com.liferay.osgi.demo.NoSuchOSGi_FooException} if it could not be found.
	 *
	 * @param fooId the primary key of the o s gi_ foo
	 * @return the o s gi_ foo
	 * @throws com.liferay.osgi.demo.NoSuchOSGi_FooException if a o s gi_ foo with the primary key could not be found
	 */
	@Override
	public OSGi_Foo findByPrimaryKey(long fooId) throws NoSuchOSGi_FooException {
		return findByPrimaryKey((Serializable)fooId);
	}

	/**
	 * Returns the o s gi_ foo with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the o s gi_ foo
	 * @return the o s gi_ foo, or <code>null</code> if a o s gi_ foo with the primary key could not be found
	 */
	@Override
	public OSGi_Foo fetchByPrimaryKey(Serializable primaryKey) {
		OSGi_Foo osGi_Foo = (OSGi_Foo)EntityCacheUtil.getResult(OSGi_FooModelImpl.ENTITY_CACHE_ENABLED,
				OSGi_FooImpl.class, primaryKey);

		if (osGi_Foo == _nullOSGi_Foo) {
			return null;
		}

		if (osGi_Foo == null) {
			Session session = null;

			try {
				session = openSession();

				osGi_Foo = (OSGi_Foo)session.get(OSGi_FooImpl.class, primaryKey);

				if (osGi_Foo != null) {
					cacheResult(osGi_Foo);
				}
				else {
					EntityCacheUtil.putResult(OSGi_FooModelImpl.ENTITY_CACHE_ENABLED,
						OSGi_FooImpl.class, primaryKey, _nullOSGi_Foo);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(OSGi_FooModelImpl.ENTITY_CACHE_ENABLED,
					OSGi_FooImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return osGi_Foo;
	}

	/**
	 * Returns the o s gi_ foo with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param fooId the primary key of the o s gi_ foo
	 * @return the o s gi_ foo, or <code>null</code> if a o s gi_ foo with the primary key could not be found
	 */
	@Override
	public OSGi_Foo fetchByPrimaryKey(long fooId) {
		return fetchByPrimaryKey((Serializable)fooId);
	}

	@Override
	public Map<Serializable, OSGi_Foo> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, OSGi_Foo> map = new HashMap<Serializable, OSGi_Foo>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			OSGi_Foo osGi_Foo = fetchByPrimaryKey(primaryKey);

			if (osGi_Foo != null) {
				map.put(primaryKey, osGi_Foo);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			OSGi_Foo osGi_Foo = (OSGi_Foo)EntityCacheUtil.getResult(OSGi_FooModelImpl.ENTITY_CACHE_ENABLED,
					OSGi_FooImpl.class, primaryKey);

			if (osGi_Foo == null) {
				if (uncachedPrimaryKeys == null) {
					uncachedPrimaryKeys = new HashSet<Serializable>();
				}

				uncachedPrimaryKeys.add(primaryKey);
			}
			else {
				map.put(primaryKey, osGi_Foo);
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_OSGI_FOO_WHERE_PKS_IN);

		for (Serializable primaryKey : uncachedPrimaryKeys) {
			query.append(String.valueOf(primaryKey));

			query.append(StringPool.COMMA);
		}

		query.setIndex(query.index() - 1);

		query.append(StringPool.CLOSE_PARENTHESIS);

		String sql = query.toString();

		Session session = null;

		try {
			session = openSession();

			Query q = session.createQuery(sql);

			for (OSGi_Foo osGi_Foo : (List<OSGi_Foo>)q.list()) {
				map.put(osGi_Foo.getPrimaryKeyObj(), osGi_Foo);

				cacheResult(osGi_Foo);

				uncachedPrimaryKeys.remove(osGi_Foo.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				EntityCacheUtil.putResult(OSGi_FooModelImpl.ENTITY_CACHE_ENABLED,
					OSGi_FooImpl.class, primaryKey, _nullOSGi_Foo);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		return map;
	}

	/**
	 * Returns all the o s gi_ foos.
	 *
	 * @return the o s gi_ foos
	 */
	@Override
	public List<OSGi_Foo> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<OSGi_Foo> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<OSGi_Foo> findAll(int start, int end,
		OrderByComparator<OSGi_Foo> orderByComparator) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<OSGi_Foo> list = (List<OSGi_Foo>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_OSGI_FOO);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_OSGI_FOO;

				if (pagination) {
					sql = sql.concat(OSGi_FooModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<OSGi_Foo>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<OSGi_Foo>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the o s gi_ foos from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (OSGi_Foo osGi_Foo : findAll()) {
			remove(osGi_Foo);
		}
	}

	/**
	 * Returns the number of o s gi_ foos.
	 *
	 * @return the number of o s gi_ foos
	 */
	@Override
	public int countAll() {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_OSGI_FOO);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the o s gi_ foo persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		EntityCacheUtil.removeCache(OSGi_FooImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_OSGI_FOO = "SELECT osGi_Foo FROM OSGi_Foo osGi_Foo";
	private static final String _SQL_SELECT_OSGI_FOO_WHERE_PKS_IN = "SELECT osGi_Foo FROM OSGi_Foo osGi_Foo WHERE fooId IN (";
	private static final String _SQL_SELECT_OSGI_FOO_WHERE = "SELECT osGi_Foo FROM OSGi_Foo osGi_Foo WHERE ";
	private static final String _SQL_COUNT_OSGI_FOO = "SELECT COUNT(osGi_Foo) FROM OSGi_Foo osGi_Foo";
	private static final String _SQL_COUNT_OSGI_FOO_WHERE = "SELECT COUNT(osGi_Foo) FROM OSGi_Foo osGi_Foo WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "osGi_Foo.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No OSGi_Foo exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No OSGi_Foo exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = com.liferay.portal.util.PropsValues.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE;
	private static final Log _log = LogFactoryUtil.getLog(OSGi_FooPersistenceImpl.class);
	private static final OSGi_Foo _nullOSGi_Foo = new OSGi_FooImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<OSGi_Foo> toCacheModel() {
				return _nullOSGi_FooCacheModel;
			}
		};

	private static final CacheModel<OSGi_Foo> _nullOSGi_FooCacheModel = new CacheModel<OSGi_Foo>() {
			@Override
			public OSGi_Foo toEntityModel() {
				return _nullOSGi_Foo;
			}
		};
}