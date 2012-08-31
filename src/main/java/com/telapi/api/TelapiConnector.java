package com.telapi.api;

import java.net.URI;
import java.util.Date;
import java.util.List;

import javax.ws.rs.core.UriBuilder;

import org.jboss.resteasy.client.ClientResponse;
import org.jboss.resteasy.client.ProxyFactory;
import org.jboss.resteasy.client.core.executors.ApacheHttpClient4Executor;

import com.telapi.api.configuration.TelapiConstants;
import com.telapi.api.configuration.TelapiConfiguration;
import com.telapi.api.domain.Account;
import com.telapi.api.domain.Application;
import com.telapi.api.domain.Call;
import com.telapi.api.domain.CarrierLookup;
import com.telapi.api.domain.Conference;
import com.telapi.api.domain.IncomingPhoneNumber;
import com.telapi.api.domain.Notification;
import com.telapi.api.domain.Recording;
import com.telapi.api.domain.SmsMessage;
import com.telapi.api.domain.StatusResponse;
import com.telapi.api.domain.Transcription;
import com.telapi.api.domain.enums.AudioDirection;
import com.telapi.api.domain.enums.CallInterruptStatus;
import com.telapi.api.domain.enums.CallStatus;
import com.telapi.api.domain.enums.HttpMethod;
import com.telapi.api.domain.enums.Legs;
import com.telapi.api.domain.enums.LogLevel;
import com.telapi.api.domain.enums.TranscriptionType;
import com.telapi.api.domain.list.AccountsList;
import com.telapi.api.domain.list.ApplicationList;
import com.telapi.api.domain.list.AvailablePhoneNumberList;
import com.telapi.api.domain.list.CallList;
import com.telapi.api.domain.list.CnamDipList;
import com.telapi.api.domain.list.ConferenceList;
import com.telapi.api.domain.list.FraudList;
import com.telapi.api.domain.list.IncomingPhoneNumberList;
import com.telapi.api.domain.list.NotificationList;
import com.telapi.api.domain.list.RecordingList;
import com.telapi.api.domain.list.SmsMessageList;
import com.telapi.api.domain.list.TranscriptionList;
import com.telapi.api.exceptions.TelapiException;
import com.telapi.api.http.RestExecutor;
import com.telapi.api.requests.ApplicationRequest;
import com.telapi.api.requests.CallRequest;
import com.telapi.api.requests.IncomingPhoneNumberRequest;
import com.telapi.api.restproxies.AccountsProxy;
import com.telapi.api.restproxies.ApplicationProxy;
import com.telapi.api.restproxies.AvailablePhoneNumberProxy;
import com.telapi.api.restproxies.CallProxy;
import com.telapi.api.restproxies.CarrierLookupProxy;
import com.telapi.api.restproxies.ConferenceProxy;
import com.telapi.api.restproxies.FraudControlProxy;
import com.telapi.api.restproxies.IncomingPhoneNumberProxy;
import com.telapi.api.restproxies.NotificationProxy;
import com.telapi.api.restproxies.RecordingProxy;
import com.telapi.api.restproxies.SmsProxy;
import com.telapi.api.restproxies.TranscriptionProxy;

/**
 * 
 * The class used for all forms of communication with the Telapi REST API.
 *
 */
public class TelapiConnector {

	private ApacheHttpClient4Executor executor;
	private TelapiConfiguration conf;
	private String fullBaseUrl;

	private AccountsProxy accountsProxy;
	private SmsProxy smsProxy;
	private CallProxy callProxy;
	private ConferenceProxy conferenceProxy;
	private ApplicationProxy applicationProxy;
	private IncomingPhoneNumberProxy incomingPhoneNumberProxy;
	private AvailablePhoneNumberProxy availablePhoneNumberProxy;
	private RecordingProxy recordingProxy;
	private NotificationProxy notificationProxy;
	private TranscriptionProxy transcriptionProxy;
	private CarrierLookupProxy carrierLookupProxy;
	private FraudControlProxy fraudControlProxy;

	/**
	 * Creates a new TelapiConnector based on the provided configuration.
	 * 
	 * @param conf
	 *            The configuration based on which the TelapiConnector will be
	 *            created.
	 */
	public TelapiConnector(TelapiConfiguration conf) {
		this.conf = conf;
		executor = RestExecutor.createExecutor(conf);
		URI baseUrl = UriBuilder.fromUri(conf.getBaseUrl())
				.path(TelapiConstants.API_VERSION).build();
		fullBaseUrl = baseUrl.toString();

		accountsProxy = createProxy(AccountsProxy.class);
		smsProxy = createProxy(SmsProxy.class);
		callProxy = createProxy(CallProxy.class);
		conferenceProxy = createProxy(ConferenceProxy.class);
		applicationProxy = createProxy(ApplicationProxy.class);
		incomingPhoneNumberProxy = createProxy(IncomingPhoneNumberProxy.class);
		availablePhoneNumberProxy = createProxy(AvailablePhoneNumberProxy.class);
		recordingProxy = createProxy(RecordingProxy.class);
		notificationProxy = createProxy(NotificationProxy.class);
		transcriptionProxy = createProxy(TranscriptionProxy.class);
		carrierLookupProxy = createProxy(CarrierLookupProxy.class);
		fraudControlProxy = createProxy(FraudControlProxy.class);
	}

