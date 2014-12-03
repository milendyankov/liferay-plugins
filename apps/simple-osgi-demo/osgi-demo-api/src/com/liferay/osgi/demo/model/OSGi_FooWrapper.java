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

package com.liferay.osgi.demo.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link OSGi_Foo}.
 * </p>
 *
 * @author milen
 * @see OSGi_Foo
 * @generated
 */
@ProviderType
public class OSGi_FooWrapper implements OSGi_Foo, ModelWrapper<OSGi_Foo> {
	public OSGi_FooWrapper(OSGi_Foo osGi_Foo) {
		_osGi_Foo = osGi_Foo;
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

	@Override
	public java.lang.Object clone() {
		return new OSGi_FooWrapper((OSGi_Foo)_osGi_Foo.clone());
	}

	@Override
	public int compareTo(com.liferay.osgi.demo.model.OSGi_Foo osGi_Foo) {
		return _osGi_Foo.compareTo(osGi_Foo);
	}

	/**
	* Returns the company ID of this o s gi_ foo.
	*
	* @return the company ID of this o s gi_ foo
	*/
	@Override
	public long getCompanyId() {
		return _osGi_Foo.getCompanyId();
	}

	/**
	* Returns the create date of this o s gi_ foo.
	*
	* @return the create date of this o s gi_ foo
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _osGi_Foo.getCreateDate();
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _osGi_Foo.getExpandoBridge();
	}

	/**
	* Returns the field1 of this o s gi_ foo.
	*
	* @return the field1 of this o s gi_ foo
	*/
	@Override
	public java.lang.String getField1() {
		return _osGi_Foo.getField1();
	}

	/**
	* Returns the field2 of this o s gi_ foo.
	*
	* @return the field2 of this o s gi_ foo
	*/
	@Override
	public boolean getField2() {
		return _osGi_Foo.getField2();
	}

	/**
	* Returns the field3 of this o s gi_ foo.
	*
	* @return the field3 of this o s gi_ foo
	*/
	@Override
	public int getField3() {
		return _osGi_Foo.getField3();
	}

	/**
	* Returns the field4 of this o s gi_ foo.
	*
	* @return the field4 of this o s gi_ foo
	*/
	@Override
	public java.util.Date getField4() {
		return _osGi_Foo.getField4();
	}

	/**
	* Returns the field5 of this o s gi_ foo.
	*
	* @return the field5 of this o s gi_ foo
	*/
	@Override
	public java.lang.String getField5() {
		return _osGi_Foo.getField5();
	}

	/**
	* Returns the foo ID of this o s gi_ foo.
	*
	* @return the foo ID of this o s gi_ foo
	*/
	@Override
	public long getFooId() {
		return _osGi_Foo.getFooId();
	}

	/**
	* Returns the group ID of this o s gi_ foo.
	*
	* @return the group ID of this o s gi_ foo
	*/
	@Override
	public long getGroupId() {
		return _osGi_Foo.getGroupId();
	}

	/**
	* Returns the modified date of this o s gi_ foo.
	*
	* @return the modified date of this o s gi_ foo
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _osGi_Foo.getModifiedDate();
	}

	/**
	* Returns the primary key of this o s gi_ foo.
	*
	* @return the primary key of this o s gi_ foo
	*/
	@Override
	public long getPrimaryKey() {
		return _osGi_Foo.getPrimaryKey();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _osGi_Foo.getPrimaryKeyObj();
	}

	/**
	* Returns the user ID of this o s gi_ foo.
	*
	* @return the user ID of this o s gi_ foo
	*/
	@Override
	public long getUserId() {
		return _osGi_Foo.getUserId();
	}

	/**
	* Returns the user name of this o s gi_ foo.
	*
	* @return the user name of this o s gi_ foo
	*/
	@Override
	public java.lang.String getUserName() {
		return _osGi_Foo.getUserName();
	}

	/**
	* Returns the user uuid of this o s gi_ foo.
	*
	* @return the user uuid of this o s gi_ foo
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _osGi_Foo.getUserUuid();
	}

	@Override
	public int hashCode() {
		return _osGi_Foo.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _osGi_Foo.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _osGi_Foo.isEscapedModel();
	}

	/**
	* Returns <code>true</code> if this o s gi_ foo is field2.
	*
	* @return <code>true</code> if this o s gi_ foo is field2; <code>false</code> otherwise
	*/
	@Override
	public boolean isField2() {
		return _osGi_Foo.isField2();
	}

	@Override
	public boolean isNew() {
		return _osGi_Foo.isNew();
	}

	@Override
	public void persist() {
		_osGi_Foo.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_osGi_Foo.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this o s gi_ foo.
	*
	* @param companyId the company ID of this o s gi_ foo
	*/
	@Override
	public void setCompanyId(long companyId) {
		_osGi_Foo.setCompanyId(companyId);
	}

	/**
	* Sets the create date of this o s gi_ foo.
	*
	* @param createDate the create date of this o s gi_ foo
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_osGi_Foo.setCreateDate(createDate);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_osGi_Foo.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_osGi_Foo.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_osGi_Foo.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the field1 of this o s gi_ foo.
	*
	* @param field1 the field1 of this o s gi_ foo
	*/
	@Override
	public void setField1(java.lang.String field1) {
		_osGi_Foo.setField1(field1);
	}

	/**
	* Sets whether this o s gi_ foo is field2.
	*
	* @param field2 the field2 of this o s gi_ foo
	*/
	@Override
	public void setField2(boolean field2) {
		_osGi_Foo.setField2(field2);
	}

	/**
	* Sets the field3 of this o s gi_ foo.
	*
	* @param field3 the field3 of this o s gi_ foo
	*/
	@Override
	public void setField3(int field3) {
		_osGi_Foo.setField3(field3);
	}

	/**
	* Sets the field4 of this o s gi_ foo.
	*
	* @param field4 the field4 of this o s gi_ foo
	*/
	@Override
	public void setField4(java.util.Date field4) {
		_osGi_Foo.setField4(field4);
	}

	/**
	* Sets the field5 of this o s gi_ foo.
	*
	* @param field5 the field5 of this o s gi_ foo
	*/
	@Override
	public void setField5(java.lang.String field5) {
		_osGi_Foo.setField5(field5);
	}

	/**
	* Sets the foo ID of this o s gi_ foo.
	*
	* @param fooId the foo ID of this o s gi_ foo
	*/
	@Override
	public void setFooId(long fooId) {
		_osGi_Foo.setFooId(fooId);
	}

	/**
	* Sets the group ID of this o s gi_ foo.
	*
	* @param groupId the group ID of this o s gi_ foo
	*/
	@Override
	public void setGroupId(long groupId) {
		_osGi_Foo.setGroupId(groupId);
	}

	/**
	* Sets the modified date of this o s gi_ foo.
	*
	* @param modifiedDate the modified date of this o s gi_ foo
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_osGi_Foo.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_osGi_Foo.setNew(n);
	}

	/**
	* Sets the primary key of this o s gi_ foo.
	*
	* @param primaryKey the primary key of this o s gi_ foo
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_osGi_Foo.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_osGi_Foo.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the user ID of this o s gi_ foo.
	*
	* @param userId the user ID of this o s gi_ foo
	*/
	@Override
	public void setUserId(long userId) {
		_osGi_Foo.setUserId(userId);
	}

	/**
	* Sets the user name of this o s gi_ foo.
	*
	* @param userName the user name of this o s gi_ foo
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_osGi_Foo.setUserName(userName);
	}

	/**
	* Sets the user uuid of this o s gi_ foo.
	*
	* @param userUuid the user uuid of this o s gi_ foo
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_osGi_Foo.setUserUuid(userUuid);
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.liferay.osgi.demo.model.OSGi_Foo> toCacheModel() {
		return _osGi_Foo.toCacheModel();
	}

	@Override
	public com.liferay.osgi.demo.model.OSGi_Foo toEscapedModel() {
		return new OSGi_FooWrapper(_osGi_Foo.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _osGi_Foo.toString();
	}

	@Override
	public com.liferay.osgi.demo.model.OSGi_Foo toUnescapedModel() {
		return new OSGi_FooWrapper(_osGi_Foo.toUnescapedModel());
	}

	@Override
	public java.lang.String toXmlString() {
		return _osGi_Foo.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof OSGi_FooWrapper)) {
			return false;
		}

		OSGi_FooWrapper osGi_FooWrapper = (OSGi_FooWrapper)obj;

		if (Validator.equals(_osGi_Foo, osGi_FooWrapper._osGi_Foo)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	@Deprecated
	public OSGi_Foo getWrappedOSGi_Foo() {
		return _osGi_Foo;
	}

	@Override
	public OSGi_Foo getWrappedModel() {
		return _osGi_Foo;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _osGi_Foo.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _osGi_Foo.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_osGi_Foo.resetOriginalValues();
	}

	private final OSGi_Foo _osGi_Foo;
}