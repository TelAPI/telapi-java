package com.telapi.api.domain.list;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

import com.telapi.api.domain.CnamDip;
import com.telapi.api.domain.TelapiList;

public class CnamDipList extends TelapiList<CnamDip>{

	@Override
	@JsonProperty("cnam_dips")
	protected void mapElements(List<CnamDip> elements) {
		setElements(elements);
	}

}