	private <T> T createProxy(Class<T> clazz) {
		return ProxyFactory.create(clazz, fullBaseUrl, executor);
	}

	private <T> T returnThrows(ClientResponse<T> response)
			throws TelapiException {
		int status = response.getStatus();
		if (status > 399) {
			TelapiException exception = response
					.getEntity(TelapiException.class);
			throw exception;
		}
		return response.getEntity();
	}

	private String getDateString(Date date) {
		if (date == null)
			return null;
		return TelapiConstants.queryDateFormat.format(date);
	}

	// ACCOUNT

	public Account getAccount(String sid) throws TelapiException {
		ClientResponse<Account> acc = accountsProxy.getAccount(sid);
		return returnThrows(acc);
	}

	public Account getAccount() throws TelapiException {
		return getAccount(conf.getSid());
	}

	public AccountsList getAccounts() throws TelapiException {
		ClientResponse<AccountsList> accounts = accountsProxy.getAccounts();
		return returnThrows(accounts);
	}

	// SMSMESSAGE

	public SmsMessage getSmsMessage(String sid, String smsMessageSid)
			throws TelapiException {
		ClientResponse<SmsMessage> sms = smsProxy.getSmsMessage(sid,
				smsMessageSid);
		return returnThrows(sms);
	}

	public SmsMessage getSmsMessage(String smsMessageSid)
			throws TelapiException {
		return getSmsMessage(conf.getSid(), smsMessageSid);
	}

	public SmsMessageList getSmsMessageList(String sid, String to, String from,
			Date dateSentGte, Date dateSentLt, Long page, Long pageSize)
			throws TelapiException {

		ClientResponse<SmsMessageList> smsList = smsProxy.getSmsMessageList(
				sid, to, from, getDateString(dateSentGte),
				getDateString(dateSentLt), page, pageSize);
		return returnThrows(smsList);
	}

	public SmsMessageList getSmsMessageList(String to, String from,
			Date dateSentGte, Date dateSentLt, Long page, Long pageSize)
			throws TelapiException {
		return getSmsMessageList(conf.getSid(), to, from, dateSentGte,
				dateSentLt, page, pageSize);
	}

	public SmsMessage sendSmsMessage(String sid, String to, String from,
			String body, String statusCallback) throws TelapiException {
		ClientResponse<SmsMessage> smsMessage = smsProxy.sendSmsMessage(sid,
				to, from, body, statusCallback);
		return returnThrows(smsMessage);
	}

	public SmsMessage sendSmsMessage(String to, String from, String body,
			String statusCallback) throws TelapiException {
		return sendSmsMessage(conf.getSid(), to, from, body, statusCallback);
	}

	// CALLS

	public Call viewCall(String accountSid, String callSid)
			throws TelapiException {
		return returnThrows(callProxy.viewCall(accountSid, callSid));
	}

	public Call viewCall(String callSid) throws TelapiException {
		return viewCall(conf.getSid(), callSid);
	}

	public CallList listCalls(String accountSid, String to, String from,
			CallStatus status, Date startTimeGte, Date startTimeLt, Long page,
			Long pageSize) throws TelapiException {
		return returnThrows(callProxy.listCalls(accountSid, to, from, status,
				getDateString(startTimeGte), getDateString(startTimeLt), page,
				pageSize));
	}

	public CallList listCalls(String to, String from, CallStatus status,
			Date startTimeGte, Date startTimeLt, Long page, Long pageSize)
			throws TelapiException {
		return listCalls(conf.getSid(), to, from, status, startTimeGte,
				startTimeLt, page, pageSize);
	}

	public Call makeCall(String accountSid, String to, String from, String url,
			String forwardedFrom, HttpMethod method, String fallbackUrl,
			HttpMethod fallbackMethod, String statusCallback,
			HttpMethod statusCallbackMethod, String sendDigits, Long timeout,
			Boolean hideCallerId) throws TelapiException {
		return returnThrows(callProxy.makeCall(accountSid, to, from, url,
				forwardedFrom, method, fallbackUrl, fallbackMethod,
				statusCallback, statusCallbackMethod, sendDigits, timeout,
				hideCallerId));
	}

	public Call makeCall(String to, String from, String url,
			String forwardedFrom, HttpMethod method, String fallbackUrl,
			HttpMethod fallbackMethod, String statusCallback,
			HttpMethod statusCallbackMethod, String sendDigits, Long timeout,
			Boolean hideCallerId) throws TelapiException {
		return makeCall(conf.getSid(), to, from, url, forwardedFrom, method,
				fallbackUrl, fallbackMethod, statusCallback,
				statusCallbackMethod, sendDigits, timeout, hideCallerId);
	}

	public Call makeCall(CallRequest callRequest) throws TelapiException {
		String accountSid = conf.getSid();
		if (callRequest.getAccountSid() != null)
			accountSid = callRequest.getAccountSid();

		return makeCall(accountSid, callRequest.getTo(), callRequest.getFrom(),
				callRequest.getUrl(), callRequest.getForwardedFrom(),
				callRequest.getMethod(), callRequest.getFallbackUrl(),
				callRequest.getFallbackMethod(),
				callRequest.getStatusCallback(),
				callRequest.getStatusCallbackMethod(),
				callRequest.getSendDigits(), callRequest.getTimeout(),
				callRequest.getHideCallerId());
	}

