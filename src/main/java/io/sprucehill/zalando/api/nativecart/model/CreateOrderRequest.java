package io.sprucehill.zalando.api.nativecart.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.sprucehill.zalando.api.model.Base;

/**
 * 
 * @author dipteewarudkar
 *
 */
public class CreateOrderRequest extends Base {
	
	@JsonProperty
	private String checkoutId;

	public String getCheckoutId() {
		return checkoutId;
	}
	
	public void setCheckoutId(String checkoutId) {
		this.checkoutId = checkoutId;
	}
}
