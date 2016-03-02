package io.sprucehill.zalando.api.nativecart.service;

import java.io.UnsupportedEncodingException;

import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import io.sprucehill.zalando.api.nativecart.model.CreateCartRequest;
import io.sprucehill.zalando.api.nativecart.model.CreateCartResponse;
import io.sprucehill.zalando.api.nativecart.model.GetCartResponse;
import io.sprucehill.zalando.api.nativecart.model.UpdateCartItemsRequest;

/**
 * 
 * @author dipteewarudkar
 *
 */
public class CartService extends AbstractService implements ICartService{

	@Override
	public CreateCartResponse create(String access_token, CreateCartRequest createCartRequest) {
		HttpPost request = postRequest("/carts");

		try {
			request.addHeader(HttpHeaders.AUTHORIZATION,"Bearer "+access_token);
			request.setEntity(new StringEntity(objectMapper.writeValueAsString(createCartRequest)));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return execute(request, new TypeReference<CreateCartResponse>() {});
	}


	@Override
	public GetCartResponse read(String access_token, String cart_id) {
		HttpGet request = getRequest("/carts/" + cart_id);
		request.addHeader(HttpHeaders.AUTHORIZATION,"Bearer "+access_token);
		return execute(request, new TypeReference<GetCartResponse>() {});
	}


	@Override
	public UpdateCartItemsRequest update(String access_token, String cart_id,UpdateCartItemsRequest updateCartRequest) {
		HttpPut request = putRequest("/carts/"+cart_id);

		try {
			request.addHeader(HttpHeaders.AUTHORIZATION,"Bearer "+access_token);
			request.setEntity(new StringEntity(objectMapper.writeValueAsString(updateCartRequest)));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return execute(request, new TypeReference<UpdateCartItemsRequest>() {});
	}
}
