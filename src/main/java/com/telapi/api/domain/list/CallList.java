package com.telapi.api.domain.list;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

import com.telapi.api.domain.Call;
import com.telapi.api.domain.TelapiList;

public class CallList extends TelapiList<Call>{

	@Override
	@JsonProperty("calls")
	protected void mapElements(List<Call> elements) {
		setElements(elements);
	}

}
