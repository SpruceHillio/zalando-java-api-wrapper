package io.sprucehill.zalando.api.nativecart.model;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @author dipteewarudkar
 *
 */
public abstract class Checkout extends Base{
	@JsonProperty
	private String id;	
	@JsonProperty
	private String customer_number;
	@JsonProperty
	private String cart_id;
	@JsonProperty
	private String billing_address_id;	
	@JsonProperty
	private String shipping_address_id;	
	@JsonProperty
	private Delivery delivery;
	@JsonProperty
	private Payment payment; 

	public Checkout(){}

	public Checkout(String id,String customer_number,String cart_id, String billing_address_id,String shipping_address_id,Delivery delivery,Payment payment){
		this.id=id;
		this.customer_number=customer_number;
		this.cart_id=cart_id;
		this.billing_address_id=billing_address_id;
		this.shipping_address_id=shipping_address_id;
		this.delivery=delivery;
		this.payment=payment;
	}


	
	public String getId() {
		return id;
	}

	public String getCustomer_number() {
		return customer_number;
	}

	public String getCart_id() {
		return cart_id;
	}

	public String getBilling_address_id() {
		return billing_address_id;
	}

	public String getShipping_address_id() {
		return shipping_address_id;
	}

	public Delivery getDelivery() {
		return delivery;
	}

	public Payment getPayment() {
		return payment;
	}
}
