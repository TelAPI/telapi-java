## TelAPI Java Wrapper

The TelAPI Java wrapper is an open source tool built for easy access to the [TelAPI.com](http://telapi.com) API infrastructure. TelAPI is a powerful cloud communications API built to enable your applications to send and receive SMS messages and phone calls, all while controlling the call flow. Additional features include conferencing, phone calls, text-to-speech, recordings, transcriptions and much more.

For more information about what TelAPI is, please visit: [TelAPI Features](http://www.telapi.com/features) or [TelAPI REST documentation](http://www.telapi.com/docs/api/rest/)

What can you do with TelAPI? Here's an example SMS burglar alarm: https://github.com/mattwilliamson/arduino-sms-alarm

---

### REST Introduction

Everything you need to know about how to use the TelAPI Java Wrapper can be found in the [example directory](https://github.com/TelAPI/telapi-java/tree/master/src/main/java/com/telapi/api/example).
Examples for using InboundXml can be found [here](https://github.com/TelAPI/telapi-java/tree/master/src/main/java/com/telapi/api/inboundxml/example).
Just replace the provided example `{AccountSid}` and `{AuthToken}` with the values from your [TelAPI Account Dashboard](https://www.telapi.com/dashboard/).

##### Currently available REST API resources

* **accounts**                  - Fetch or set account details
* **notifications**             - View notifications, such as application errors
* **recordings**                - List recordings
* **sms_messages**              - Send or view SMS messages
* **transcriptions**            - View or submit a recording for transcribing to text
* **calls**                     - View or place calls
* **carrier**                   - Look up the carrier for a number
* **cnam**                      - Look up the caller ID for a number
* **incoming_phone_numbers**    - List or purchase a phone number
* **available_phone_numbers**   - Search for available phone numbers
* **conferences**               - List conference details
* **fraud**                     - Manage destinations and grant/revoke access privileges
* **applications**              - Automate common number configurations for one or many phone numbers

##### Example usage - Sending an SMS

```java
BasicTelapiConfiguration conf = new BasicTelapiConfiguration("{your-account-sid}", "{your-auth-token}");
TelapiConnector conn = new TelapiConnector(conf);

try {
	SmsMessage smsMessage = conn
			.sendSmsMessage(
					"+12233312344",
					"+12233312345",
					"Hello world!",
					null);
	
	System.out.println(smsMessage.getStatus());
	
} catch (TelapiException e) {
	e.printStackTrace();
}
```


For more information such as which properties are available for existing resources, please visit [TelAPI REST Documenatation](http://www.telapi.com/docs/api/rest/)

----
