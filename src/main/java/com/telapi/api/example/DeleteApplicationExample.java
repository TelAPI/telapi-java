package com.telapi.api.example;

import com.telapi.api.TelapiConnector;
import com.telapi.api.configuration.BasicTelapiConfiguration;
import com.telapi.api.domain.Application;
import com.telapi.api.exceptions.TelapiException;

public class DeleteApplicationExample {

	public static void main(String[] args) {
		BasicTelapiConfiguration conf = new BasicTelapiConfiguration();
		conf.setSid("{AccountSid}");
		conf.setAuthToken("{AuthToken}");
		TelapiConnector conn = new TelapiConnector(conf);
		
		try {
			Application application = conn.deleteApplication("{ApplicationSid}");
			System.out.println(application.getSid());
		} catch (TelapiException e) {
			e.printStackTrace();
		}
	}
}
