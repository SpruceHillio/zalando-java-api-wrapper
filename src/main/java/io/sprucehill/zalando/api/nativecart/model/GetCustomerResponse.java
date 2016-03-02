package io.sprucehill.zalando.api.nativecart.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @author dipteewarudkar
 *
 */
public class GetCustomerResponse extends Base {
	
	@JsonProperty
	private String customer_number;
	@JsonProperty
	private String gender;
	@JsonProperty
	private String first_name;
	@JsonProperty
	private String last_name;
	@JsonProperty
	private String email;
	
	public String getCustomer_number() {
		return customer_number;
	}
	public String getGender() {
		return gender;
	}
	public String getFirst_name() {
		return first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public String getEmail() {
		return email;
	}
}
