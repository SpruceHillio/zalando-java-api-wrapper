package io.sprucehill.zalando.api.nativecart.service;

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
	 */
	TokenInfo read() throws Exception;
	
	/**
	 * 
	 * @param accessToken
	 * @return Token details for the given accessToken
	 * @throws Exception
	 */
	TokenInfo read(String accessToken) throws Exception;

	/**
	 * 
	 * @param authCode authorization code 
	 * @param redirectUrl The redirect url to receive callnack
	 * @return Token details for the given authorization code
	 * @throws Exception
	 */
	TokenInfo readFromAuthorizationCode(String authCode, String redirectUrl) throws Exception;
}
