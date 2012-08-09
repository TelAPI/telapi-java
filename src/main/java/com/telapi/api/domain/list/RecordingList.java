package com.telapi.api.domain.list;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

import com.telapi.api.domain.Recording;
import com.telapi.api.domain.TelapiList;

public class RecordingList extends TelapiList<Recording>{

	@Override
	@JsonProperty("recordings")
	protected void mapElements(List<Recording> elements) {
		setElements(elements);
	}

}
