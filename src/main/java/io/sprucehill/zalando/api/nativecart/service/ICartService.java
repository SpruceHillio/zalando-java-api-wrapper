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
	 * @param accessToken access token for performing create cart operation
	 * @param createCartRequest The Cart object to be created
	 * @return Newly created cart object
	 */
	Cart create(String accessToken,Cart createCartRequest);
	
	/**
	 * 
	 * @param accessToken access token for performing create cart operation
	 * @param cartId The ID of the cart to read
	 * @return The cart with the requested ID for the specified access_token
	 */
	Cart read(String accessToken,String cartId);
	
	/**
	 * 
	 * @param accessToken
	 * @param cartId
	 * @param updateCartRequest
	 * @return
	 */
	Cart update(String accessToken,String cartId,Cart updateCartRequest);
}
