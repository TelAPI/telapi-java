package com.telapi.api.json;

import java.io.IOException;

import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;

public class JsonDurationParser extends JsonDeserializer<Long> {
	@Override
	public Long deserialize(JsonParser jsonparser,
			DeserializationContext deserializationcontext) throws IOException,
			JsonProcessingException {
		String date = jsonparser.getText();
		if (date == null)
			return null;
		try {
			Long retVal = new Long(date);
			return retVal;
		} catch (NumberFormatException e) {
			return 0L;
		}

	}
}
