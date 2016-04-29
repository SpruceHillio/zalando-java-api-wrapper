package io.sprucehill.zalando.api.nativecart.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.sprucehill.zalando.api.model.Base;

/**
 * 
 * @author dipteewarudkar
 *
 */
public class Customer extends Base {
	
	@JsonProperty(value="customer_number")
	private String customerNumber;
	
	@JsonProperty
	private String gender;
	
	@JsonProperty(value="first_name")
	private String firstName;
	
	@JsonProperty(value="last_name")
	private String lastName;
	
	@JsonProperty
	private String email;
	
	public String getCustomerNumber() {
		return customerNumber;
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
