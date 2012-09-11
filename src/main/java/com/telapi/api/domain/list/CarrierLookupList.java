package com.telapi.api.domain.list;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

import com.telapi.api.domain.CarrierLookup;
import com.telapi.api.domain.TelapiList;

public class CarrierLookupList extends TelapiList<CarrierLookup>{

	@Override
	@JsonProperty("carrier_lookups")
	protected void mapElements(List<CarrierLookup> elements) {
		setElements(elements);
	}

}
