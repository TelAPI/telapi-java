package com.telapi.api.inboundxml.parameters;

import com.telapi.api.domain.enums.HttpMethod;


public class DialParameters {

	private String number;
	private String action;
	private HttpMethod method;
	private Long timeout;
	private Boolean hangupOnStar;
	private Long timeLimit;
	private String callerId;
	private Boolean hideCallerId;
	private String dialMusic;
	private String callbackUrl;
	private HttpMethod callbackMethod;
	private Boolean confirmSound;
	private String digitsMatch;
	private Boolean straightToVm;
	private String heartbeatUrl;
	private HttpMethod heartbeatMethod;
	private String forwardedFrom;
	

	public String getNumber() {
		return number;
	}
	
	/**
	 * The number which is to be dialed. If used, you cannot append elements to the Dial element. 
	 * @param number The number which is to be dialed.
	 */
	public void setNumber(String number) {
		this.number = number;
	}
	public String getAction() {
		return action;
	}
	
	/**
	 * 
	 * @param action URL where some parameters specific to Dial will be sent for further processing. The calling party can be redirected here upon the hang up of the B leg caller.
	 */
	public void setAction(String action) {
		this.action = action;
	}
	public HttpMethod getMethod() {
		return method;
	}
	
	/**
	 * 
	 * @param method Method used to request the action URL. Defaults to POST.
	 */
	public void setMethod(HttpMethod method) {
		this.method = method;
	}
	public Long getTimeout() {
		return timeout;
	}
	
	/**
	 * 
	 * @param timeout The number of seconds calls made with <Dial> are allowed silence before ending. Defaults to 30.
	 */
	public void setTimeout(Long timeout) {
		this.timeout = timeout;
	}
	public Boolean getHangupOnStar() {
		return hangupOnStar;
	}
	
	/**
	 * 
	 * @param hangupOnStar Boolean value specifying if pressing * should end the dial. Defaults to false.
	 */
	public void setHangupOnStar(Boolean hangupOnStar) {
		this.hangupOnStar = hangupOnStar;
	}
	public Long getTimeLimit() {
		return timeLimit;
	}
	
	/**
	 * 
	 * @param timeLimit The duration in seconds a call made through <Dial> should occur for before ending. Defaults to 14400.
	 */
	public void setTimeLimit(Long timeLimit) {
		this.timeLimit = timeLimit;
	}
	public String getCallerId() {
		return callerId;
	}
	
	/**
	 * 
	 * @param callerId Number to display as calling. Defaults to the ID of phone being used. Defaults to the caller's caller ID.
	 */
	public void setCallerId(String callerId) {
		this.callerId = callerId;
	}
	public Boolean getHideCallerId() {
		return hideCallerId;
	}
	
	/**
	 * 
	 * @param hideCallerId hideCallerId Boolean value specifying if the caller ID should be hidden or not. Defaults to false.
	 */
	public void setHideCallerId(Boolean hideCallerId) {
		this.hideCallerId = hideCallerId;
	}
	public String getDialMusic() {
		return dialMusic;
	}
	
	/**
	 * 
	 * @param dialMusic URL containing an audio file that can be played during the dial.
	 */
	public void setDialMusic(String dialMusic) {
		this.dialMusic = dialMusic;
	}
	public String getCallbackUrl() {
		return callbackUrl;
	}
	
	/**
	 * 
	 * @param callbackUrl URL requested once the dialed call connects.
	 */
	public void setCallbackUrl(String callbackUrl) {
		this.callbackUrl = callbackUrl;
	}
	public HttpMethod getCallbackMethod() {
		return callbackMethod;
	}
	
	/**
	 * 
	 * @param callbackMethod Method used to request the callback URL. Defaults to POST.
	 */
	public void setCallbackMethod(HttpMethod callbackMethod) {
		this.callbackMethod = callbackMethod;
	}
	public Boolean getConfirmSound() {
		return confirmSound;
	}
	
	/**
	 * 
	 * @param confirmSound Boolean value specifying if a sound should play when dial is successful. Defaults to false.
	 */
	public void setConfirmSound(Boolean confirmSound) {
		this.confirmSound = confirmSound;
	}
	public String getDigitsMatch() {
		return digitsMatch;
	}
	
	/**
	 * 
	 * @param digitsMatch Specifies digits that TelAPI should listen for and send to the callbackUrl if a caller inputs them. Separate additional digits or digit patterns with a comma. Allowed values are digits, # and *.
	 */
	public void setDigitsMatch(String digitsMatch) {
		this.digitsMatch = digitsMatch;
	}
	public Boolean getStraightToVm() {
		return straightToVm;
	}
	
	/**
	 * 
	 * @param straightToVm Boolean value specifying if call should be redirected to voice mail immediately. Defaults to false.
	 */
	public void setStraightToVm(Boolean straightToVm) {
		this.straightToVm = straightToVm;
	}
	public String getHeartbeatUrl() {
		return heartbeatUrl;
	}
	
	/**
	 * 
	 * @param heartbeatUrl A URL TelAPI can request every 60 seconds during the call to notify of elapsed time and pass other general information.
	 */
	public void setHeartbeatUrl(String heartbeatUrl) {
		this.heartbeatUrl = heartbeatUrl;
	}
	public HttpMethod getHeartbeatMethod() {
		return heartbeatMethod;
	}
	
	/**
	 * 
	 * @param heartbeatMethod Method used to request the heartbeat URL. Defaults to POST.
	 */
	public void setHeartbeatMethod(HttpMethod heartbeatMethod) {
		this.heartbeatMethod = heartbeatMethod;
	}
	public String getForwardedFrom() {
		return forwardedFrom;
	}
	
	/**
	 * 
	 * @param forwardedFrom Specifies the number to list the call as forwarded from.
	 */
	public void setForwardedFrom(String forwardedFrom) {
		this.forwardedFrom = forwardedFrom;
	}		 
			 
}
