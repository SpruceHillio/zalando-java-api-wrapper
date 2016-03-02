package io.sprucehill.zalando.api.nativecart.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.sprucehill.zalando.api.model.Base;

/**
 * 
 * @author dipteewarudkar
 *
 */
public class Address extends Base {

	@JsonProperty
	private String id;	
	
	@JsonProperty(value="customer_number")
	private String customerNumber;
	
	@JsonProperty
	private String gender;
	
	@JsonProperty(value="first_name")
	private String firstName;	
	
	@JsonProperty(value="last_name")
	private String lastName;
	
	@JsonProperty
	private String street;
	
	@JsonProperty
	private String additional;
	
	@JsonProperty
	private String zip;
	
	@JsonProperty
	private String city;
	
	@JsonProperty(value="country_code")
	private String countryCode;
	
	@JsonProperty(value="pack_station")
	private Boolean packStation;
	
	@JsonProperty(value="default_billing")
	private Boolean defaultBilling;
	
	@JsonProperty(value="default_shipping")
	private Boolean defaultShipping;

	public Address(){}
	
	public Address(String id, String customer_number, String gender, String first_name, String last_name, String street,String additional, String zip, String city, String country_code, Boolean pack_station,Boolean default_billing, Boolean default_shipping) {
		this.id=id;
		this.customerNumber=customer_number;
		this.gender=gender;
		this.firstName=first_name;
		this.lastName=last_name;
		this.street=street;
		this.additional=additional;
		this.city=city;
		this.countryCode=country_code;
		this.packStation=pack_station;
		this.defaultBilling=default_billing;
		this.defaultShipping=default_shipping;
	}
	
	public String getId() {
		return id;
	}

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

	public String getStreet() {
		return street;
	}

	public String getAdditional() {
		return additional;
	}

	public String getZip() {
		return zip;
	}

	public String getCity() {
		return city;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public Boolean getPackStation() {
		return packStation;
	}

	public Boolean getDefaultBilling() {
		return defaultBilling;
	}

	public Boolean getDefaultShipping() {
		return defaultShipping;
	}
}
