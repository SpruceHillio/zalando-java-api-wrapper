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
	 * @param customerNumber  The customer unique id
	 * @return Details of the customer with specified customer_number
	 */
	Customer read(String accessToken,String customerNumber) throws Exception;
}
