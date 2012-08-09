package com.telapi.api.domain.list;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

import com.telapi.api.domain.AvailablePhoneNumber;
import com.telapi.api.domain.TelapiList;

public class AvailablePhoneNumberList extends TelapiList<AvailablePhoneNumber>{

	@Override
	@JsonProperty("available_phone_numbers")
	protected void mapElements(List<AvailablePhoneNumber> elements) {
		setElements(elements);
	}

}
