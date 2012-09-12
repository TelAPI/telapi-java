package com.telapi.api.example;

import com.telapi.api.TelapiConnector;
import com.telapi.api.configuration.BasicTelapiConfiguration;
import com.telapi.api.domain.Application;
import com.telapi.api.exceptions.TelapiException;
import com.telapi.api.requests.ApplicationRequest;

public class UpdateApplicationExample {

	public static void main(String[] args) {
		BasicTelapiConfiguration conf = new BasicTelapiConfiguration();
		conf.setSid("{AccountSid}");
		conf.setAuthToken("{AuthToken}");
		TelapiConnector conn = new TelapiConnector(conf);
		
		ApplicationRequest applicationRequest = new ApplicationRequest();

		//the sid of the Application which is to be updated
		applicationRequest.setSid("{ApplicationSid}");
		applicationRequest.setFriendlyName("Welcome Application");
		applicationRequest.setVoiceUrl("http://telapi.com/ivr/welcome/call");
		applicationRequest.setSmsUrl("http://telapi.com/ivr/welcome/sms");
		
		try {
			Application application = conn.updateApplication(applicationRequest);
			System.out.println(application.getSid());
		} catch (TelapiException e) {
			e.printStackTrace();
		}
	}
}
