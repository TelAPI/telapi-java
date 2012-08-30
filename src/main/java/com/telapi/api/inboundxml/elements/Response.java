package com.telapi.api.inboundxml.elements;

import java.util.ArrayList;
import java.util.List;

import com.telapi.api.domain.enums.HttpMethod;
import com.telapi.api.inboundxml.elements.enums.RecordingFileFormat;
import com.telapi.api.inboundxml.elements.enums.RejectReason;
import com.telapi.api.inboundxml.elements.enums.Voice;
import com.telapi.api.inboundxml.parameters.RecordParameters;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

@XStreamAlias("Response")
public class Response {
	@XStreamImplicit
	private List<ResponseElement> elements;
	
	private static XStream xstream;
	
	static {
		xstream = new XStream();
		xstream.processAnnotations(new Class[] { Response.class, Record.class,
				Play.class, Say.class, Number.class, Dial.class,
				Conference.class, Sip.class, Hangup.class, Redirect.class,
				Reject.class, Gather.class, Sms.class, Pause.class });
	}
	
	protected Response() {
		elements = new ArrayList<ResponseElement>();
	}
	
	/**
	 * Creates a new basic response object. This should be called at the beginning of each InboundXML generation.
	 * @return A newly generated response.
	 */
	public static Response create(){
		return new Response();
	}
	
	/**
	 * Adds a Play element to a Response element. The <Play> element plays an
	 * mp3 file for the caller.
	 * 
	 * @param loop
	 *            The amount of times the Play should be repeated. Zero
	 *            indicates an infinite loop. The allowed values are greater
	 *            than or equal to 0. Defaults to 1.
	 * @param resource
	 *            The URL to the mp3 file which should be played (required).
	 * @return The response element which is being created.
	 */
	public Response play(Long loop, String resource) {
		elements.add(Play.createPlay(loop, resource));
		return this;
	}
	
	/**
	 * Adds a Say element to a Response element. The Say element reads text to
	 * the caller using a text-to-speech engine. Say is good to use with dynamic
	 * data, while Play may be a better choice for static information or
	 * prompts.
	 * 
	 * @param text
	 *            The text to be spoken (required).
	 * @param voice
	 *            The type of voice that will read the text to the caller.
	 * @param loop
	 *            The amount of times the spoken text should be repeated. Zero
	 *            indicates an infinite loop. The allowed values are greater
	 *            than or equal to 0. Defaults to 1.
	 * @return The response element which is being created.
	 */
	public Response say(String text, Voice voice, Long loop) {
		elements.add(Say.createSay(text, voice, loop));
		return this;
	}
	
	/**
	 * Adds a Record element to a Response element. The Record element is used
	 * to record audio during a call. It can occur anywhere within an InboundXML
	 * document but will only begin recording once it has been reached. This
	 * means Record would have to be the first element after Response for
	 * the entire call to be recorded. When the recording is complete, a URL of
	 * the recorded audio is created and submitted as a GET or POST to the
	 * action URL.
	 * 
	 * Similar to the Gather element, a timeout value sets how much silence to
	 * allow before the recording ends, maxLength sets how long the recording
	 * may be, and the finishOnKey is used to set which keys will end the
	 * recording. By default, the action and method specify that Record
	 * should make a POST to the URL of the current InboundXML document.
	 * 
	 * @param action URL where some parameters specific to Record will be sent for further processing (required).
	 * @param method Specifies the method to use when requesting the action or transcribeCallback URL.
	 * @param timeout The number of seconds Record should wait during silence before ending. Greater than or equal to 0. Defaults to 5.
	 * @param finishOnKey The key a caller can press to end the Record. Allowed values are 0-9, # or *. Defaults to #.
	 * @param maxLength The maximum length in seconds a recording should be. Defaults to 3600.
	 * @param transcribe Boolean value specifying if the recording should be transcribed. Defaults to false.
	 * @param transcribeCallback URL where the recording transcription will be sent. Defaults to the current InboundXML document.
	 * @param playBeep Boolean value specifying if a beep should be played when the recording begins. Defaults to false.
	 * @param bothLegs Boolean value specifying if both call legs should be recorded. Defaults to false.
	 * @param fileFormat The recording file format. Can be mp3 or wav. Default is mp3.
	 * @return The response element which is being created.
	 */
	public Response record(String action, HttpMethod method, Long timeout, String finishOnKey, Long maxLength, Boolean transcribe, String transcribeCallback, Boolean playBeep, Boolean bothLegs, RecordingFileFormat fileFormat) {
		elements.add(Record.createRecord(action, method, timeout, finishOnKey, maxLength, transcribe, transcribeCallback, playBeep, bothLegs, fileFormat));
		return this;
	}
	
	/**
	 * Convenience method for appending a new Record element.
	 * @see #record(String, HttpMethod, Long, String, Long, Boolean, String, Boolean, Boolean, RecordingFileFormat)
	 * @param action URL where some parameters specific to Record will be sent for further processing (required).
	 * @return The response element which is being created.
	 */
	public Response record(String action) {
		elements.add(Record.createRecord(action));
		return this;
	}
	
	/**
	 * Convenience method for appending a new Record element.
	 * @see #record(String, HttpMethod, Long, String, Long, Boolean, String, Boolean, Boolean, RecordingFileFormat)
	 * 
	 * @param params The RecordParameters used to create the Record element.
	 * @return The response element which is being created.
	 */
	public Response record(RecordParameters params) {
		elements.add(Record.createRecord(params.getAction(),
				params.getMethod(), params.getTimeout(),
				params.getFinishOnKey(), params.getMaxLength(),
				params.getTranscribe(), params.getTranscribeCallback(),
				params.getPlayBeep(), params.getBothLegs(),
				params.getFileFormat()));
		return this;
	}
	
	/**
	 * Adds a Dial element to a Response element. The Dial element starts an
	 * outgoing dial from the current call. Once the dial is complete, the next
	 * element in the InboundXML document will be processed unless the action
	 * attribute is set. In that case the result of the dial is submitted as a
	 * GET or POST (depending on the method attribute) to the action URL, and
	 * the call continues using the InboundXML of that URL.
	 * 
	 * By default the outgoing call will timeout if it is not answered after 30
	 * seconds; however, the timeout attribute can be used to set a custom time.
	 * The length of the call is limited by the timeLimit attribute, which is 4
	 * hours (14400 seconds) by default.
	 * 
	 * Setting the hangupOnStar attribute to 'true' will allow the original call
	 * to terminate the outgoing call without having to hang up by dialing '*'.
	 * The original call then continues with the current InboundXML document, or
	 * if a URL was passed, the response from the action attribute.
	 * 
	 * The callerId attribute can be set to any number, and will default to the
	 * caller id of the original caller. The number to be dialed should be
	 * nested within the Dial element. For more options, use the Number or
	 * Conference elements instead of a simple phone number.
	 * 
	 * @param dial
	 *            A new Dial element which must be created by calling
	 *            Dial.create(...).
	 * @return The response element which is being created.
	 */
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
	
	public String createXml() {
		return xstream.toXML(this);
	}
}
