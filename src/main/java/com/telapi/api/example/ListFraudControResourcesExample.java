package com.telapi.api.example;

import com.telapi.api.TelapiConnector;
import com.telapi.api.configuration.BasicTelapiConfiguration;
import com.telapi.api.domain.list.FraudList;
import com.telapi.api.exceptions.TelapiException;

public class ListFraudControResourcesExample {

	public static void main(String[] args) {
		BasicTelapiConfiguration conf = new BasicTelapiConfiguration();
		conf.setSid("{AccountSid}");
		conf.setAuthToken("{AuthToken}");
		TelapiConnector conn = new TelapiConnector(conf);
		
		try {
			FraudList fraudControlResources = conn.listFraudControlResources();
			System.out.println(fraudControlResources.getFrauds().getMaxOutboundRate());
			
		} catch (TelapiException e) {
			e.printStackTrace();
		}
	}
}
