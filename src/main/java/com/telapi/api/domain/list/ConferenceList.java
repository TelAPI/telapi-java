package com.telapi.api.domain.list;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

import com.telapi.api.domain.Conference;
import com.telapi.api.domain.TelapiList;

public class ConferenceList extends TelapiList<Conference>{

	@Override
	@JsonProperty("conferences")
	protected void mapElements(List<Conference> elements) {
		setElements(elements);
	}

}
