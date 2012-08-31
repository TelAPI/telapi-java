package com.telapi.api.inboundxml.parameters;

import com.telapi.api.domain.enums.HttpMethod;

public class ConferenceParameters {
	
	private String conferenceName;
	private Boolean muted;
	private Boolean beep;
	private Boolean startConferenceOnEnter;
	private Boolean endConferenceOnExit;
	private Long maxParticipants;
	private String waitUrl;
	private HttpMethod waitMethod;
	private Boolean hangupOnStar;
	private String callbackUrl;
	private HttpMethod callbackMethod;
	private String waitSound;
	private HttpMethod waitSoundMethod;
	private String digitsMatch;
	private Boolean stayAlone;
	
	public String getConferenceName() {
		return conferenceName;
	}
	/**
	 * 
	 * @param conferenceName
	 *            The conference name (required).
	 */
	public void setConferenceName(String conferenceName) {
		this.conferenceName = conferenceName;
	}
	public Boolean getMuted() {
		return muted;
	}
	
	/**
	 * 
	 * @param muted
	 *            Boolean value specifying if the conference should be muted.
	 *            Defaults to false.
	 */
	public void setMuted(Boolean muted) {
		this.muted = muted;
	}
	public Boolean getBeep() {
		return beep;
	}
	
	/**
	 * 
	 * @param beep
	 *            Boolean value specifying if a beep should play upon entrance
	 *            to conference. Defaults to false.
	 */
	public void setBeep(Boolean beep) {
		this.beep = beep;
	}
	public Boolean getStartConferenceOnEnter() {
		return startConferenceOnEnter;
	}
	
	/**
	 * 
	 * @param startConferenceOnEnter
	 *            Boolean value specifying if conference should begin upon
	 *            entrance. Defaults to true.
	 */
	public void setStartConferenceOnEnter(Boolean startConferenceOnEnter) {
		this.startConferenceOnEnter = startConferenceOnEnter;
	}
	public Boolean getEndConferenceOnExit() {
		return endConferenceOnExit;
	}
	
	/**
	 * 
	 * @param endConferenceOnExit
	 *            Boolean value specifying if conference should begin upon exit.
	 *            Defaults to true.
	 */
	public void setEndConferenceOnExit(Boolean endConferenceOnExit) {
		this.endConferenceOnExit = endConferenceOnExit;
	}
	public Long getMaxParticipants() {
		return maxParticipants;
	}
	
	/**
	 * 
	 * @param maxParticipants
	 *            The maximum number of participants allowed in the conference
	 *            call. Defaults to 40.
	 */
	public void setMaxParticipants(Long maxParticipants) {
		this.maxParticipants = maxParticipants;
	}
	public String getWaitUrl() {
		return waitUrl;
	}
	
	/**
	 * 
	 * @param waitUrl
	 *            URL conference participants can be sent to while they wait for
	 *            entrance into the conference.
	 */
	public void setWaitUrl(String waitUrl) {
		this.waitUrl = waitUrl;
	}
	public HttpMethod getWaitMethod() {
		return waitMethod;
	}
	
	/**
	 * 
	 * @param waitMethod
	 *            Method used to request waitUrl. Defaults to POST.
	 */
	public void setWaitMethod(HttpMethod waitMethod) {
		this.waitMethod = waitMethod;
	}
	public Boolean getHangupOnStar() {
		return hangupOnStar;
	}
	
	/**
	 * 
	 * @param hangupOnStar
	 *            Boolean value specifying if pressing * should end the
	 *            conference. Defaults to false.
	 */
	public void setHangupOnStar(Boolean hangupOnStar) {
		this.hangupOnStar = hangupOnStar;
	}
	public String getCallbackUrl() {
		return callbackUrl;
	}
	
	/**
	 * 
	 * @param callbackUrl
	 *            URL where some parameters specific to Conference will be sent
	 *            once it is completed.
	 */
	public void setCallbackUrl(String callbackUrl) {
		this.callbackUrl = callbackUrl;
	}
	public HttpMethod getCallbackMethod() {
		return callbackMethod;
	}
	
	/**
	 * 
	 * @param callbackMethod
	 *            Method used to request the callback URL. Defaults to POST.
	 */
	public void setCallbackMethod(HttpMethod callbackMethod) {
		this.callbackMethod = callbackMethod;
	}
	public String getWaitSound() {
		return waitSound;
	}
	
	/**
	 * 
	 * @param waitSound
	 *            URL to sound that can be played while waiting to enter the
	 *            conference.
	 */
	public void setWaitSound(String waitSound) {
		this.waitSound = waitSound;
	}
	public HttpMethod getWaitSoundMethod() {
		return waitSoundMethod;
	}
	
	/**
	 * 
	 * @param waitSoundMethod
	 *            Method used to request the waitsound URL. Defaults to POST.
	 */
	public void setWaitSoundMethod(HttpMethod waitSoundMethod) {
		this.waitSoundMethod = waitSoundMethod;
	}
	public String getDigitsMatch() {
		return digitsMatch;
	}
	
	/**
	 * 
	 * @param digitsMatch
	 *            Specifies digits that TelAPI should listen for and send to the
	 *            callbackUrl if a caller inputs them. Seperate additional
	 *            digits or digit patterns with a comma. Can be a digit, # or *.
	 */
	public void setDigitsMatch(String digitsMatch) {
		this.digitsMatch = digitsMatch;
	}
	public Boolean getStayAlone() {
		return stayAlone;
	}
	
	/**
	 * 
	 * @param stayAlone
	 *            Boolean value specifying if the caller should stay alone in
	 *            the conference call. Defaults to true.
	 */
	public void setStayAlone(Boolean stayAlone) {
		this.stayAlone = stayAlone;
	}
	
	
}
