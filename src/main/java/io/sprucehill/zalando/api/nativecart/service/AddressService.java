package io.sprucehill.zalando.api.nativecart.service;

import java.io.UnsupportedEncodingException;
import javax.annotation.PostConstruct;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import io.sprucehill.zalando.api.nativecart.model.AddressCheckRequest;
import io.sprucehill.zalando.api.nativecart.model.AddressCheckResponse;
import io.sprucehill.zalando.api.nativecart.model.CreateAddressRequest;
import io.sprucehill.zalando.api.nativecart.model.CreateAddressResponse;
import io.sprucehill.zalando.api.nativecart.model.GetAddressResponse;
import io.sprucehill.zalando.api.nativecart.model.GetAddressesResponse;
import io.sprucehill.zalando.api.nativecart.model.UpdateAddressRequest;
import io.sprucehill.zalando.api.nativecart.model.UpdateAddressResponse;

/**
 * 
 * @author dipteewarudkar
 *
 */
public class AddressService extends AbstractService implements IAddressService{

	@PostConstruct
	@Override
	public void postConstruct() {
		super.postConstruct();
	}

	@Override
	public GetAddressesResponse read(String customer_number) {
		HttpGet request = getRequest("/customers/" + customer_number +"/addresses");
		return execute(request, new TypeReference<GetAddressesResponse>() {});
	}

	@Override
	public GetAddressResponse read(String customer_number, String address_id) {
		HttpGet request = getRequest("/customers/" + customer_number +"/addresses/"+address_id);
		return execute(request, new TypeReference<GetAddressResponse>() {});
	}

	@Override
	public UpdateAddressResponse update(String customer_number, String address_id, UpdateAddressRequest updateAddressRequest) {
		HttpPut request = putRequest("/customers/" + customer_number +"/addresses");
		
		try {
			request.setEntity(new StringEntity(objectMapper.writeValueAsString(updateAddressRequest)));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return execute(request, new TypeReference<UpdateAddressResponse>() {});
	}

	@Override
	public CreateAddressResponse create(String customer_number, CreateAddressRequest createAddressRequest) {
		HttpGet request = getRequest("/customers/" + customer_number+"/addresses");
		return execute(request, new TypeReference<CreateAddressResponse>() {});
	}

	@Override
	public AddressCheckResponse checkAddress(AddressCheckRequest checkAddressRequest) {
		HttpPost request = postRequest("/addresses");
		try {
			request.setEntity(new StringEntity(objectMapper.writeValueAsString(checkAddressRequest)));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return execute(request, new TypeReference<AddressCheckResponse>() {});
	}
}
