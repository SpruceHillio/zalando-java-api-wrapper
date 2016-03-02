package io.sprucehill.zalando.api.nativecart.service;

import io.sprucehill.zalando.api.nativecart.model.AddressCheckRequest;
import io.sprucehill.zalando.api.nativecart.model.AddressCheckResponse;
import io.sprucehill.zalando.api.nativecart.model.CreateAddressRequest;
import io.sprucehill.zalando.api.nativecart.model.CreateAddressResponse;
import io.sprucehill.zalando.api.nativecart.model.GetAddressResponse;
import io.sprucehill.zalando.api.nativecart.model.GetAddressesResponse;
import io.sprucehill.zalando.api.nativecart.model.UpdateAddressRequest;
import io.sprucehill.zalando.api.nativecart.model.UpdateAddressResponse;

/**
 * 
 * @author dipteewarudkar
 *
 */
public interface IAddressService {
	/**
	 * 
	 * @param checkAddressRequest The address object to be checked
	 * @return The address object with normalized address
	 */
	AddressCheckResponse checkAddress(AddressCheckRequest checkAddressRequest);

	/**
	 * 
	 * @param customer_number The customer unique id
	 * @return The list of user addresses
	 */
	GetAddressesResponse read(String customer_number) ;

	/**
	 * 
	 * @param customer_number The customer unique id
	 * @param address_id  The ID of the address to read
	 * @return The address with the requested ID for the specified customer
	 */
	GetAddressResponse read(String customer_number,String address_id) ;

	/**
	 * 
	 * @param customer_number The customer unique id
	 * @param address_id The ID of the address to update
	 * @param request The address object to update
	 * @return The updated address object
	 */
	UpdateAddressResponse update(String customer_number,String address_id,UpdateAddressRequest request);

	/**
	 * 	
	 * @param customer_number The customer unique id
	 * @param createAddressRequest The address object to create
	 * @return Newly created address object
	 */
	CreateAddressResponse create(String customer_number,CreateAddressRequest createAddressRequest);
}
