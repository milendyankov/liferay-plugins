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

import com.liferay.osgi.demo.exception.NoSuchOSGi_FooException;
import com.liferay.osgi.demo.model.OSGi_Foo;
import com.liferay.osgi.demo.service.OSGi_FooLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.test.AggregateTestRule;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.util.IntegerWrapper;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.kernel.util.Time;
import com.liferay.portal.test.PersistenceTestRule;
import com.liferay.portal.test.TransactionalTestRule;
import com.liferay.portal.util.test.RandomTestUtil;

import org.jboss.arquillian.junit.Arquillian;

import org.junit.After;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

import org.junit.runner.RunWith;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @generated
 */
@RunWith(Arquillian.class)
public class OSGi_FooPersistenceTest {
	@Rule
	public final AggregateTestRule aggregateTestRule = new AggregateTestRule(PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(Propagation.REQUIRED));

	@After
	public void tearDown() throws Exception {
		Iterator<OSGi_Foo> iterator = _osGi_Foos.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		OSGi_Foo osGi_Foo = _persistence.create(pk);

		Assert.assertNotNull(osGi_Foo);

		Assert.assertEquals(osGi_Foo.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		OSGi_Foo newOSGi_Foo = addOSGi_Foo();

		_persistence.remove(newOSGi_Foo);

		OSGi_Foo existingOSGi_Foo = _persistence.fetchByPrimaryKey(newOSGi_Foo.getPrimaryKey());

		Assert.assertNull(existingOSGi_Foo);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addOSGi_Foo();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		OSGi_Foo newOSGi_Foo = _persistence.create(pk);

		newOSGi_Foo.setGroupId(RandomTestUtil.nextLong());

		newOSGi_Foo.setCompanyId(RandomTestUtil.nextLong());

		newOSGi_Foo.setUserId(RandomTestUtil.nextLong());

		newOSGi_Foo.setUserName(RandomTestUtil.randomString());

		newOSGi_Foo.setCreateDate(RandomTestUtil.nextDate());

		newOSGi_Foo.setModifiedDate(RandomTestUtil.nextDate());

		newOSGi_Foo.setField1(RandomTestUtil.randomString());

		newOSGi_Foo.setField2(RandomTestUtil.randomBoolean());

		newOSGi_Foo.setField3(RandomTestUtil.nextInt());

		newOSGi_Foo.setField4(RandomTestUtil.nextDate());

		newOSGi_Foo.setField5(RandomTestUtil.randomString());

		_osGi_Foos.add(_persistence.update(newOSGi_Foo));

		OSGi_Foo existingOSGi_Foo = _persistence.findByPrimaryKey(newOSGi_Foo.getPrimaryKey());

		Assert.assertEquals(existingOSGi_Foo.getFooId(), newOSGi_Foo.getFooId());
		Assert.assertEquals(existingOSGi_Foo.getGroupId(),
			newOSGi_Foo.getGroupId());
		Assert.assertEquals(existingOSGi_Foo.getCompanyId(),
			newOSGi_Foo.getCompanyId());
		Assert.assertEquals(existingOSGi_Foo.getUserId(),
			newOSGi_Foo.getUserId());
		Assert.assertEquals(existingOSGi_Foo.getUserName(),
			newOSGi_Foo.getUserName());
		Assert.assertEquals(Time.getShortTimestamp(
				existingOSGi_Foo.getCreateDate()),
			Time.getShortTimestamp(newOSGi_Foo.getCreateDate()));
		Assert.assertEquals(Time.getShortTimestamp(
				existingOSGi_Foo.getModifiedDate()),
			Time.getShortTimestamp(newOSGi_Foo.getModifiedDate()));
		Assert.assertEquals(existingOSGi_Foo.getField1(),
			newOSGi_Foo.getField1());
		Assert.assertEquals(existingOSGi_Foo.getField2(),
			newOSGi_Foo.getField2());
		Assert.assertEquals(existingOSGi_Foo.getField3(),
			newOSGi_Foo.getField3());
		Assert.assertEquals(Time.getShortTimestamp(existingOSGi_Foo.getField4()),
			Time.getShortTimestamp(newOSGi_Foo.getField4()));
		Assert.assertEquals(existingOSGi_Foo.getField5(),
			newOSGi_Foo.getField5());
	}

	@Test
	public void testCountByField2() {
		try {
			_persistence.countByField2(RandomTestUtil.randomBoolean());

			_persistence.countByField2(RandomTestUtil.randomBoolean());
		}
		catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		OSGi_Foo newOSGi_Foo = addOSGi_Foo();

		OSGi_Foo existingOSGi_Foo = _persistence.findByPrimaryKey(newOSGi_Foo.getPrimaryKey());

		Assert.assertEquals(existingOSGi_Foo, newOSGi_Foo);
	}

	@Test
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		try {
			_persistence.findByPrimaryKey(pk);

			Assert.fail("Missing entity did not throw NoSuchOSGi_FooException");
		}
		catch (NoSuchOSGi_FooException nsee) {
		}
	}

