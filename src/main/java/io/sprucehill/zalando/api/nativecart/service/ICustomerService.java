package io.sprucehill.zalando.api.nativecart.service;

import io.sprucehill.zalando.api.nativecart.model.Customer;

/**
 * 
 * @author dipteewarudkar
 *
 */
public interface ICustomerService {
	
	/**
	 * 
	 * @param accessToken The access token for authorization
	 * @param customerNumber  The customer unique id
	 * @return Details of the customer with specified customer_number
	 * @throws Exception Any Exception that is thrown while doing the operation
	 */
	Customer read(String accessToken,String customerNumber) throws Exception;
}
