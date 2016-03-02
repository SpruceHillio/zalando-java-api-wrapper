package io.sprucehill.zalando.api.nativecart.model;

import java.util.List;

/**
 * 
 * @author dipteewarudkar
 *
 */
public class GetAddressesResponse extends Base {
	
	List<GetAddressResponse> addresses;

	public List<GetAddressResponse> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<GetAddressResponse> addresses) {
		this.addresses = addresses;
	}

}
