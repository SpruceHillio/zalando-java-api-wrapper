package io.sprucehill.zalando.api.nativecart.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.sprucehill.zalando.api.model.Base;

/**
 * 
 * @author dipteewarudkar
 *
 */
public class Customer extends Base {
	
	@JsonProperty
	private String customer_number;
	
	@JsonProperty
	private String gender;
	
	@JsonProperty(value="first_name")
	private String firstName;
	
	@JsonProperty(value="last_name")
	private String lastName;
	
	@JsonProperty
	private String email;
	
	public String getCustomer_number() {
		return customer_number;
	}
	
	public String getGender() {
		return gender;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getEmail() {
		return email;
	}
}
