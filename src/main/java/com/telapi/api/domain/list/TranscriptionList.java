package com.telapi.api.domain.list;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

import com.telapi.api.domain.TelapiList;
import com.telapi.api.domain.Transcription;

public class TranscriptionList extends TelapiList<Transcription>{

	@Override
	@JsonProperty("transcriptions")
	protected void mapElements(List<Transcription> elements) {
		setElements(elements);
	}

}
