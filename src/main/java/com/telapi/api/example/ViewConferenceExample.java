package com.telapi.api.example;

import com.telapi.api.TelapiConnector;
import com.telapi.api.configuration.BasicTelapiConfiguration;
import com.telapi.api.domain.Conference;
import com.telapi.api.exceptions.TelapiException;

public class ViewConferenceExample {

	public static void main(String[] args) {
		BasicTelapiConfiguration conf = new BasicTelapiConfiguration();
		conf.setSid("{AccountSid}");
		conf.setAuthToken("{AuthToken}");
		TelapiConnector conn = new TelapiConnector(conf);
		
		try {
			Conference conference = conn.viewConference("{ConferenceSid}");
			System.out.println(conference.getSid());
		} catch (TelapiException e) {
			e.printStackTrace();
		}
	}
}
