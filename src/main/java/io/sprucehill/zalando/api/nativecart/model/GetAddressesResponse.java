package io.sprucehill.zalando.api.nativecart.model;

import java.util.List;

/**
 * 
 * @author dipteewarudkar
 *
 */
public class GetAddressesResponse extends Base {
	
	List<GetAddressesResponse> addresses;

	public List<GetAddressesResponse> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<GetAddressesResponse> addresses) {
		this.addresses = addresses;
	}

}
