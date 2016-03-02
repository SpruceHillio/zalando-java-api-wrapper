package io.sprucehill.zalando.api.nativecart.service;

import io.sprucehill.zalando.api.nativecart.model.GetCustomerResponse;

/**
 * 
 * @author dipteewarudkar
 *
 */
public interface ICustomerService {
	
	/**
	 * 
	 * @param customer_number  The customer unique id
	 * @return Details of the customer with specified customer_number
	 */
	GetCustomerResponse  read(String customer_number);
}
