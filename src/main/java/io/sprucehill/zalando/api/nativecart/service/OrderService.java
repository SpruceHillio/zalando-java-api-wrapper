package io.sprucehill.zalando.api.nativecart.service;

import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import com.fasterxml.jackson.core.type.TypeReference;
import io.sprucehill.zalando.api.nativecart.model.Order;
import io.sprucehill.zalando.api.service.AbstractService;

/**
 * 
 * @author dipteewarudkar
 *
 */
public class OrderService extends AbstractService implements IOrderService {

	@Override
	public Order create(String customerNumber, Order createOrderRequest) throws Exception {
		HttpPost request = postRequest("/customer/" + customerNumber +"/orders");
		try {
			request.setEntity(new ByteArrayEntity(objectMapper.writeValueAsBytes(createOrderRequest)));
		}catch(Throwable t) {
			logger.warn(t.getMessage());
			throw new RuntimeException(t);
		}
		return execute(request, new TypeReference<Order>() {});
	}
}
