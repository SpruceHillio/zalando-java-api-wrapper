package io.sprucehill.zalando.api.nativecart.service;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import com.fasterxml.jackson.core.type.TypeReference;
import io.sprucehill.zalando.api.nativecart.model.Address;
import io.sprucehill.zalando.api.nativecart.model.AddressCheckResponse;

/**
 * 
 * @author dipteewarudkar
 *
 */
public class AddressService extends AbstractService implements IAddressService {

	@Override
	public Address read(String customerNumber) {
		HttpGet request = getRequest("/customers/" + customerNumber +"/addresses");
		return execute(request, new TypeReference<Address>() {});
	}

	@Override
	public Address read(String customerNumber, String addressId) {
		HttpGet request = getRequest("/customers/" + customerNumber +"/addresses/"+addressId);
		return execute(request, new TypeReference<Address>() {});
	}

	@Override
	public Address update(String customerNumber, String addressId, Address updateAddressRequest) {
		HttpPut request = putRequest("/customers/" + customerNumber +"/addresses/"+addressId);
		
		try {
			request.setEntity(new StringEntity(objectMapper.writeValueAsString(updateAddressRequest)));
		}catch(Throwable t) {
			logger.warn(t.getMessage());
			throw new RuntimeException(t);
		}
		return execute(request, new TypeReference<Address>() {});
	}

	@Override
	public Address create(String customerNumber, Address createAddressRequest) {
		HttpGet request = getRequest("/customers/" + customerNumber+"/addresses");
		return execute(request, new TypeReference<Address>() {});
	}

	@Override
	public AddressCheckResponse checkAddress(Address checkAddressRequest) {
		HttpPost request = postRequest("/addresses");
		try {
			request.setEntity(new StringEntity(objectMapper.writeValueAsString(checkAddressRequest)));
		}catch(Throwable t) {
			logger.warn(t.getMessage());
			throw new RuntimeException(t);
		}
		return execute(request, new TypeReference<AddressCheckResponse>() {});
	}
}