	public Call interruptLiveCall(String accountSid, String callSid,
			String fallbackUrl, HttpMethod statusCallbackMethod,
			CallInterruptStatus status) throws TelapiException {
		return returnThrows(callProxy.interruptLiveCall(accountSid, callSid,
				fallbackUrl, statusCallbackMethod, status));
	}

	public Call interruptLiveCall(String callSid, String fallbackUrl,
			HttpMethod statusCallbackMethod, CallInterruptStatus status)
			throws TelapiException {
		return interruptLiveCall(conf.getSid(), callSid, fallbackUrl,
				statusCallbackMethod, status);
	}

	public Call hangUpCall(String accountSid, String callSid, String url,
			HttpMethod method) throws TelapiException {
		return returnThrows(callProxy.interruptLiveCall(accountSid, callSid,
				url, method, CallInterruptStatus.COMPLETED));
	}

	public Call hangUpCall(String callSid, String url, HttpMethod method)
			throws TelapiException {
		return hangUpCall(conf.getSid(), callSid, url, method);
	}

	public Call sendDigits(String accountSid, String callSid, String playDtfm,
			Legs dtmfLeg) throws TelapiException {
		return returnThrows(callProxy.sendDigits(accountSid, callSid, playDtfm,
				dtmfLeg));
	}

	public Call sendDigits(String callSid, String playDtfm, Legs dtmfLeg)
			throws TelapiException {
		return sendDigits(conf.getSid(), callSid, playDtfm, dtmfLeg);
	}

	public Call playAudio(String accountSid, String callSid, String soundsUrl,
			Long length, Legs legs, Boolean loop, Boolean mix)
			throws TelapiException {
		return returnThrows(callProxy.playAudio(accountSid, callSid, soundsUrl,
				length, legs, loop, mix));
	}

	public Call playAudio(String callSid, String soundsUrl, Long length,
			Legs legs, Boolean loop, Boolean mix) throws TelapiException {
		return playAudio(conf.getSid(), callSid, soundsUrl, length, legs, loop,
				mix);
	}

	public Call voiceEffects(String accountSid, String callSid,
			AudioDirection audioDirection, Double pitch, Long pitchSemiTones,
			Long pitchOctaves, Double rate) throws TelapiException {
		return returnThrows(callProxy.voiceEffects(accountSid, callSid,
				audioDirection, pitch, pitchSemiTones, pitchOctaves, rate));
	}

	public Call voiceEffects(String callSid, AudioDirection audioDirection,
			Double pitch, Long pitchSemiTones, Long pitchOctaves, Double rate)
			throws TelapiException {
		return voiceEffects(conf.getSid(), callSid, audioDirection, pitch,
				pitchSemiTones, pitchOctaves, rate);
	}

	public Recording recordCall(String accountSid, String callSid,
			Boolean record, Long timeLimit, String callbackUrl)
			throws TelapiException {
		return returnThrows(callProxy.recordCall(accountSid, callSid, record,
				timeLimit, callbackUrl));
	}

	public Recording recordCall(String callSid, Boolean record, Long timeLimit,
			String callbackUrl) throws TelapiException {
		return recordCall(conf.getSid(), callSid, record, timeLimit,
				callbackUrl);
	}

	// CONFERENCE

	public Conference viewConference(String accountSid, String conferenceSid,
			String memberId, Boolean muted, Boolean deafed)
			throws TelapiException {
		return returnThrows(conferenceProxy.viewConference(accountSid,
				conferenceSid, memberId, muted, deafed));
	}

	public ConferenceList listConferences(String accountSid, String memberId,
			Boolean muted, Boolean deafed, Long page, Long pageSize)
			throws TelapiException {
		return returnThrows(conferenceProxy.listConferences(accountSid,
				memberId, muted, deafed, page, pageSize));
	}

	public Conference muteMember(String accountSid, String conferenceSid,
			String memberId) throws TelapiException {
		return returnThrows(conferenceProxy.muteMember(accountSid,
				conferenceSid, memberId));
	}

	public Conference unMuteMember(String accountSid, String conferenceSid,
			String memberId) throws TelapiException {
		return returnThrows(conferenceProxy.unMuteMember(accountSid,
				conferenceSid, memberId));
	}

	public Conference deafMember(String accountSid, String conferenceSid,
			String memberId) throws TelapiException {
		return returnThrows(conferenceProxy.deafMember(accountSid,
				conferenceSid, memberId));
	}

	public Conference unDeafMember(String accountSid, String conferenceSid,
			String memberId) throws TelapiException {
		return returnThrows(conferenceProxy.unDeafMember(accountSid,
				conferenceSid, memberId));
	}

	public StatusResponse hangupMember(String accountSid, String conferenceSid,
			String memberId) throws TelapiException {
		return returnThrows(conferenceProxy.hangupMember(accountSid,
				conferenceSid, memberId));
	}

	public Conference kickMember(String accountSid, String conferenceSid,
			String memberId) throws TelapiException {
		return returnThrows(conferenceProxy.kickMember(accountSid,
				conferenceSid, memberId));
	}

