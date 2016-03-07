package io.sprucehill.zalando.api.nativecart.service;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import com.fasterxml.jackson.core.type.TypeReference;
import io.sprucehill.zalando.api.nativecart.model.Checkout;
import io.sprucehill.zalando.api.service.AbstractService;

/**
 * 
 * @author dipteewarudkar
 *
 */
public class CheckoutService extends AbstractService implements ICheckoutService {

	@Override
	public Checkout read(String customerNumber, String checkout_id) throws Exception {
		HttpGet request = getRequest("/customer/"+customerNumber+"/checkouts/"+checkout_id);
		return execute(request, new TypeReference<Checkout>() {});
	}

	@Override
	public Checkout create(String customerNumber, Checkout createcheckoutRequest) throws Exception {
		HttpPost request = postRequest("/customer/"+customerNumber+"/checkouts");

		try {
			request.setEntity(new StringEntity(objectMapper.writeValueAsString(createcheckoutRequest)));
		}catch (Throwable t) {
			logger.warn(t.getMessage());
			throw new RuntimeException(t);
		}
		return execute(request, new TypeReference<Checkout>() {});
	}

	@Override
	public Checkout update(String customerNumber, String checkoutId,Checkout updateCheckoutRequest) throws Exception {
		HttpPut request = putRequest("/customer/"+customerNumber+"/checkouts/"+checkoutId);

		try {
			request.setEntity(new StringEntity(objectMapper.writeValueAsString(updateCheckoutRequest)));
		}catch (Throwable t) {
			logger.warn(t.getMessage());
			throw new RuntimeException(t);
		}
		return execute(request, new TypeReference<Checkout>() {});
	}

}
