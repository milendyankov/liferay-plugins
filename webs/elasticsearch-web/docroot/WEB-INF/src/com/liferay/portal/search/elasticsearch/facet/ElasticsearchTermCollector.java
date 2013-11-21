package com.liferay.portal.search.elasticsearch.facet;

import com.liferay.portal.kernel.search.facet.collector.TermCollector;

/**
 * 
 * @author Milen Dyankov
 *
 */
public class ElasticsearchTermCollector implements TermCollector {

	
	public ElasticsearchTermCollector(String _term, int _frequency) {

		super();
		this._term = _term;
		this._frequency = _frequency;
	}
	
	@Override
	public int getFrequency() {

		return _frequency;
	}
	
	@Override
	public String getTerm() {

		return _term;
	}

	private int _frequency;

	private String _term;

}
