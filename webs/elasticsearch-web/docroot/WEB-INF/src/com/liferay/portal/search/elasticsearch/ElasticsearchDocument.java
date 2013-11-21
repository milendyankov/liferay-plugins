
package com.liferay.portal.search.elasticsearch;

/**
 * 
 * @author Milen Dyankov
 *
 */
public class ElasticsearchDocument {

	public ElasticsearchDocument() {

	}

	public ElasticsearchDocument(String json, String id) {

		this.json = json;
		this.id = id;
	}

	/**
	 * @return the id
	 */
	public String getId() {

		return id;
	}

	/**
	 * @return the json
	 */
	public String getJson() {

		return json;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {

		this.id = id;
	}

	/**
	 * @param json
	 *            the json to set
	 */
	public void setJson(String json) {

		this.json = json;
	}

	private String id;
	private String json;

}
