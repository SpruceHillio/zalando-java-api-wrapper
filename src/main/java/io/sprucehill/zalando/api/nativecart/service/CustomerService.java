package io.sprucehill.zalando.api.nativecart.service;

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
	public Customer read(String customerNumber)  throws Exception {
		HttpGet request = getRequest("/customers/" + customerNumber);
		return execute(request, new TypeReference<Customer>() {});
	}
}
