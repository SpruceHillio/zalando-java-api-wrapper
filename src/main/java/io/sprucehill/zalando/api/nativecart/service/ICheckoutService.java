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
	 * @param accessToken The access token for authorization 
	 * @param customerNumber The customer unique id
	 * @param checkoutId The ID of the checkout to read
	 * @return The checkout object with the requested ID for the specified customer
	 * @throws Exception Any Exception that is thrown while doing the operation
	 */
	Checkout read(String accessToken,String customerNumber,String checkoutId) throws Exception;
	
	/**
	 * 
	 * @param accessToken The access token for authorization 
	 * @param customerNumber The customer unique id
	 * @param CreatecheckoutRequest The checkout object to be created
	 * @return The newly created checkout object 
	 * @throws Exception Any Exception that is thrown while doing the operation
	 */
	Checkout create(String accessToken,String customerNumber,Checkout CreatecheckoutRequest) throws Exception;
	
	/**
	 * 
	 * @param accessToken The access token for authorization
	 * @param customerNumber The customer unique id
	 * @param checkoutId The ID of the address to update
	 * @param updateCheckoutRequest The checkout object to be updated
	 * @return The updated checkout object
	 * @throws Exception Any Exception that is thrown while doing the operation
	 */
	Checkout update(String accessToken,String customerNumber,String checkoutId,Checkout updateCheckoutRequest) throws Exception;
}
