package com.telapi.api.domain.list;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

import com.telapi.api.domain.IncomingPhoneNumber;
import com.telapi.api.domain.TelapiList;

public class IncomingPhoneNumberList extends TelapiList<IncomingPhoneNumber>{

	@Override
	@JsonProperty("incoming_phone_numbers")
	protected void mapElements(List<IncomingPhoneNumber> elements) {
		setElements(elements);
	}

}
