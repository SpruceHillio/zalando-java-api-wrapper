package io.sprucehill.zalando.api.nativecart.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.sprucehill.zalando.api.model.Base;

/**
 * 
 * @author dipteewarudkar
 *
 */
public class TokenInfo extends Base{

	@JsonProperty(value="token_type")
	public  String tokenType;

	@JsonProperty(value="access_token")
	public  String accessToken;

	@JsonProperty(value="uid")
	public  String customerNumber;

	public String getTokenType() {
		return tokenType;
	}

	public void setTokenType(String tokenType) {
		this.tokenType = tokenType;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(String customerNumber) {
		this.customerNumber = customerNumber;
	}
}

