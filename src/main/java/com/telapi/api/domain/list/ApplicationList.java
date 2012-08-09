package com.telapi.api.domain.list;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

import com.telapi.api.domain.Application;
import com.telapi.api.domain.TelapiList;

public class ApplicationList extends TelapiList<Application> {

	@Override
	@JsonProperty("applications")
	protected void mapElements(List<Application> elements) {
		setElements(elements);
	}
}
