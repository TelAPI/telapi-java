package com.telapi.api.example;

import com.telapi.api.TelapiConnector;
import com.telapi.api.configuration.BasicTelapiConfiguration;
import com.telapi.api.domain.Application;
import com.telapi.api.domain.list.ApplicationList;
import com.telapi.api.exceptions.TelapiException;

public class ListApplicationsExample {

	public static void main(String[] args) {
		BasicTelapiConfiguration conf = new BasicTelapiConfiguration();
		conf.setSid("{AccountSid}");
		conf.setAuthToken("{AuthToken}");
		TelapiConnector conn = new TelapiConnector(conf);
		
		try {
			ApplicationList applicationList = conn.listApplications();
			for(Application application : applicationList) {
				System.out.println(application.getSid());
			}
		} catch (TelapiException e) {
			e.printStackTrace();
		}
	}
}
