package io.sprucehill.zalando.api.nativecart.model;

/**
 * 
 * @author dipteewarudkar
 *
 */
public class CreateAddressRequest extends Address{

	public CreateAddressRequest(String gender,String first_name,String last_name,String street,String additional,String zip,String city,String country_code,Boolean pack_station,Boolean default_billing,Boolean default_shipping){
		super(null,null,gender,first_name,last_name,street,additional,zip,city,country_code,pack_station,default_billing,default_shipping);
	}
}