	public StatusResponse speakText(String accountSid, String conferenceSid,
			String memberId, String text) throws TelapiException {
		return returnThrows(conferenceProxy.speakText(accountSid,
				conferenceSid, memberId, text));
	}

	public StatusResponse playAudio(String accountSid, String conferenceSid,
			String memberId, String url) throws TelapiException {
		return returnThrows(conferenceProxy.playAudio(accountSid,
				conferenceSid, memberId, url));
	}

	public StatusResponse startRecording(String accountSid, String conferenceSid)
			throws TelapiException {
		return returnThrows(conferenceProxy.startRecording(accountSid,
				conferenceSid));
	}

	public StatusResponse stopRecording(String accountSid, String conferenceSid)
			throws TelapiException {
		return returnThrows(conferenceProxy.stopRecording(accountSid,
				conferenceSid));
	}

	public Conference viewConference(String conferenceSid, String memberId,
			Boolean muted, Boolean deafed) throws TelapiException {
		return viewConference(conf.getSid(), conferenceSid, memberId, muted,
				deafed);
	}

	public ConferenceList listConferences(String memberId, Boolean muted,
			Boolean deafed, Long page, Long pageSize) throws TelapiException {
		return listConferences(conf.getSid(), memberId, muted, deafed, page,
				pageSize);
	}

	public Conference muteMember(String conferenceSid, String memberId)
			throws TelapiException {
		return muteMember(conf.getSid(), conferenceSid, memberId);
	}

	public Conference unMuteMember(String conferenceSid, String memberId)
			throws TelapiException {
		return unMuteMember(conf.getSid(), conferenceSid, memberId);
	}

	public Conference deafMember(String conferenceSid, String memberId)
			throws TelapiException {
		return deafMember(conf.getSid(), conferenceSid, memberId);
	}

	public Conference unDeafMember(String conferenceSid, String memberId)
			throws TelapiException {
		return unDeafMember(conf.getSid(), conferenceSid, memberId);
	}

	public StatusResponse hangupMember(String conferenceSid, String memberId)
			throws TelapiException {
		return hangupMember(conf.getSid(), conferenceSid, memberId);
	}

	public Conference kickMember(String conferenceSid, String memberId)
			throws TelapiException {
		return kickMember(conf.getSid(), conferenceSid, memberId);
	}

	public StatusResponse speakText(String conferenceSid, String memberId,
			String text) throws TelapiException {
		return speakText(conf.getSid(), conferenceSid, memberId, text);
	}

	public StatusResponse playAudio(String conferenceSid, String memberId,
			String url) throws TelapiException {
		return playAudio(conf.getSid(), conferenceSid, memberId, url);
	}

	public StatusResponse startRecording(String conferenceSid)
			throws TelapiException {
		return startRecording(conf.getSid(), conferenceSid);
	}

	public StatusResponse stopRecording(String conferenceSid)
			throws TelapiException {
		return stopRecording(conf.getSid(), conferenceSid);
	}

	// APPLICATIONS

	public Application viewApplication(String accountSid, String applicationSid)
			throws TelapiException {
		return returnThrows(applicationProxy.viewApplication(accountSid,
				applicationSid));
	}

	public ApplicationList listApplications(String accountSid,
			String friendlyName, Long page, Long pageSize)
			throws TelapiException {
		return returnThrows(applicationProxy.listApplications(accountSid,
				friendlyName, page, pageSize));
	}

	public Application createApplication(String accountSid,
			String friendlyName, String voiceUrl, HttpMethod voiceMethod,
			String voiceFallbackUrl, HttpMethod voiceFallbackMethod,
			Boolean voiceCallerIdLookup, String smsUrl, HttpMethod smsMethod,
			String smsFallbackUrl, HttpMethod smsFallbackMethod,
			String heartbeatUrl, HttpMethod heartbeatMethod,
			String statusCallback, HttpMethod statusCallbackMethod)
			throws TelapiException {
		return returnThrows(applicationProxy.createApplication(accountSid,
				friendlyName, voiceUrl, voiceMethod, voiceFallbackUrl,
				voiceFallbackMethod, voiceCallerIdLookup, smsUrl, smsMethod,
				smsFallbackUrl, smsFallbackMethod, heartbeatUrl,
				heartbeatMethod, statusCallback, statusCallbackMethod));
	}

	public Application createApplication(ApplicationRequest applicationRequest)
			throws TelapiException {
		String accountSid = conf.getSid();
		if (applicationRequest.getAccountSid() != null) {
			accountSid = applicationRequest.getAccountSid();
		}
		return createApplication(accountSid,
				applicationRequest.getFriendlyName(),
				applicationRequest.getVoiceUrl(),
				applicationRequest.getVoiceMethod(),
				applicationRequest.getVoiceFallbackUrl(),
				applicationRequest.getVoiceFallbackMethod(),
				applicationRequest.getVoiceCallerIdLookup(),
				applicationRequest.getSmsUrl(),
				applicationRequest.getSmsMethod(),
				applicationRequest.getSmsFallbackUrl(),
				applicationRequest.getSmsFallbackMethod(),
				applicationRequest.getHeartbeatUrl(),
				applicationRequest.getHeartbeatMethod(),
				applicationRequest.getStatusCallback(),
				applicationRequest.getStatusCallbackMethod());
	}

