package com.telapi.api.example;

import com.telapi.api.TelapiConnector;
import com.telapi.api.configuration.BasicTelapiConfiguration;
import com.telapi.api.domain.Call;
import com.telapi.api.domain.list.CallList;
import com.telapi.api.exceptions.TelapiException;

public class ListCallsExample {

	public static void main(String[] args) {
		BasicTelapiConfiguration conf = new BasicTelapiConfiguration();
		conf.setSid("{AccountSid}");
		conf.setAuthToken("{AuthToken}");
		TelapiConnector conn = new TelapiConnector(conf);
		
		try {
			CallList callList = conn.listCalls();
			for(Call call : callList) {
				System.out.println(call.getSid());
			}
		} catch (TelapiException e) {
			e.printStackTrace();
		}
	}
}
