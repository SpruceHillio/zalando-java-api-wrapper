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
	AddressCheckResponse checkAddress(AddressCheckRequest checkAddressRequest);

	/**
	 * 
	 * @param customer_number
	 * @return
	 */
	GetAddressesResponse read(String customer_number) ;

	/**
	 * 
	 * @param customer_number
	 * @param address_id
	 * @return
	 */
	GetAddressResponse read(String customer_number,String address_id) ;

	/**
	 * 
	 * @param customer_number
	 * @param address_id
	 * @param request
	 * @return
	 */
	UpdateAddressResponse update(String customer_number,String address_id,UpdateAddressRequest request);

	/**
	 * 	
	 * @param customer_number
	 * @param createAddressRequest
	 * @return
	 */
	CreateAddressResponse create(String customer_number,CreateAddressRequest createAddressRequest);
}
