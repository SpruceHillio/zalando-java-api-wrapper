package io.sprucehill.zalando.api.nativecart.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.sprucehill.zalando.api.model.Base;

/**
 * 
 * @author dipteewarudkar
 *
 */
public  class Checkout extends Base {

	@JsonProperty
	private String id;	

	@JsonProperty(value="customer_number")
	private String customerNumber;

	@JsonProperty(value="cart_id")
	private String cartId;

	@JsonProperty(value="billing_address_id")
	private String billingAddressId;	

	@JsonProperty(value="shipping_address_id")
	private String shippingAddressId;	

	@JsonProperty
	private Delivery delivery;

	@JsonProperty
	private Payment payment; 

	public Checkout() {}

	public Checkout(String id,String customerNumber,String cartId, String billingAddressId,String shippingAddressId,Delivery delivery,Payment payment){
		this.id=id;
		this.customerNumber=customerNumber;
		this.cartId=cartId;
		this.billingAddressId=billingAddressId;
		this.shippingAddressId=shippingAddressId;
		this.delivery=delivery;
		this.payment=payment;
	}

	public String getId() {
		return id;
	}

	public String getCustomerNumber() {
		return customerNumber;
	}

	public String getCartId() {
		return cartId;
	}

	public String getBillingAddressId() {
		return billingAddressId;
	}

	public String getShippingAddressId() {
		return shippingAddressId;
	}
	
	public void setBillingAddressId(String billingAddressId) {
		this.billingAddressId = billingAddressId;
	}

	public void setShippingAddressId(String shippingAddressId) {
		this.shippingAddressId = shippingAddressId;
	}

	public Delivery getDelivery() {
		return delivery;
	}

	public Payment getPayment() {
		return payment;
	}
}
