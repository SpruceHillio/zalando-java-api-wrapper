package io.sprucehill.zalando.api.nativecart.model;

import java.math.BigInteger;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.sprucehill.zalando.api.model.Base;

/**
 * 
 * @author dipteewarudkar
 *
 */
public class Money extends Base{
	
	@JsonProperty
	private BigInteger amount;
	
	@JsonProperty
	private String currency;
	
	public String getCurrency() {
		return currency;
	}
	
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
	public BigInteger getAmount() {
		return amount;
	}
	
	public void setAmount(BigInteger amount) {
		this.amount = amount;
	}
}
