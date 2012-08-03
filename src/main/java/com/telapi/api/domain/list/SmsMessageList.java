package com.telapi.api.domain.list;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

import com.telapi.api.domain.SmsMessage;
import com.telapi.api.domain.TelapiList;

public class SmsMessageList extends TelapiList<SmsMessage> {
	
	@Override
	@JsonProperty(value="sms_messages")
	protected void mapElements(List<SmsMessage> elements) {
		setElements(elements);
	}

}
