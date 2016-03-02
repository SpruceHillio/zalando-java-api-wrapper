package io.sprucehill.zalando.api.nativecart.service;

import io.sprucehill.zalando.api.nativecart.model.Cart;

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
	Cart create(String accessToken,Cart createCartRequest);
	
	/**
	 * 
	 * @param access_token access token for performing create cart operation
	 * @param cart_id The ID of the cart to read
	 * @return The cart with the requested ID for the specified access_token
	 */
	Cart read(String accessToken,String cartId);
	
	/**
	 * 
	 * @param access_token
	 * @param cart_id
	 * @param updateCartRequest
	 * @return
	 */
	Cart update(String accessToken,String cartId,Cart updateCartRequest);
}
