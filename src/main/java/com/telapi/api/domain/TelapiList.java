package com.telapi.api.domain;

import java.util.Iterator;
import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public abstract class TelapiList<T> implements Iterable<T> {
	
	Long page;
	@JsonProperty(value="num_pages")
	Long numpages;
	@JsonProperty(value="page_size")
	Long pagesize;
	Long total;
	Long start;
	Long end;
	String uri;
	@JsonProperty(value="first_page_uri")
	String firstPageUri;
	@JsonProperty(value="previous_page_uri")
	String previousPageUri;
	@JsonProperty(value="next_page_uri")
	String nextPageUri;
	@JsonProperty(value="last_page_uri")
	String lastPageUri;
	
	@JsonProperty(value="sms_messages")
	List<T> elements;

	public Long getPage() {
		return page;
	}

	public void setPage(Long page) {
		this.page = page;
	}

	public Long getNumpages() {
		return numpages;
	}

	public void setNumpages(Long numpages) {
		this.numpages = numpages;
	}

	public Long getPagesize() {
		return pagesize;
	}

	public void setPagesize(Long pagesize) {
		this.pagesize = pagesize;
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public Long getStart() {
		return start;
	}

	public void setStart(Long start) {
		this.start = start;
	}

	public Long getEnd() {
		return end;
	}

	public void setEnd(Long end) {
		this.end = end;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public String getFirstPageUri() {
		return firstPageUri;
	}

	public void setFirstPageUri(String firstPageUri) {
		this.firstPageUri = firstPageUri;
	}

	public String getPreviousPageUri() {
		return previousPageUri;
	}

	public void setPreviousPageUri(String previousPageUri) {
		this.previousPageUri = previousPageUri;
	}

	public String getNextPageUri() {
		return nextPageUri;
	}

	public void setNextPageUri(String nextPageUri) {
		this.nextPageUri = nextPageUri;
	}

	public String getLastPageUri() {
		return lastPageUri;
	}

	public void setLastPageUri(String lastPageUri) {
		this.lastPageUri = lastPageUri;
	}

	protected abstract void mapElements(List<T> elements);

	protected void setElements(List<T> elements) {
		this.elements = elements;
	}

	@Override
	public Iterator<T> iterator() {
		if (elements == null) return null;
		return elements.iterator();
	}
}
