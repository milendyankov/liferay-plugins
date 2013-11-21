
package com.liferay.portal.search.elasticsearch.facet;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.elasticsearch.search.facet.Facet;
import org.elasticsearch.search.facet.range.RangeFacet;
import org.elasticsearch.search.facet.terms.TermsFacet;

import com.liferay.portal.kernel.search.facet.collector.FacetCollector;
import com.liferay.portal.kernel.search.facet.collector.TermCollector;

/**
 * 
 * @author Milen Dyankov
 *
 */
public class ElasticsearchFacetFieldCollector implements FacetCollector {

	public ElasticsearchFacetFieldCollector(RangeFacet rangeFacet) {

		_facet = rangeFacet;

		for (RangeFacet.Entry entry : rangeFacet.getEntries()) {
			String name = "[" + entry.getFromAsString() + " TO " + entry.getToAsString() + "]";
			_counts.put(name, (int) entry.getCount());
		}
	}

	public ElasticsearchFacetFieldCollector(TermsFacet termsFacet) {

		_facet = termsFacet;

		for (TermsFacet.Entry entry : termsFacet.getEntries()) {
			_counts.put(entry.getTerm().string(), entry.getCount());
		}
	}

	@Override
	public String getFieldName() {

		return _facet.getName();
	}

	@Override
	public TermCollector getTermCollector(String term) {

		int count = _counts.containsKey(term) ? _counts.get(term) : 0;
		return new ElasticsearchTermCollector(term, count);
	}

	public List<TermCollector> getTermCollectors() {

		if (_termCollectors != null) {
			return _termCollectors;
		}

		List<TermCollector> termCollectors = new ArrayList<TermCollector>();

		for (Map.Entry<String, Integer> entry : _counts.entrySet()) {
			TermCollector termCollector = new ElasticsearchTermCollector(entry.getKey(), entry.getValue());
			termCollectors.add(termCollector);
		}

		_termCollectors = termCollectors;

		return _termCollectors;
	}

	private Map<String, Integer> _counts = new ConcurrentHashMap<String, Integer>();
	private Facet _facet = null;
	private List<TermCollector> _termCollectors;

}