	public Application updateApplication(String accountSid,
			String applicationSid, String friendlyName, String voiceUrl,
			HttpMethod voiceMethod, String voiceFallbackUrl,
			HttpMethod voiceFallbackMethod, Boolean voiceCallerIdLookup,
			String smsUrl, HttpMethod smsMethod, String smsFallbackUrl,
			HttpMethod smsFallbackMethod, String heartbeatUrl,
			HttpMethod heartbeatMethod, String statusCallback,
			HttpMethod statusCallbackMethod) throws TelapiException {
		return returnThrows(applicationProxy.updateApplication(accountSid,
				applicationSid, friendlyName, voiceUrl, voiceMethod,
				voiceFallbackUrl, voiceFallbackMethod, voiceCallerIdLookup,
				smsUrl, smsMethod, smsFallbackUrl, smsFallbackMethod,
				heartbeatUrl, heartbeatMethod, statusCallback,
				statusCallbackMethod));
	}

	public Application updateApplication(ApplicationRequest applicationRequest)
			throws TelapiException {
		String accountSid = conf.getSid();
		if (applicationRequest.getAccountSid() != null) {
			accountSid = applicationRequest.getAccountSid();
		}
		return updateApplication(accountSid, applicationRequest.getSid(),
				applicationRequest.getFriendlyName(),
				applicationRequest.getVoiceUrl(),
				applicationRequest.getVoiceMethod(),
				applicationRequest.getVoiceFallbackUrl(),
				applicationRequest.getVoiceFallbackMethod(),
				applicationRequest.getVoiceCallerIdLookup(),
				applicationRequest.getSmsUrl(),
				applicationRequest.getSmsMethod(),
				applicationRequest.getSmsFallbackUrl(),
				applicationRequest.getSmsFallbackMethod(),
				applicationRequest.getHeartbeatUrl(),
				applicationRequest.getHeartbeatMethod(),
				applicationRequest.getStatusCallback(),
				applicationRequest.getStatusCallbackMethod());
	}

	public Application deleteApplication(String accountSid,
			String applicationSid) throws TelapiException {
		return returnThrows(applicationProxy.deleteApplication(accountSid,
				applicationSid));
	}

	public Application viewApplication(String applicationSid)
			throws TelapiException {
		return viewApplication(conf.getSid(), applicationSid);
	}

	public ApplicationList listApplications(String friendlyName, Long page,
			Long pageSize) throws TelapiException {
		return listApplications(conf.getSid(), friendlyName, page, pageSize);
	}

	public Application createApplication(String friendlyName, String voiceUrl,
			HttpMethod voiceMethod, String voiceFallbackUrl,
			HttpMethod voiceFallbackMethod, Boolean voiceCallerIdLookup,
			String smsUrl, HttpMethod smsMethod, String smsFallbackUrl,
			HttpMethod smsFallbackMethod, String heartbeatUrl,
			HttpMethod heartbeatMethod, String statusCallback,
			HttpMethod statusCallbackMethod) throws TelapiException {
		return createApplication(conf.getSid(), friendlyName, voiceUrl,
				voiceMethod, voiceFallbackUrl, voiceFallbackMethod,
				voiceCallerIdLookup, smsUrl, smsMethod, smsFallbackUrl,
				smsFallbackMethod, heartbeatUrl, heartbeatMethod,
				statusCallback, statusCallbackMethod);
	}

	public Application updateApplication(String applicationSid,
			String friendlyName, String voiceUrl, HttpMethod voiceMethod,
			String voiceFallbackUrl, HttpMethod voiceFallbackMethod,
			Boolean voiceCallerIdLookup, String smsUrl, HttpMethod smsMethod,
			String smsFallbackUrl, HttpMethod smsFallbackMethod,
			String heartbeatUrl, HttpMethod heartbeatMethod,
			String statusCallback, HttpMethod statusCallbackMethod)
			throws TelapiException {
		return updateApplication(conf.getSid(), applicationSid, friendlyName,
				voiceUrl, voiceMethod, voiceFallbackUrl, voiceFallbackMethod,
				voiceCallerIdLookup, smsUrl, smsMethod, smsFallbackUrl,
				smsFallbackMethod, heartbeatUrl, heartbeatMethod,
				statusCallback, statusCallbackMethod);
	}

	public Application deleteApplication(String applicationSid)
			throws TelapiException {
		return deleteApplication(conf.getSid(), applicationSid);
	}

	// INCOMING PHONE NUMBERS

	public IncomingPhoneNumber viewIncomingPhoneNumber(String accountSid,
			String incomingPhoneNumberSid) throws TelapiException {
		return returnThrows(incomingPhoneNumberProxy.viewIncomingPhoneNumber(
				accountSid, incomingPhoneNumberSid));
	}

	public IncomingPhoneNumberList listIncomingPhoneNumbers(String accountSid,
			String phoneNumber, String friendlyName, Long page, Long pageSize)
			throws TelapiException {
		return returnThrows(incomingPhoneNumberProxy.listIncomingPhoneNumbers(
				accountSid, phoneNumber, friendlyName, page, pageSize));
	}

