package io.sprucehill.zalando.api.nativecart.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateOrderRequest extends Base{
	
	@JsonProperty
	private String checkout_id;

	public String getCheckout_id() {
		return checkout_id;
	}

	public void setCheckout_id(String checkout_id) {
		this.checkout_id = checkout_id;
	}

}
