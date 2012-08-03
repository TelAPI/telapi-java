package com.telapi.api.domain.list;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

import com.telapi.api.domain.Account;
import com.telapi.api.domain.TelapiList;

public class AccountsList extends TelapiList<Account>{

	@Override
	@JsonProperty("accounts")
	protected void mapElements(List<Account> elements) {
		setElements(elements);
	}

}
