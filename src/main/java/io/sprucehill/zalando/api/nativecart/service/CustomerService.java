package io.sprucehill.zalando.api.nativecart.service;

import org.apache.http.client.methods.HttpGet;
import com.fasterxml.jackson.core.type.TypeReference;
import io.sprucehill.zalando.api.nativecart.model.GetCustomerResponse;

/**
 * 
 * @author dipteewarudkar
 *
 */
public class CustomerService extends AbstractService implements ICustomerService{

	@Override
	public GetCustomerResponse read(String customer_number) {
		HttpGet request = getRequest("/customers/" + customer_number);
		return execute(request, new TypeReference<GetCustomerResponse>() {});
	}
}
