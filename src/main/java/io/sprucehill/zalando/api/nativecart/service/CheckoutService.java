package io.sprucehill.zalando.api.nativecart.service;

import java.io.UnsupportedEncodingException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import io.sprucehill.zalando.api.nativecart.model.CreateCheckoutRequest;
import io.sprucehill.zalando.api.nativecart.model.CreateCheckoutResponse;
import io.sprucehill.zalando.api.nativecart.model.GetCheckoutResponse;
import io.sprucehill.zalando.api.nativecart.model.UpdateCheckoutRequest;
import io.sprucehill.zalando.api.nativecart.model.UpdateCheckoutRespone;

/**
 * 
 * @author dipteewarudkar
 *
 */
public class CheckoutService extends AbstractService implements ICheckoutService{

	@Override
	public GetCheckoutResponse read(String customer_number, String checkout_id) {
		HttpGet request = getRequest("/customer/"+customer_number+"/checkouts/"+checkout_id);
		return execute(request, new TypeReference<GetCheckoutResponse>() {});
	}

	@Override
	public CreateCheckoutResponse create(String customer_number, CreateCheckoutRequest createcheckoutRequest) {
		HttpPost request = postRequest("/customer/"+customer_number+"/checkouts");

		try {
			request.setEntity(new StringEntity(objectMapper.writeValueAsString(createcheckoutRequest)));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return execute(request, new TypeReference<CreateCheckoutResponse>() {});
	}

	@Override
	public UpdateCheckoutRespone update(String customer_number, String checkout_id,UpdateCheckoutRequest updateCheckoutRequest) {
		HttpPut request = putRequest("/customer/"+customer_number+"/checkouts/"+checkout_id);

		try {
			request.setEntity(new StringEntity(objectMapper.writeValueAsString(updateCheckoutRequest)));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return execute(request, new TypeReference<UpdateCheckoutRespone>() {});
	}

}