	public IncomingPhoneNumber addIncomingPhoneNumber(String accountSid,
			String phoneNumber, String areaCode) throws TelapiException {
		return returnThrows(incomingPhoneNumberProxy.addIncomingPhoneNumber(
				accountSid, phoneNumber, areaCode));
	}

	public IncomingPhoneNumber deleteIncomingPhoneNumber(String accountSid,
			String incomingPhoneNumberSid) throws TelapiException {
		return returnThrows(incomingPhoneNumberProxy.deleteIncomingPhoneNumber(
				accountSid, incomingPhoneNumberSid));
	}

	public IncomingPhoneNumber updateIncomingPhoneNumber(String accountSid,
			String incomingPhoneNumberSid, String friendlyName,
			String voiceUrl, HttpMethod voiceMethod, String voiceFallbackUrl,
			HttpMethod voiceFallbackMethod, Boolean voiceCallerIdLookup,
			String smsUrl, HttpMethod smsMethod, String smsFallbackUrl,
			HttpMethod smsFallbackMethod, String statusCallback,
			HttpMethod statusCallbackMethod) throws TelapiException {
		return returnThrows(incomingPhoneNumberProxy.updateIncomingPhoneNumber(
				accountSid, incomingPhoneNumberSid, friendlyName, voiceUrl,
				voiceMethod, voiceFallbackUrl, voiceFallbackMethod,
				voiceCallerIdLookup, smsUrl, smsMethod, smsFallbackUrl,
				smsFallbackMethod, statusCallback, statusCallbackMethod));
	}

	public IncomingPhoneNumber updateIncomingPhoneNumber(
			IncomingPhoneNumberRequest ipnRequest) throws TelapiException {
		String accountSid = conf.getSid();
		if (ipnRequest.getAccountSid() != null) {
			accountSid = ipnRequest.getAccountSid();
		}
		return updateIncomingPhoneNumber(accountSid,
				ipnRequest.getIncomingPhoneNumberSid(),
				ipnRequest.getFriendlyName(), ipnRequest.getVoiceUrl(),
				ipnRequest.getVoiceMethod(), ipnRequest.getVoiceFallbackUrl(),
				ipnRequest.getVoiceFallbackMethod(),
				ipnRequest.getVoiceCallerIdLookup(), ipnRequest.getSmsUrl(),
				ipnRequest.getSmsMethod(), ipnRequest.getSmsFallbackUrl(),
				ipnRequest.getSmsFallbackMethod(),
				ipnRequest.getStatusCallback(),
				ipnRequest.getStatusCallbackMethod());
	}

	public IncomingPhoneNumber viewIncomingPhoneNumber(
			String incomingPhoneNumberSid) throws TelapiException {
		return viewIncomingPhoneNumber(conf.getSid(), incomingPhoneNumberSid);
	}

	public IncomingPhoneNumberList listIncomingPhoneNumbers(String phoneNumber,
			String friendlyName, Long page, Long pageSize)
			throws TelapiException {
		return listIncomingPhoneNumbers(conf.getSid(), phoneNumber,
				friendlyName, page, pageSize);
	}

	public IncomingPhoneNumber addIncomingPhoneNumber(String phoneNumber,
			String areaCode) throws TelapiException {
		return addIncomingPhoneNumber(conf.getSid(), phoneNumber, areaCode);
	}

	public IncomingPhoneNumber deleteIncomingPhoneNumber(
			String incomingPhoneNumberSid) throws TelapiException {
		return deleteIncomingPhoneNumber(conf.getSid(), incomingPhoneNumberSid);
	}

	public IncomingPhoneNumber updateIncomingPhoneNumber(
			String incomingPhoneNumberSid, String friendlyName,
			String voiceUrl, HttpMethod voiceMethod, String voiceFallbackUrl,
			HttpMethod voiceFallbackMethod, Boolean voiceCallerIdLookup,
			String smsUrl, HttpMethod smsMethod, String smsFallbackUrl,
			HttpMethod smsFallbackMethod, String statusCallback,
			HttpMethod statusCallbackMethod) throws TelapiException {
		return updateIncomingPhoneNumber(conf.getSid(), incomingPhoneNumberSid,
				friendlyName, voiceUrl, voiceMethod, voiceFallbackUrl,
				voiceFallbackMethod, voiceCallerIdLookup, smsUrl, smsMethod,
				smsFallbackUrl, smsFallbackMethod, statusCallback,
				statusCallbackMethod);
	}

	// AVAILABLE PHONE NUMBERS

	public AvailablePhoneNumberList listAvailablePhoneNumbers(
			String accountSid, String isoCountryCode, String areaCode,
			String contains, String inRegion, String inPostalCode)
			throws TelapiException {
		return returnThrows(availablePhoneNumberProxy
				.listAvailablePhoneNumbers(accountSid, isoCountryCode,
						areaCode, contains, inRegion, inPostalCode));
	}

	public AvailablePhoneNumberList listAvailablePhoneNumbers(
			String isoCountryCode, String areaCode, String contains,
			String inRegion, String inPostalCode) throws TelapiException {
		return returnThrows(availablePhoneNumberProxy
				.listAvailablePhoneNumbers(conf.getSid(), isoCountryCode,
						areaCode, contains, inRegion, inPostalCode));
	}

