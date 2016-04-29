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
	
	public enum Currency {
		EUR,DKK,GBP,CHF,NOK,SEK,PLN
    }
	
	@JsonProperty
	private BigInteger amount;
	
	@JsonProperty
	private Currency currency;
	
	public Currency getCurrency() {
		return currency;
	}
	
	public void setCurrency(Currency currency) {
		this.currency = currency;
	}
	
	public BigInteger getAmount() {
		return amount;
	}
	
	public void setAmount(BigInteger amount) {
		this.amount = amount;
	}
}
