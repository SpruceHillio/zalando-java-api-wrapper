package io.sprucehill.zalando.api.nativecart.service;

import io.sprucehill.zalando.api.exception.NotFoundException;
import io.sprucehill.zalando.api.nativecart.model.TokenInfo;

/**
 * 
 * @author dipteewarudkar
 *
 */
public interface IAccessTokenService {
	
	/**
	 *
	 * @return Access token 
	 * @throws Exception Any Exception that is thrown while doing the operation
	 */
	TokenInfo read() throws Exception;
	
	/**
	 * 
	 * @param accessToken The access token for authorization
	 * @return Token details for the given accessToken
	 * @throws Exception Any Exception that is thrown while doing the operation
	 */
	TokenInfo read(String accessToken) throws Exception;

	/**
	 * 
	 * @param authCode authorization code 
	 * @param redirectUrl The redirect url to receive callnack
	 * @return Token details for the given authorization code
	 * @throws Exception Any Exception that is thrown while doing the operation
	 */
	TokenInfo readFromAuthorizationCode(String authCode, String redirectUrl) throws Exception;
}
