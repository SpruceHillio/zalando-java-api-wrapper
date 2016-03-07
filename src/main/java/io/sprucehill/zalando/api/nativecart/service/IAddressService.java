package io.sprucehill.zalando.api.nativecart.service;

import java.util.List;
import io.sprucehill.zalando.api.nativecart.model.Address;
import io.sprucehill.zalando.api.nativecart.model.AddressCheckResponse;

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
	AddressCheckResponse checkAddress(Address checkAddressRequest) throws Exception;

	/**
	 * 
	 * @param customerNumber The customer unique id
	 * @return The list of user addresses
	 */
	List<Address> read(String customerNumber) throws Exception ;

	/**
	 * 
	 * @param customerNumber The customer unique id
	 * @param addressId  The ID of the address to read
	 * @return The address with the requested ID for the specified customer
	 */
	Address read(String customerNumber,String addressId) throws Exception;

	/**
	 * 
	 * @param customerNumber The customer unique id
	 * @param addressId The ID of the address to update
	 * @param request The address object to update
	 * @return The updated address object
	 */
	Address update(String customerNumber,String addressId,Address request) throws Exception;

	/**
	 * 	
	 * @param customerNumber The customer unique id
	 * @param createAddressRequest The address object to create
	 * @return Newly created address object
	 */
	Address create(String customerNumber,Address createAddressRequest) throws Exception;
}
