package io.sprucehill.zalando.api.nativecart.service;

import io.sprucehill.zalando.api.nativecart.model.Checkout;

/**
 * 
 * @author dipteewarudkar
 *
 */
public interface ICheckoutService {
	
	/**
	 * 
	 * @param customerNumber The customer unique id
	 * @param checkoutId The ID of the checkout to read
	 * @return The checkout object with the requested ID for the specified customer
	 */
	Checkout read(String customerNumber,String checkoutId) throws Exception;
	
	/**
	 * 
	 * @param customerNumber The customer unique id
	 * @param CreatecheckoutRequest The checkout object to be created
	 * @return The newly created checkout object 
	 */
	Checkout create(String customerNumber,Checkout CreatecheckoutRequest) throws Exception;
	
	/**
	 * 
	 * @param customerNumber The customer unique id
	 * @param checkoutId The ID of the address to update
	 * @param updateCheckoutRequest The checkout object to be updated
	 * @return The updated checkout object
	 */
	Checkout update(String customerNumber,String checkoutId,Checkout updateCheckoutRequest) throws Exception;

}
