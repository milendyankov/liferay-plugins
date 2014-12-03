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

import com.liferay.osgi.demo.model.OSGi_Foo;
import com.liferay.osgi.demo.model.OSGi_FooModel;
import com.liferay.osgi.demo.model.OSGi_FooSoap;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.User;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the OSGi_Foo service. Represents a row in the &quot;OSGi_Foo&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.liferay.osgi.demo.model.OSGi_FooModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link OSGi_FooImpl}.
 * </p>
 *
 * @author milen
 * @see OSGi_FooImpl
 * @see com.liferay.osgi.demo.model.OSGi_Foo
 * @see com.liferay.osgi.demo.model.OSGi_FooModel
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class OSGi_FooModelImpl extends BaseModelImpl<OSGi_Foo>
	implements OSGi_FooModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a o s gi_ foo model instance should use the {@link com.liferay.osgi.demo.model.OSGi_Foo} interface instead.
	 */
	public static final String TABLE_NAME = "OSGi_Foo";
	public static final Object[][] TABLE_COLUMNS = {
			{ "fooId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "field1", Types.VARCHAR },
			{ "field2", Types.BOOLEAN },
			{ "field3", Types.INTEGER },
			{ "field4", Types.TIMESTAMP },
			{ "field5", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table OSGi_Foo (fooId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,field1 VARCHAR(75) null,field2 BOOLEAN,field3 INTEGER,field4 DATE null,field5 VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table OSGi_Foo";
	public static final String ORDER_BY_JPQL = " ORDER BY osGi_Foo.field1 ASC";
	public static final String ORDER_BY_SQL = " ORDER BY OSGi_Foo.field1 ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.liferay.osgi.demo.model.OSGi_Foo"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.liferay.osgi.demo.model.OSGi_Foo"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.liferay.osgi.demo.model.OSGi_Foo"),
			true);
	public static final long FIELD2_COLUMN_BITMASK = 1L;
	public static final long FIELD1_COLUMN_BITMASK = 2L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static OSGi_Foo toModel(OSGi_FooSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		OSGi_Foo model = new OSGi_FooImpl();

		model.setFooId(soapModel.getFooId());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setField1(soapModel.getField1());
		model.setField2(soapModel.getField2());
		model.setField3(soapModel.getField3());
		model.setField4(soapModel.getField4());
		model.setField5(soapModel.getField5());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<OSGi_Foo> toModels(OSGi_FooSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<OSGi_Foo> models = new ArrayList<OSGi_Foo>(soapModels.length);

		for (OSGi_FooSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.liferay.osgi.demo.model.OSGi_Foo"));

	public OSGi_FooModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _fooId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setFooId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _fooId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return OSGi_Foo.class;
	}

	@Override
	public String getModelClassName() {
		return OSGi_Foo.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("fooId", getFooId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("field1", getField1());
		attributes.put("field2", getField2());
		attributes.put("field3", getField3());
		attributes.put("field4", getField4());
		attributes.put("field5", getField5());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long fooId = (Long)attributes.get("fooId");

		if (fooId != null) {
			setFooId(fooId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String field1 = (String)attributes.get("field1");

		if (field1 != null) {
			setField1(field1);
		}

		Boolean field2 = (Boolean)attributes.get("field2");

		if (field2 != null) {
			setField2(field2);
		}

		Integer field3 = (Integer)attributes.get("field3");

		if (field3 != null) {
			setField3(field3);
		}

		Date field4 = (Date)attributes.get("field4");

		if (field4 != null) {
			setField4(field4);
		}

		String field5 = (String)attributes.get("field5");

		if (field5 != null) {
			setField5(field5);
		}
	}

	@JSON
	@Override
	public long getFooId() {
		return _fooId;
	}

	@Override
	public void setFooId(long fooId) {
		_fooId = fooId;
	}

	@JSON
	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	@JSON
	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	@JSON
	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException pe) {
			return StringPool.BLANK;
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	@JSON
	@Override
	public String getUserName() {
		if (_userName == null) {
			return StringPool.BLANK;
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;
	}

	@JSON
	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@JSON
	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	@JSON
	@Override
	public String getField1() {
		if (_field1 == null) {
			return StringPool.BLANK;
		}
		else {
			return _field1;
		}
	}

	@Override
	public void setField1(String field1) {
		_columnBitmask = -1L;

		_field1 = field1;
	}

	@JSON
	@Override
	public boolean getField2() {
		return _field2;
	}

	@Override
	public boolean isField2() {
		return _field2;
	}

	@Override
	public void setField2(boolean field2) {
		_columnBitmask |= FIELD2_COLUMN_BITMASK;

		if (!_setOriginalField2) {
			_setOriginalField2 = true;

			_originalField2 = _field2;
		}

		_field2 = field2;
	}

	public boolean getOriginalField2() {
		return _originalField2;
	}

	@JSON
	@Override
	public int getField3() {
		return _field3;
	}

	@Override
	public void setField3(int field3) {
		_field3 = field3;
	}

	@JSON
	@Override
	public Date getField4() {
		return _field4;
	}

	@Override
	public void setField4(Date field4) {
		_field4 = field4;
	}

	@JSON
	@Override
	public String getField5() {
		if (_field5 == null) {
			return StringPool.BLANK;
		}
		else {
			return _field5;
		}
	}

	@Override
	public void setField5(String field5) {
		_field5 = field5;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			OSGi_Foo.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public OSGi_Foo toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (OSGi_Foo)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		OSGi_FooImpl osGi_FooImpl = new OSGi_FooImpl();

		osGi_FooImpl.setFooId(getFooId());
		osGi_FooImpl.setGroupId(getGroupId());
		osGi_FooImpl.setCompanyId(getCompanyId());
		osGi_FooImpl.setUserId(getUserId());
		osGi_FooImpl.setUserName(getUserName());
		osGi_FooImpl.setCreateDate(getCreateDate());
		osGi_FooImpl.setModifiedDate(getModifiedDate());
		osGi_FooImpl.setField1(getField1());
		osGi_FooImpl.setField2(getField2());
		osGi_FooImpl.setField3(getField3());
		osGi_FooImpl.setField4(getField4());
		osGi_FooImpl.setField5(getField5());

		osGi_FooImpl.resetOriginalValues();

		return osGi_FooImpl;
	}

	@Override
	public int compareTo(OSGi_Foo osGi_Foo) {
		int value = 0;

		value = getField1().compareTo(osGi_Foo.getField1());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof OSGi_Foo)) {
			return false;
		}

		OSGi_Foo osGi_Foo = (OSGi_Foo)obj;

		long primaryKey = osGi_Foo.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return ENTITY_CACHE_ENABLED;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return FINDER_CACHE_ENABLED;
	}

	@Override
	public void resetOriginalValues() {
		OSGi_FooModelImpl osGi_FooModelImpl = this;

		osGi_FooModelImpl._originalField2 = osGi_FooModelImpl._field2;

		osGi_FooModelImpl._setOriginalField2 = false;

		osGi_FooModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<OSGi_Foo> toCacheModel() {
		OSGi_FooCacheModel osGi_FooCacheModel = new OSGi_FooCacheModel();

		osGi_FooCacheModel.fooId = getFooId();

		osGi_FooCacheModel.groupId = getGroupId();

		osGi_FooCacheModel.companyId = getCompanyId();

		osGi_FooCacheModel.userId = getUserId();

		osGi_FooCacheModel.userName = getUserName();

		String userName = osGi_FooCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			osGi_FooCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			osGi_FooCacheModel.createDate = createDate.getTime();
		}
		else {
			osGi_FooCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			osGi_FooCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			osGi_FooCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		osGi_FooCacheModel.field1 = getField1();

		String field1 = osGi_FooCacheModel.field1;

		if ((field1 != null) && (field1.length() == 0)) {
			osGi_FooCacheModel.field1 = null;
		}

		osGi_FooCacheModel.field2 = getField2();

		osGi_FooCacheModel.field3 = getField3();

		Date field4 = getField4();

		if (field4 != null) {
			osGi_FooCacheModel.field4 = field4.getTime();
		}
		else {
			osGi_FooCacheModel.field4 = Long.MIN_VALUE;
		}

		osGi_FooCacheModel.field5 = getField5();

		String field5 = osGi_FooCacheModel.field5;

		if ((field5 != null) && (field5.length() == 0)) {
			osGi_FooCacheModel.field5 = null;
		}

		return osGi_FooCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{fooId=");
		sb.append(getFooId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", field1=");
		sb.append(getField1());
		sb.append(", field2=");
		sb.append(getField2());
		sb.append(", field3=");
		sb.append(getField3());
		sb.append(", field4=");
		sb.append(getField4());
		sb.append(", field5=");
		sb.append(getField5());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(40);

		sb.append("<model><model-name>");
		sb.append("com.liferay.osgi.demo.model.OSGi_Foo");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>fooId</column-name><column-value><![CDATA[");
		sb.append(getFooId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>field1</column-name><column-value><![CDATA[");
		sb.append(getField1());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>field2</column-name><column-value><![CDATA[");
		sb.append(getField2());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>field3</column-name><column-value><![CDATA[");
		sb.append(getField3());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>field4</column-name><column-value><![CDATA[");
		sb.append(getField4());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>field5</column-name><column-value><![CDATA[");
		sb.append(getField5());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = OSGi_Foo.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			OSGi_Foo.class
		};
	private long _fooId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _field1;
	private boolean _field2;
	private boolean _originalField2;
	private boolean _setOriginalField2;
	private int _field3;
	private Date _field4;
	private String _field5;
	private long _columnBitmask;
	private OSGi_Foo _escapedModel;
}