package com.telapi.api.domain.list;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

import com.telapi.api.domain.Fraud;
import com.telapi.api.domain.TelapiList;

public class FraudList extends TelapiList<Fraud>{

	@Override
	protected void mapElements(List<Fraud> elements) {
		setElements(elements);
	}

	@JsonProperty("frauds")
	private Fraud frauds;

	public Fraud getFrauds() {
		return frauds;
	}

	public void setFrauds(Fraud frauds) {
		this.frauds = frauds;
	}

}
