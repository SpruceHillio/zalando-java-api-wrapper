package io.sprucehill.zalando.api.nativecart.service;

import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.ByteArrayEntity;
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
	public Checkout read(String accessToken,String customerNumber, String checkout_id) throws Exception {
		HttpGet request = getRequest("/customer/"+customerNumber+"/checkouts/"+checkout_id);
		request.addHeader(HttpHeaders.AUTHORIZATION,"Bearer "+accessToken);
		request.addHeader(HttpHeaders.CONTENT_TYPE,"application/x.zalando.customer.checkout.create+json");
		return execute(request, new TypeReference<Checkout>() {});
	}

	@Override
	public Checkout create(String accessToken,String customerNumber, Checkout createcheckoutRequest) throws Exception {
		HttpPost request = postRequest("/customer/"+customerNumber+"/checkouts");
		request.addHeader(HttpHeaders.AUTHORIZATION,"Bearer "+accessToken);
		request.addHeader(HttpHeaders.CONTENT_TYPE,"application/x.zalando.customer.checkout+json");
		
		try {
			request.setEntity(new ByteArrayEntity(objectMapper.writeValueAsBytes(createcheckoutRequest)));
		}catch (Throwable t) {
			logger.warn(t.getMessage());
			throw new RuntimeException(t);
		}
		return execute(request, new TypeReference<Checkout>() {});
	}

	@Override
	public Checkout update(String accessToken,String customerNumber, String checkoutId,Checkout updateCheckoutRequest) throws Exception {
		HttpPut request = putRequest("/customer/"+customerNumber+"/checkouts/"+checkoutId);
		request.addHeader(HttpHeaders.AUTHORIZATION,"Bearer "+accessToken);
		request.addHeader(HttpHeaders.CONTENT_TYPE,"application/x.zalando.customer.checkout.update+json");
		
		try {
			request.setEntity(new ByteArrayEntity(objectMapper.writeValueAsBytes(updateCheckoutRequest)));
		}catch (Throwable t) {
			logger.warn(t.getMessage());
			throw new RuntimeException(t);
		}
		return execute(request, new TypeReference<Checkout>() {});
	}

}