	// RECORDINGS

	public RecordingList listRecordings(String accountSid, Date dateCreatedGte,
			Date dateCreatedLt, Long page, Long pageSize)
			throws TelapiException {
		return returnThrows(recordingProxy.listRecordings(accountSid,
				getDateString(dateCreatedGte), getDateString(dateCreatedLt),
				page, pageSize));
	}

	public RecordingList listRecordings(Date dateCreatedGte,
			Date dateCreatedLt, Long page, Long pageSize)
			throws TelapiException {
		return listRecordings(conf.getSid(), dateCreatedGte, dateCreatedLt,
				page, pageSize);
	}

	public RecordingList listCallRecordings(String accountSid, String callSid,
			Date dateCreatedGte, Date dateCreatedLt, Long page, Long pageSize)
			throws TelapiException {
		return returnThrows(recordingProxy.listCallRecordings(accountSid,
				callSid, getDateString(dateCreatedGte),
				getDateString(dateCreatedLt), page, pageSize));
	}

	public RecordingList listCallRecordings(String callSid,
			Date dateCreatedGte, Date dateCreatedLt, Long page, Long pageSize)
			throws TelapiException {
		return listCallRecordings(conf.getSid(), callSid, dateCreatedGte,
				dateCreatedLt, page, pageSize);
	}

	public Recording viewRecording(String accountSid, String recordingSid)
			throws TelapiException {
		return returnThrows(recordingProxy.viewRecording(accountSid,
				recordingSid));
	}

	public Recording viewRecording(String recordingSid) throws TelapiException {
		return viewRecording(conf.getSid(), recordingSid);
	}

	public String getRecordingUrl(String accountSid, String recordingSid)
			throws TelapiException {
		return returnThrows(recordingProxy.getRecording(accountSid,
				recordingSid));
	}

	public String getRecordingUrl(String recordingSid) throws TelapiException {
		return getRecordingUrl(conf.getSid(), recordingSid);
	}

	// NOTIFICATIONS

	public NotificationList listNotifications(String accountSid, LogLevel log,
			Long page, Long pageSize) throws TelapiException {
		return returnThrows(notificationProxy.listNotifications(accountSid,
				log, page, pageSize));
	}

	public NotificationList listNotifications(LogLevel log, Long page,
			Long pageSize) throws TelapiException {
		return listNotifications(conf.getSid(), log, page, pageSize);
	}

	public NotificationList listCallNotifications(String accountSid,
			String callSid, LogLevel log, Long page, Long pageSize)
			throws TelapiException {
		return returnThrows(notificationProxy.listCallNotifications(accountSid,
				callSid, log, page, pageSize));
	}

	public NotificationList listCallNotifications(String callSid, LogLevel log,
			Long page, Long pageSize) throws TelapiException {
		return listCallNotifications(conf.getSid(), callSid, log, page,
				pageSize);
	}

	public Notification viewNotification(String accountSid,
			String notificationSid) throws TelapiException {
		return returnThrows(notificationProxy.viewNotification(accountSid,
				notificationSid));
	}

	public Notification viewNotification(String notificationSid)
			throws TelapiException {
		return viewNotification(conf.getSid(), notificationSid);
	}

	// TRANSCRIPTIONS

	public Transcription viewTranscription(String accountSid,
			String transcriptionSid) throws TelapiException {
		return returnThrows(transcriptionProxy.viewTranscription(accountSid,
				transcriptionSid));
	}

	public String viewTranscriptionText(String accountSid,
			String transcriptionSid) throws TelapiException {
		return returnThrows(transcriptionProxy.viewTranscriptionText(
				accountSid, transcriptionSid));
	}

	public TranscriptionList listTranscriptions(String accountSid, Long page,
			Long pageSize) throws TelapiException {
		return returnThrows(transcriptionProxy.listTranscriptions(accountSid,
				page, pageSize));
	}

	public TranscriptionList listRecordingTranscriptions(String accountSid,
			String recordingSid, Long page, Long pageSize)
			throws TelapiException {
		return returnThrows(transcriptionProxy.listRecordingTranscriptions(
				accountSid, recordingSid, page, pageSize));
	}

	public Transcription transcribeRecording(String accountSid,
			String recordingSid, String transcribeCallback,
			HttpMethod callbackMethod, TranscriptionType quality)
			throws TelapiException {
		return returnThrows(transcriptionProxy.transcribeRecording(accountSid,
				recordingSid, transcribeCallback, callbackMethod, quality));
	}

	public Transcription transcribeAudioUrl(String accountSid, String audioUrl,
			String transcribeCallback, HttpMethod callbackMethod,
			TranscriptionType quality) throws TelapiException {
		return returnThrows(transcriptionProxy.transcribeAudioUrl(accountSid,
				audioUrl, transcribeCallback, callbackMethod, quality));
	}

	public Transcription viewTranscription(String transcriptionSid)
			throws TelapiException {
		return viewTranscription(conf.getSid(), transcriptionSid);
	}

	public String viewTranscriptionText(String transcriptionSid)
			throws TelapiException {
		return viewTranscriptionText(conf.getSid(), transcriptionSid);
	}

