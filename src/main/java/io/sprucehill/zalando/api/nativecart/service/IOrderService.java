package io.sprucehill.zalando.api.nativecart.service;

import io.sprucehill.zalando.api.nativecart.model.Order;

/**
 * 
 * @author dipteewarudkar
 *
 */
public interface IOrderService {
	
	/**
	 * 
	 * @param customerNumber The unique id of the customer
	 * @param createOrderRequest The order object to be created
	 * @return The newly create order object
	 */
	Order create(String customerNumber,Order createOrderRequest) throws Exception;
}
