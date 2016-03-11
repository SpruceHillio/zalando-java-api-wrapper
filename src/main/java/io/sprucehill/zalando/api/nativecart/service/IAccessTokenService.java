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
	 * @return access token
	 */
	String read() throws Exception;
	
	/**
	 * 
	 * @param accessToken
	 * @return
	 * @throws Exception
	 */
	TokenInfo read(String accessToken) throws Exception;
}
