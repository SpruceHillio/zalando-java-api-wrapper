package io.sprucehill.zalando.api.nativecart.model;

/**
 * 
 * @author dipteewarudkar
 *
 */
public class UpdateCheckoutRequest extends Checkout{
	
	public UpdateCheckoutRequest(String billing_address_id,String shipping_address_id,Payment payment){
		super(null,null,null,billing_address_id,shipping_address_id,null,payment);
	}

}