	public TranscriptionList listTranscriptions(Long page, Long pageSize)
			throws TelapiException {
		return listTranscriptions(conf.getSid(), page, pageSize);
	}

	public TranscriptionList listRecordingTranscriptions(String recordingSid,
			Long page, Long pageSize) throws TelapiException {
		return listRecordingTranscriptions(conf.getSid(), recordingSid, page,
				pageSize);
	}

	public Transcription transcribeRecording(String recordingSid,
			String transcribeCallback, HttpMethod callbackMethod,
			TranscriptionType quality) throws TelapiException {
		return transcribeRecording(conf.getSid(), recordingSid,
				transcribeCallback, callbackMethod, quality);
	}

	public Transcription transcribeAudioUrl(String audioUrl,
			String transcribeCallback, HttpMethod callbackMethod,
			TranscriptionType quality) throws TelapiException {
		return transcribeAudioUrl(conf.getSid(), audioUrl, transcribeCallback,
				callbackMethod, quality);
	}

	// CARRIER SERVICES

	public CarrierLookup carrierLookup(String accountSid, String phoneNumber)
			throws TelapiException {
		return returnThrows(carrierLookupProxy.carrierLookup(accountSid,
				phoneNumber));
	}

	public CnamDipList cnamLookup(String accountSid, String phoneNumber)
			throws TelapiException {
		return returnThrows(carrierLookupProxy.cnamLookup(accountSid,
				phoneNumber));
	}

	public CnamDipList cnamLookup(String accountSid, List<String> phoneNumbers)
			throws TelapiException {
		return returnThrows(carrierLookupProxy.cnamLookup(accountSid,
				phoneNumbers));
	}

	public CarrierLookup carrierLookup(String phoneNumber)
			throws TelapiException {
		return carrierLookup(conf.getSid(), phoneNumber);
	}

	public CnamDipList cnamLookup(String phoneNumber) throws TelapiException {
		return cnamLookup(conf.getSid(), phoneNumber);
	}

	public CnamDipList cnamLookup(List<String> phoneNumbers)
			throws TelapiException {
		return cnamLookup(conf.getSid(), phoneNumbers);
	}

	// FRAUD CONTROL

	public FraudList listFraudControlResources(String accountSid, Long page,
			Long pageSize) throws TelapiException {
		return returnThrows(fraudControlProxy.listFraudControlResources(
				accountSid, page, pageSize));
	}

	public FraudList authorizeDestination(String accountSid,
			String countryCode, Boolean mobileBreakout,
			Boolean landlineBreakout, Boolean smsEnabled)
			throws TelapiException {
		return returnThrows(fraudControlProxy.authorizeDestination(accountSid,
				countryCode, mobileBreakout, landlineBreakout, smsEnabled));
	}

	public FraudList blockDestination(String accountSid, String countryCode,
			Boolean mobileBreakout, Boolean landlineBreakout, Boolean smsEnabled)
			throws TelapiException {
		return returnThrows(fraudControlProxy.blockDestination(accountSid,
				countryCode, mobileBreakout, landlineBreakout, smsEnabled));
	}

	public FraudList extendDestinationAuth(String accountSid,
			String countryCode, Boolean mobileBreakout,
			Boolean landlineBreakout, Boolean smsEnabled)
			throws TelapiException {
		return returnThrows(fraudControlProxy.extendDestinationAuth(accountSid,
				countryCode, mobileBreakout, landlineBreakout, smsEnabled));
	}

	public FraudList whitelistDestination(String accountSid,
			String countryCode, Boolean mobileBreakout,
			Boolean landlineBreakout, Boolean smsEnabled)
			throws TelapiException {
		return returnThrows(fraudControlProxy.whitelistDestination(accountSid,
				countryCode, mobileBreakout, landlineBreakout, smsEnabled));
	}

	public FraudList listFraudControlResources(Long page, Long pageSize)
			throws TelapiException {
		return listFraudControlResources(conf.getSid(), page, pageSize);
	}

	public FraudList authorizeDestination(String countryCode,
			Boolean mobileBreakout, Boolean landlineBreakout, Boolean smsEnabled)
			throws TelapiException {
		return authorizeDestination(conf.getSid(), countryCode, mobileBreakout,
				landlineBreakout, smsEnabled);
	}

	public FraudList blockDestination(String countryCode,
			Boolean mobileBreakout, Boolean landlineBreakout, Boolean smsEnabled)
			throws TelapiException {
		return blockDestination(conf.getSid(), countryCode, mobileBreakout,
				landlineBreakout, smsEnabled);
	}

	public FraudList extendDestinationAuth(String countryCode,
			Boolean mobileBreakout, Boolean landlineBreakout, Boolean smsEnabled)
			throws TelapiException {
		return extendDestinationAuth(conf.getSid(), countryCode,
				mobileBreakout, landlineBreakout, smsEnabled);
	}

	public FraudList whitelistDestination(String countryCode,
			Boolean mobileBreakout, Boolean landlineBreakout, Boolean smsEnabled)
			throws TelapiException {
		return whitelistDestination(conf.getSid(), countryCode, mobileBreakout,
				landlineBreakout, smsEnabled);
	}

}
