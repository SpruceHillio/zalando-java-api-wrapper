package io.sprucehill.zalando.api.nativecart.model;

/**
 * 
 * @author dipteewarudkar
 *
 */
public class CreateCheckoutRequest extends Checkout {
	public CreateCheckoutRequest(String cart_id,String billing_address_id,String shipping_address_id,Payment payment){
		super(null,null,cart_id,billing_address_id,shipping_address_id,null,payment);
	}

}

