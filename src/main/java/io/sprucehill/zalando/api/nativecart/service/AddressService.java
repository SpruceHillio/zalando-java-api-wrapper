package io.sprucehill.zalando.api.nativecart.service;

import java.util.List;

import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.ByteArrayEntity;
import com.fasterxml.jackson.core.type.TypeReference;
import io.sprucehill.zalando.api.nativecart.model.Address;
import io.sprucehill.zalando.api.nativecart.model.AddressCheckRequest;
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
		request.setHeader(HttpHeaders.AUTHORIZATION,"Bearer "+accessToken);
		return execute(request, new TypeReference<List<Address>>() {});
	}

	@Override
	public Address read(String accessToken,String customerNumber, String addressId) throws Exception {
		HttpGet request = getRequest("/customers/" + customerNumber +"/addresses/"+addressId);
		request.setHeader(HttpHeaders.AUTHORIZATION,"Bearer "+accessToken);
		return execute(request, new TypeReference<Address>() {});
	}

	@Override
	public Address update(String accessToken,String customerNumber, String addressId, Address updateAddressRequest) throws Exception {
		HttpPut request = putRequest("/customers/" + customerNumber +"/addresses/"+addressId);
		
		try {
			request.setHeader(HttpHeaders.AUTHORIZATION,"Bearer "+accessToken);
			request.addHeader(HttpHeaders.CONTENT_TYPE,"application/x.zalando.customer.address.update+json");
			request.setEntity(new ByteArrayEntity(objectMapper.writeValueAsBytes(updateAddressRequest)));
		}catch(Throwable t) {
			logger.warn(t.getMessage());
			throw new RuntimeException(t);
		}
		return execute(request, new TypeReference<Address>() {});
	}

	@Override
	public Address create(String accessToken,String customerNumber, Address createAddressRequest) throws Exception {
		HttpPost request = postRequest("/customers/" + customerNumber+"/addresses");
		request.setHeader(HttpHeaders.AUTHORIZATION,"Bearer "+accessToken);
		request.addHeader(HttpHeaders.CONTENT_TYPE,"application/x.zalando.customer.address.create+json");
		request.setEntity(new ByteArrayEntity(objectMapper.writeValueAsBytes(createAddressRequest)));
		return execute(request, new TypeReference<Address>() {});
	}

	@Override
	public AddressCheckResponse checkAddress(String accessToken,AddressCheckRequest checkAddressRequest) throws Exception {
		HttpPost request = postRequest("/address-checks");
		try {
			request.setHeader(HttpHeaders.AUTHORIZATION,"Bearer "+accessToken);
			request.addHeader(HttpHeaders.CONTENT_TYPE,"application/x.zalando.address-check.create+json");
			request.setEntity(new ByteArrayEntity(objectMapper.writeValueAsBytes(checkAddressRequest)));
		}catch(Throwable t) {
			logger.warn(t.getMessage());
			throw new RuntimeException(t);
		}
		return execute(request, new TypeReference<AddressCheckResponse>() {});
	}
}
