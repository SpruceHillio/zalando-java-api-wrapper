package io.sprucehill.zalando.api.nativecart.service;

import io.sprucehill.zalando.api.nativecart.model.CreateOrderRequest;
import io.sprucehill.zalando.api.nativecart.model.CreateOrderResponse;

/**
 * 
 * @author dipteewarudkar
 *
 */
public interface IOrderService {
	
	/**
	 * 
	 * @param customer_number The unique id of the customer
	 * @param createOrderRequest The order object to be created
	 * @return The newly create order object
	 */
	CreateOrderResponse create(String customer_number,CreateOrderRequest createOrderRequest);

}