	@Test
	public void testFindAll() throws Exception {
		try {
			_persistence.findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS,
				getOrderByComparator());
		}
		catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	protected OrderByComparator<OSGi_Foo> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create("OSGi_Foo", "fooId", true,
			"groupId", true, "companyId", true, "userId", true, "userName",
			true, "createDate", true, "modifiedDate", true, "field1", true,
			"field2", true, "field3", true, "field4", true, "field5", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		OSGi_Foo newOSGi_Foo = addOSGi_Foo();

		OSGi_Foo existingOSGi_Foo = _persistence.fetchByPrimaryKey(newOSGi_Foo.getPrimaryKey());

		Assert.assertEquals(existingOSGi_Foo, newOSGi_Foo);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		OSGi_Foo missingOSGi_Foo = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingOSGi_Foo);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {
		OSGi_Foo newOSGi_Foo1 = addOSGi_Foo();
		OSGi_Foo newOSGi_Foo2 = addOSGi_Foo();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newOSGi_Foo1.getPrimaryKey());
		primaryKeys.add(newOSGi_Foo2.getPrimaryKey());

		Map<Serializable, OSGi_Foo> osGi_Foos = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, osGi_Foos.size());
		Assert.assertEquals(newOSGi_Foo1,
			osGi_Foos.get(newOSGi_Foo1.getPrimaryKey()));
		Assert.assertEquals(newOSGi_Foo2,
			osGi_Foos.get(newOSGi_Foo2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {
		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, OSGi_Foo> osGi_Foos = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(osGi_Foos.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {
		OSGi_Foo newOSGi_Foo = addOSGi_Foo();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newOSGi_Foo.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, OSGi_Foo> osGi_Foos = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, osGi_Foos.size());
		Assert.assertEquals(newOSGi_Foo,
			osGi_Foos.get(newOSGi_Foo.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys()
		throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, OSGi_Foo> osGi_Foos = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(osGi_Foos.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey()
		throws Exception {
		OSGi_Foo newOSGi_Foo = addOSGi_Foo();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newOSGi_Foo.getPrimaryKey());

		Map<Serializable, OSGi_Foo> osGi_Foos = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, osGi_Foos.size());
		Assert.assertEquals(newOSGi_Foo,
			osGi_Foos.get(newOSGi_Foo.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery = OSGi_FooLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(new ActionableDynamicQuery.PerformActionMethod() {
				@Override
				public void performAction(Object object) {
					OSGi_Foo osGi_Foo = (OSGi_Foo)object;

					Assert.assertNotNull(osGi_Foo);

					count.increment();
				}
			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting()
		throws Exception {
		OSGi_Foo newOSGi_Foo = addOSGi_Foo();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(OSGi_Foo.class,
				OSGi_Foo.class.getClassLoader());

		dynamicQuery.add(RestrictionsFactoryUtil.eq("fooId",
				newOSGi_Foo.getFooId()));

		List<OSGi_Foo> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		OSGi_Foo existingOSGi_Foo = result.get(0);

		Assert.assertEquals(existingOSGi_Foo, newOSGi_Foo);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(OSGi_Foo.class,
				OSGi_Foo.class.getClassLoader());

		dynamicQuery.add(RestrictionsFactoryUtil.eq("fooId",
				RandomTestUtil.nextLong()));

		List<OSGi_Foo> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting()
		throws Exception {
		OSGi_Foo newOSGi_Foo = addOSGi_Foo();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(OSGi_Foo.class,
				OSGi_Foo.class.getClassLoader());

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("fooId"));

		Object newFooId = newOSGi_Foo.getFooId();

		dynamicQuery.add(RestrictionsFactoryUtil.in("fooId",
				new Object[] { newFooId }));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingFooId = result.get(0);

		Assert.assertEquals(existingFooId, newFooId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(OSGi_Foo.class,
				OSGi_Foo.class.getClassLoader());

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("fooId"));

		dynamicQuery.add(RestrictionsFactoryUtil.in("fooId",
				new Object[] { RandomTestUtil.nextLong() }));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected OSGi_Foo addOSGi_Foo() throws Exception {
		long pk = RandomTestUtil.nextLong();

		OSGi_Foo osGi_Foo = _persistence.create(pk);

		osGi_Foo.setGroupId(RandomTestUtil.nextLong());

		osGi_Foo.setCompanyId(RandomTestUtil.nextLong());

		osGi_Foo.setUserId(RandomTestUtil.nextLong());

		osGi_Foo.setUserName(RandomTestUtil.randomString());

		osGi_Foo.setCreateDate(RandomTestUtil.nextDate());

		osGi_Foo.setModifiedDate(RandomTestUtil.nextDate());

		osGi_Foo.setField1(RandomTestUtil.randomString());

		osGi_Foo.setField2(RandomTestUtil.randomBoolean());

		osGi_Foo.setField3(RandomTestUtil.nextInt());

		osGi_Foo.setField4(RandomTestUtil.nextDate());

		osGi_Foo.setField5(RandomTestUtil.randomString());

		_osGi_Foos.add(_persistence.update(osGi_Foo));

		return osGi_Foo;
	}

	private List<OSGi_Foo> _osGi_Foos = new ArrayList<OSGi_Foo>();
	private OSGi_FooPersistence _persistence = OSGi_FooUtil.getPersistence();
}