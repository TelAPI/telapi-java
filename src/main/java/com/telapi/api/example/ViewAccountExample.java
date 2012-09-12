package com.telapi.api.example;

import com.telapi.api.TelapiConnector;
import com.telapi.api.configuration.BasicTelapiConfiguration;
import com.telapi.api.domain.Account;
import com.telapi.api.exceptions.TelapiException;

public class ViewAccountExample {

	public static void main(String[] args) {
		BasicTelapiConfiguration conf = new BasicTelapiConfiguration();
		conf.setSid("{AccountSid}");
		conf.setAuthToken("{AuthToken}");
		TelapiConnector conn = new TelapiConnector(conf);
		
		try {
			Account account = conn.viewAccount("{AccountSid}");
			System.out.println(account.getSid());
		} catch (TelapiException e) {
			e.printStackTrace();
		}
	}
}
