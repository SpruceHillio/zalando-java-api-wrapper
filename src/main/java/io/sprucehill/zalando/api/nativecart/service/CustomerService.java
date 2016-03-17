package io.sprucehill.zalando.api.nativecart.service;

import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.HttpGet;
import com.fasterxml.jackson.core.type.TypeReference;
import io.sprucehill.zalando.api.nativecart.model.Customer;
import io.sprucehill.zalando.api.service.AbstractService;

/**
 * 
 * @author dipteewarudkar
 *
 */
public class CustomerService extends AbstractService implements ICustomerService {

	@Override
	public Customer read(String accessToken ,String customerNumber)  throws Exception {
		HttpGet request = getRequest("/customers/" + customerNumber);
		request.addHeader(HttpHeaders.AUTHORIZATION,"Bearer "+accessToken);
		return execute(request, new TypeReference<Customer>() {});
	}
}
