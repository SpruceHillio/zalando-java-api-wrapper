package io.sprucehill.zalando.api.nativecart.service;

import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import com.fasterxml.jackson.core.type.TypeReference;
import io.sprucehill.zalando.api.nativecart.model.Cart;
import io.sprucehill.zalando.api.service.AbstractService;

/**
 * 
 * @author dipteewarudkar
 *
 */
public class CartService extends AbstractService implements ICartService {

	@Override
	public Cart create(String accessToken, Cart createCartRequest) throws Exception {
		HttpPost request = postRequest("/carts");

		try {
			
			request.addHeader(HttpHeaders.AUTHORIZATION,"Bearer "+accessToken);
			request.addHeader("Content-Type","application/x.zalando.cart.create+json");
			request.setEntity(new StringEntity(objectMapper.writeValueAsString(createCartRequest)));
		}catch(Throwable t) {
			logger.warn(t.getMessage());
			throw new RuntimeException(t);
		}
		return execute(request, new TypeReference<Cart>() {});
	}

	@Override
	public Cart read(String access_token, String cart_id) throws Exception {
		HttpGet request = getRequest("/carts/" + cart_id);
		request.addHeader("Content-Type","application/x.zalando.cart+json");
		request.addHeader(HttpHeaders.AUTHORIZATION,"Bearer "+access_token);
		return execute(request, new TypeReference<Cart>() {});
	}

	@Override
	public Cart update(String access_token, String cart_id,Cart updateCartRequest) throws Exception {
		HttpPut request = putRequest("/carts/"+cart_id+"/items");

		try {
			request.addHeader(HttpHeaders.AUTHORIZATION,"Bearer "+access_token);
			request.addHeader("Content-Type","application/x.zalando.cart.items.update+json");
			request.setEntity(new StringEntity(objectMapper.writeValueAsString(updateCartRequest.getItems())));
			return execute(request, new TypeReference<Cart>() {});
			
		}catch(Throwable t) {
			logger.warn(t.getMessage());
			throw new RuntimeException(t);
		}
	}
}
