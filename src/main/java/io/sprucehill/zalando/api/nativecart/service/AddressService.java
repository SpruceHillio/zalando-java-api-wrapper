package io.sprucehill.zalando.api.nativecart.service;

import java.util.List;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import com.fasterxml.jackson.core.type.TypeReference;
import io.sprucehill.zalando.api.nativecart.model.Address;
import io.sprucehill.zalando.api.nativecart.model.AddressCheckResponse;
import io.sprucehill.zalando.api.service.AbstractService;

/**
 * 
 * @author dipteewarudkar
 *
 */
public class AddressService extends AbstractService implements IAddressService {

	@Override
	public List<Address> read(String accessToken,String customerNumber) throws Exception {
		HttpGet request = getRequest("/customers/" + customerNumber +"/addresses");
		request.setHeader("Authorization","Bearer "+accessToken);
		return execute(request, new TypeReference<List<Address>>() {});
	}

	@Override
	public Address read(String accessToken,String customerNumber, String addressId) throws Exception {
		HttpGet request = getRequest("/customers/" + customerNumber +"/addresses/"+addressId);
		request.setHeader("Authorization","Bearer "+accessToken);
		return execute(request, new TypeReference<Address>() {});
	}

	@Override
	public Address update(String accessToken,String customerNumber, String addressId, Address updateAddressRequest) throws Exception {
		HttpPut request = putRequest("/customers/" + customerNumber +"/addresses/"+addressId);
		
		try {
			request.setHeader("Authorization","Bearer "+accessToken);
			request.addHeader("Content-Type","application/x.zalando.customer.address.update+json");
			request.setEntity(new StringEntity(objectMapper.writeValueAsString(updateAddressRequest)));
		}catch(Throwable t) {
			logger.warn(t.getMessage());
			throw new RuntimeException(t);
		}
		return execute(request, new TypeReference<Address>() {});
	}

	@Override
	public Address create(String accessToken,String customerNumber, Address createAddressRequest) throws Exception {
		HttpGet request = getRequest("/customers/" + customerNumber+"/addresses");
		request.setHeader("Authorization","Bearer "+accessToken);
		request.addHeader("Content-Type","application/x.zalando.customer.address.create+json");
		return execute(request, new TypeReference<Address>() {});
	}

	@Override
	public AddressCheckResponse checkAddress(String accessToken,Address checkAddressRequest) throws Exception {
		HttpPost request = postRequest("/addresses");
		try {
			request.setHeader("Authorization","Bearer "+accessToken);
			request.addHeader("Content-Type","application/x.zalando.address-check.create+json");
			request.setEntity(new StringEntity(objectMapper.writeValueAsString(checkAddressRequest)));
		}catch(Throwable t) {
			logger.warn(t.getMessage());
			throw new RuntimeException(t);
		}
		return execute(request, new TypeReference<AddressCheckResponse>() {});
	}
}
