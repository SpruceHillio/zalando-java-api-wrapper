package io.sprucehill.zalando.api.nativecart.service;

import io.sprucehill.zalando.api.nativecart.model.CreateCartRequest;
import io.sprucehill.zalando.api.nativecart.model.CreateCartResponse;
import io.sprucehill.zalando.api.nativecart.model.GetCartResponse;
import io.sprucehill.zalando.api.nativecart.model.UpdateCartItemsRequest;

/**
 * 
 * @author dipteewarudkar
 *
 */
public interface ICartService {
	
	/**
	 * 
	 * @param access_token access token for performing create cart operation
	 * @param createCartRequest The Cart object to be created
	 * @return Newly created cart object
	 */
	CreateCartResponse create(String access_token,CreateCartRequest createCartRequest);
	
	/**
	 * 
	 * @param access_token access token for performing create cart operation
	 * @param cart_id The ID of the cart to read
	 * @return The cart with the requested ID for the specified access_token
	 */
	GetCartResponse read(String access_token,String cart_id);
	
	/**
	 * 
	 * @param access_token
	 * @param cart_id
	 * @param updateCartRequest
	 * @return
	 */
	UpdateCartItemsRequest update(String access_token,String cart_id,UpdateCartItemsRequest updateCartRequest );

}
