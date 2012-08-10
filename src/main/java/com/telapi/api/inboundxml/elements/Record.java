package com.telapi.api.inboundxml.elements;

import com.telapi.api.domain.enums.HttpMethod;
import com.telapi.api.inboundxml.elements.enums.RecordingFileFormat;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

@XStreamAlias("Record")
@SuppressWarnings("unused")
public class Record implements ResponseElement {
	@XStreamAsAttribute
	private String action;
	@XStreamAsAttribute
	private String method;
	@XStreamAsAttribute
	private Long timeout;
	@XStreamAsAttribute
	private String finishOnKey;
	@XStreamAsAttribute
	private Long maxLength;
	@XStreamAsAttribute
	private Boolean transcribe;
	@XStreamAsAttribute
	private String transcribeCallback;
	@XStreamAsAttribute
	private Boolean playBeep;
	@XStreamAsAttribute
	private Boolean bothLegs;
	@XStreamAsAttribute
	private String fileFormat;
	
	protected Record() {
		
	}
	
	static Record createRecord(String action, HttpMethod method, Long timeout, String finishOnKey, Long maxLength, Boolean transcribe, String transcribeCallback, Boolean playBeep, Boolean bothLegs, RecordingFileFormat fileFormat) {
		Record r = new Record();
		r.action = action;
		r.method = method == null ? null : method.toString();
		r.timeout = timeout;
		r.finishOnKey = finishOnKey;
		r.maxLength = maxLength;
		r.transcribe = transcribe;
		r.transcribeCallback = transcribeCallback;
		r.playBeep = playBeep;
		r.bothLegs = bothLegs;
		r.fileFormat = fileFormat == null ? null : fileFormat.toString();
		return r;
	}
	
	static Record createRecord(String action) {
		Record r = new Record();
		r.action = action;
		return r;
	}
	
}
