package io.sprucehill.zalando.api.nativecart.service;

import io.sprucehill.zalando.api.nativecart.model.CreateCheckoutRequest;
import io.sprucehill.zalando.api.nativecart.model.CreateCheckoutResponse;
import io.sprucehill.zalando.api.nativecart.model.GetCheckoutResponse;
import io.sprucehill.zalando.api.nativecart.model.UpdateCheckoutRequest;
import io.sprucehill.zalando.api.nativecart.model.UpdateCheckoutRespone;

/**
 * 
 * @author dipteewarudkar
 *
 */
public interface ICheckoutService {
	
	/**
	 * 
	 * @param customer_number The customer unique id
	 * @param checkout_id The ID of the checkout to read
	 * @return The checkout object with the requested ID for the specified customer
	 */
	GetCheckoutResponse read(String customer_number,String checkout_id);
	
	/**
	 * 
	 * @param customer_number The customer unique id
	 * @param CreatecheckoutRequest The checkout object to be created
	 * @return The newly created checkout object 
	 */
	CreateCheckoutResponse create(String customer_number,CreateCheckoutRequest CreatecheckoutRequest);
	
	/**
	 * 
	 * @param customer_number The customer unique id
	 * @param checkout_id The ID of the address to update
	 * @param updateCheckoutRequest The checkout object to be updated
	 * @return The updated checkout object
	 */
	UpdateCheckoutRespone update(String customer_number,String checkout_id,UpdateCheckoutRequest updateCheckoutRequest);

}
