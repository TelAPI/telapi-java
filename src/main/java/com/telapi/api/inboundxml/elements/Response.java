package com.telapi.api.inboundxml.elements;

import java.util.ArrayList;
import java.util.List;

import com.telapi.api.domain.enums.HttpMethod;
import com.telapi.api.inboundxml.elements.enums.RecordingFileFormat;
import com.telapi.api.inboundxml.elements.enums.RejectReason;
import com.telapi.api.inboundxml.elements.enums.Voice;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

@XStreamAlias("Response")
public class Response {
	@XStreamImplicit
	private List<ResponseElement> elements;
	
	protected Response() {
		elements = new ArrayList<ResponseElement>();
	}
	
	public static Response create(){
		return new Response();
	}
	
	public Response play(Long loop, String resource) {
		elements.add(Play.createPlay(loop, resource));
		return this;
	}
	
	public Response say(String text, Voice voice, Long loop) {
		elements.add(Say.createSay(text, voice, loop));
		return this;
	}
	
	public Response record(String action, HttpMethod method, Long timeout, String finishOnKey, Long maxLength, Boolean transcribe, String transcribeCallback, Boolean playBeep, Boolean bothLegs, RecordingFileFormat fileFormat) {
		elements.add(Record.createRecord(action, method, timeout, finishOnKey, maxLength, transcribe, transcribeCallback, playBeep, bothLegs, fileFormat));
		return this;
	}
	
	public Response record(String action) {
		elements.add(Record.createRecord(action));
		return this;
	}
	
	public Response dial(Dial dial) {
		elements.add(dial);
		return this;
	}
	
	public Response hangup(Long schedule) {
		elements.add(Hangup.createHangup(schedule));
		return this;
	}
	
	public Response hangup() {
		elements.add(Hangup.createHangup(null));
		return this;
	}
	
	public Response redirect(String url) {
		elements.add(Redirect.createRedirect(url, null));
		return this;
	}
	
	public Response redirect(String url, HttpMethod method) {
		elements.add(Redirect.createRedirect(url, method));
		return this;
	}
	
	public Response reject(RejectReason reason) {
		elements.add(Reject.createReject(reason));
		return this;
	}
	
	public Response reject() {
		elements.add(Reject.createReject(null));
		return this;
	}
	
	public Response pause(Long length) {
		elements.add(Pause.createPause(length));
		return this;
	}
	
	public Response pause() {
		elements.add(Pause.createPause(null));
		return this;
	}
	
	public Response sms(String text, String to, String from, String action, HttpMethod method, String statusCallback) {
		elements.add(Sms.createSms(text, to, from, action, method, statusCallback));
		return this;
	}
	
	public Response sms(String text, String to, String from) {
		elements.add(Sms.createSms(text, to, from, null, null, null));
		return this;
	}
	
	public Response gather(Gather gather) {
		elements.add(gather);
		return this;
	}
}
