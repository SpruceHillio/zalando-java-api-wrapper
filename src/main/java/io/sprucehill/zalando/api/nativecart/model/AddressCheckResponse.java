package io.sprucehill.zalando.api.nativecart.model;

/**
 * 
 * @author dipteewarudkar
 *
 */
public class AddressCheckResponse extends Base {
	private String status;
	private Boolean blacklisted;
	Address address;
	Address normalized_address;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Boolean getBlacklisted() {
		return blacklisted;
	}
	public void setBlacklisted(Boolean blacklisted) {
		this.blacklisted = blacklisted;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Address getNormalized_address() {
		return normalized_address;
	}
	public void setNormalized_address(Address normalized_address) {
		this.normalized_address = normalized_address;
	}
}
