package com.telapi.api.domain;

import java.math.BigDecimal;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonDeserialize;

import com.telapi.api.domain.enums.HttpMethod;
import com.telapi.api.domain.enums.TranscriptionStatus;
import com.telapi.api.domain.enums.TranscriptionType;
import com.telapi.api.json.JsonDurationParser;

/**
 * This resource represents a transcription of a Recording or audio.
 */
public class Transcription extends BaseTelapiObject {
	private TranscriptionStatus status;
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
	
	/**
	 * @return The status of the transcription (e.g. completed, in-progress, failed).
	 */
	public TranscriptionStatus getStatus() {
		return status;
	}
	public void setStatus(TranscriptionStatus status) {
		this.status = status;
	}
	/**
	 * @return Transcription quality tier. May be auto, silver, gold, or platinum. Default is auto.
	 */
	public TranscriptionType getType() {
		return type;
	}
	public void setType(TranscriptionType type) {
		this.type = type;
	}
	/**
	 * @return URL where a file containing the transcribed audio is located.
	 */
	public String getAudioUrl() {
		return audioUrl;
	}
	public void setAudioUrl(String audioUrl) {
		this.audioUrl = audioUrl;
	}
	/**
	 * @return Length in seconds of the transcribed recording.
	 */
	public Long getDuration() {
		return duration;
	}
	@JsonDeserialize(using = JsonDurationParser.class)
	public void setDuration(Long duration) {
		this.duration = duration;
	}
	/**
	 * @return Text of the transcribed audio.
	 */
	public String getTranscriptionText() {
		return transcriptionText;
	}
	public void setTranscriptionText(String transcriptionText) {
		this.transcriptionText = transcriptionText;
	}
	/**
	 * @return Cost of the transcription.
	 */
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	/**
	 * @return URL where transcription will report to after completion.
	 */
	public String getTranscribeCallback() {
		return transcribeCallback;
	}
	public void setTranscribeCallback(String transcribeCallback) {
		this.transcribeCallback = transcribeCallback;
	}
	/**
	 * @return Method to request TranscribeCallback URL. Can be POST or GET. Default is POST
	 */
	public HttpMethod getCallbackMethod() {
		return callbackMethod;
	}
	public void setCallbackMethod(HttpMethod callbackMethod) {
		this.callbackMethod = callbackMethod;
	}
	/**
	 * @return An alphanumeric string used to identify the recording that was transcribed.
	 */
	public String getRecordingSid() {
		return recordingSid;
	}
	public void setRecordingSid(String recordingSid) {
		this.recordingSid = recordingSid;
	}
	
	
}
