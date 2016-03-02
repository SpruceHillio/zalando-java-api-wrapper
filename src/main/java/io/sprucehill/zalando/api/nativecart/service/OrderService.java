package io.sprucehill.zalando.api.nativecart.service;

import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import com.fasterxml.jackson.core.type.TypeReference;
import io.sprucehill.zalando.api.nativecart.model.CreateOrderRequest;
import io.sprucehill.zalando.api.nativecart.model.Order;

/**
 * 
 * @author dipteewarudkar
 *
 */
public class OrderService extends AbstractService implements IOrderService {

	@Override
	public Order create(String customerNumber, CreateOrderRequest createOrderRequest) {
		HttpPost request = postRequest("/customer/" + customerNumber +"/orders");
		try {
			request.setEntity(new StringEntity(objectMapper.writeValueAsString(createOrderRequest)));
		}catch(Throwable t) {
			logger.warn(t.getMessage());
			throw new RuntimeException(t);
		}
		return execute(request, new TypeReference<Order>() {});
	}
}
