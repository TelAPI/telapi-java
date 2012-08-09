package com.telapi.api.domain.list;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

import com.telapi.api.domain.Fraud;
import com.telapi.api.domain.TelapiList;

public class FraudList extends TelapiList<Fraud>{

	@Override
	@JsonProperty("frauds")
	protected void mapElements(List<Fraud> elements) {
		setElements(elements);
	}

}
