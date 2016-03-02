package io.sprucehill.zalando.api.nativecart.service;

import java.io.UnsupportedEncodingException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import io.sprucehill.zalando.api.nativecart.model.CreateOrderRequest;
import io.sprucehill.zalando.api.nativecart.model.CreateOrderResponse;

/**
 * 
 * @author dipteewarudkar
 *
 */
public class OrderService extends AbstractService implements IOrderService{

	@Override
	public CreateOrderResponse create(String customer_number, CreateOrderRequest createOrderRequest) {
		HttpPost request = postRequest("/addresses");
		try {
			request.setEntity(new StringEntity(objectMapper.writeValueAsString(createOrderRequest)));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return execute(request, new TypeReference<CreateOrderResponse>() {});
	}

}
