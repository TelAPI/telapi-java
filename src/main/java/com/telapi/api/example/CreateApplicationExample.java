package com.telapi.api.example;

import com.telapi.api.TelapiConnector;
import com.telapi.api.configuration.BasicTelapiConfiguration;
import com.telapi.api.domain.Application;
import com.telapi.api.exceptions.TelapiException;
import com.telapi.api.requests.ApplicationRequest;

public class CreateApplicationExample {

	public static void main(String[] args) {
		BasicTelapiConfiguration conf = new BasicTelapiConfiguration();
		conf.setSid("{AccountSid}");
		conf.setAuthToken("{AuthToken}");
		TelapiConnector conn = new TelapiConnector(conf);
		
		ApplicationRequest applicationRequest = new ApplicationRequest();
		applicationRequest.setFriendlyName("Welcome Application");
		applicationRequest.setVoiceUrl("http://telapi.com/ivr/welcome/call");
		applicationRequest.setSmsUrl("http://telapi.com/ivr/welcome/sms");
		
		try {
			Application application = conn.createApplication(applicationRequest);
			System.out.println(application.getSid());
		} catch (TelapiException e) {
			e.printStackTrace();
		}
	}
}
