package com.telapi.api.inboundxml.parameters;

import com.telapi.api.domain.enums.HttpMethod;
import com.telapi.api.inboundxml.elements.enums.RecordingFileFormat;

public class RecordParameters {
	private String action;
	private HttpMethod method;
	private Long timeout;
	private String finishOnKey;
	private Long maxLength;
	private Boolean transcribe;
	private String transcribeCallback;
	private Boolean playBeep;
	private Boolean bothLegs;
	private RecordingFileFormat fileFormat;
	
	/**
	 * 
	 * @param action URL where some parameters specific to Record will be sent for further processing (required).
	 */
	public RecordParameters(String action) {
		this.action = action;
	}
	
	public String getAction() {
		return action;
	}
	
	/**
	 * 
	 * @param action URL where some parameters specific to Record will be sent for further processing (required).
	 */
	public void setAction(String action) {
		this.action = action;
	}
	public HttpMethod getMethod() {
		return method;
	}
	
	/**
	 * 
	 * @param method Specifies the method to use when requesting the action or transcribeCallback URL.
	 */
	public void setMethod(HttpMethod method) {
		this.method = method;
	}
	public Long getTimeout() {
		return timeout;
	}
	
	/**
	 * 
	 * @param timeout The number of seconds Record should wait during silence before ending. Greater than or equal to 0. Defaults to 5.
	 */
	public void setTimeout(Long timeout) {
		this.timeout = timeout;
	}
	public String getFinishOnKey() {
		return finishOnKey;
	}
	
	/**
	 * 
	 * @param finishOnKey The key a caller can press to end the Record. Allowed values are 0-9, # or *. Defaults to #.
	 */
	public void setFinishOnKey(String finishOnKey) {
		this.finishOnKey = finishOnKey;
	}
	public Long getMaxLength() {
		return maxLength;
	}
	
	/**
	 * 
	 * @param maxLength The maximum length in seconds a recording should be. Defaults to 3600.
	 */
	public void setMaxLength(Long maxLength) {
		this.maxLength = maxLength;
	}
	public Boolean getTranscribe() {
		return transcribe;
	}
	
	/**
	 * 
	 * @param transcribe Boolean value specifying if the recording should be transcribed. Defaults to false.
	 */
	public void setTranscribe(Boolean transcribe) {
		this.transcribe = transcribe;
	}
	public String getTranscribeCallback() {
		return transcribeCallback;
	}
	
	/**
	 * 
	 * @param transcribeCallback URL where the recording transcription will be sent. Defaults to the current InboundXML document.
	 */
	public void setTranscribeCallback(String transcribeCallback) {
		this.transcribeCallback = transcribeCallback;
	}
	public Boolean getPlayBeep() {
		return playBeep;
	}
	
	/**
	 * 
	 * @param playBeep Boolean value specifying if a beep should be played when the recording begins. Defaults to false.
	 */
	public void setPlayBeep(Boolean playBeep) {
		this.playBeep = playBeep;
	}
	public Boolean getBothLegs() {
		return bothLegs;
	}
	
	/**
	 * 
	 * @param bothLegs Boolean value specifying if both call legs should be recorded. Defaults to false.
	 */
	public void setBothLegs(Boolean bothLegs) {
		this.bothLegs = bothLegs;
	}
	public RecordingFileFormat getFileFormat() {
		return fileFormat;
	}
	
	/**
	 * 
	 * @param fileFormat The recording file format. Can be mp3 or wav. Default is mp3.
	 */
	public void setFileFormat(RecordingFileFormat fileFormat) {
		this.fileFormat = fileFormat;
	}
	
	
}
