package com.telapi.api.json;

import java.io.IOException;

import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;

public class JsonBooleanParser extends JsonDeserializer<Boolean> {
	@Override
	public Boolean deserialize(JsonParser jsonparser,
			DeserializationContext deserializationcontext) throws IOException,
			JsonProcessingException {
		String value = jsonparser.getText();
		if (value == null)
			return null;
		else if (value.toLowerCase().equals("true")) return true;
		else if (value.toLowerCase().equals("false")) return false;
		return null;
	}
}
