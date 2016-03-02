package io.sprucehill.zalando.api.nativecart.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.sprucehill.zalando.api.model.Base;

/**
 * 
 * @author dipteewarudkar
 *
 */
public class AddressCheckResponse extends Base {
	
	@JsonProperty
	private String status;
	
	@JsonProperty
	private Boolean blacklisted;
	
	@JsonProperty
	private Address address;
	
	@JsonProperty(value="normalized_address")
	private Address normalizedAddress;
	
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
	
	public Address getNormalizedAddress() {
		return normalizedAddress;
	}
	
	public void setNormalizedAddress(Address normalizedAddress) {
		this.normalizedAddress = normalizedAddress;
	}
}
