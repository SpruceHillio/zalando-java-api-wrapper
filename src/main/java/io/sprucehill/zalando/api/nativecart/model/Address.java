package io.sprucehill.zalando.api.nativecart.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @author dipteewarudkar
 *
 */
public abstract class Address extends Base {

	@JsonProperty
	private String id;	
	@JsonProperty
	private String customer_number;
	@JsonProperty
	private String gender;
	@JsonProperty
	private String first_name;	
	@JsonProperty
	private String last_name;
	@JsonProperty
	private String street;
	@JsonProperty
	private String additional;
	@JsonProperty
	private String zip;
	@JsonProperty
	private String city;	
	@JsonProperty
	private String country_code;	
	@JsonProperty
	private Boolean pack_station;	
	@JsonProperty
	private Boolean default_billing;
	@JsonProperty
	private Boolean default_shipping;

	public Address(){}
	
	public Address(String id, String customer_number, String gender, String first_name, String last_name, String street,String additional, String zip, String city, String country_code, Boolean pack_station,Boolean default_billing, Boolean default_shipping) {
		this.id=id;
		this.customer_number=customer_number;
		this.gender=gender;
		this.first_name=first_name;
		this.last_name=last_name;
		this.street=street;
		this.additional=additional;
		this.city=city;
		this.country_code=country_code;
		this.pack_station=pack_station;
		this.default_billing=default_billing;
		this.default_shipping=default_shipping;
	}
	
	public String getId() {
		return id;
	}

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

	public String getCountry_code() {
		return country_code;
	}

	public Boolean getPack_station() {
		return pack_station;
	}

	public Boolean getDefault_billing() {
		return default_billing;
	}

	public Boolean getDefault_shipping() {
		return default_shipping;
	}
}
