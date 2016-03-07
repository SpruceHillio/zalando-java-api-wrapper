package io.sprucehill.zalando.api.nativecart.service;

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
}
