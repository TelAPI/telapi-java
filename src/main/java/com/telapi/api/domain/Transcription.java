package com.telapi.api.domain;

import java.math.BigDecimal;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonDeserialize;

import com.telapi.api.domain.enums.HttpMethod;
import com.telapi.api.domain.enums.TranscriptionType;
import com.telapi.api.json.JsonDurationParser;

public class Transcription extends BaseTelapiObjectWithSid {
	private String status;
	private TranscriptionType type;
	@JsonProperty("audio_url")
	private String audioUrl;
	@JsonDeserialize(using = JsonDurationParser.class)
	private Long duration;
	@JsonProperty("recording_sid")
	private String recordingSid;
	@JsonProperty("transcription_text")
	private String transcriptionText;
	private BigDecimal price;
	@JsonProperty("transcribe_callback")
	private String transcribeCallback;
	@JsonProperty("callback_method")
	private HttpMethod callbackMethod;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public TranscriptionType getType() {
		return type;
	}
	public void setType(TranscriptionType type) {
		this.type = type;
	}
	public String getAudioUrl() {
		return audioUrl;
	}
	public void setAudioUrl(String audioUrl) {
		this.audioUrl = audioUrl;
	}
	public Long getDuration() {
		return duration;
	}
	@JsonDeserialize(using = JsonDurationParser.class)
	public void setDuration(Long duration) {
		this.duration = duration;
	}
	public String getTranscriptionText() {
		return transcriptionText;
	}
	public void setTranscriptionText(String transcriptionText) {
		this.transcriptionText = transcriptionText;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public String getTranscribeCallback() {
		return transcribeCallback;
	}
	public void setTranscribeCallback(String transcribeCallback) {
		this.transcribeCallback = transcribeCallback;
	}
	public HttpMethod getCallbackMethod() {
		return callbackMethod;
	}
	public void setCallbackMethod(HttpMethod callbackMethod) {
		this.callbackMethod = callbackMethod;
	}
	public String getRecordingSid() {
		return recordingSid;
	}
	public void setRecordingSid(String recordingSid) {
		this.recordingSid = recordingSid;
	}
	
	
}
