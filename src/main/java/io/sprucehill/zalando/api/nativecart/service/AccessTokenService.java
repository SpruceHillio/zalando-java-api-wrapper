package io.sprucehill.zalando.api.nativecart.service;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;

import com.fasterxml.jackson.core.type.TypeReference;

import io.sprucehill.zalando.api.nativecart.model.TokenInfo;
import io.sprucehill.zalando.api.service.AbstractService;

/**
 * 
 * @author dipteewarudkar
 *
 */
public class AccessTokenService extends AbstractService implements IAccessTokenService {

	@Override
	public TokenInfo read() throws Exception {
		HttpPost request = postRequest("/access_token?realm=%2Fcustomers&grant_type=client_credentials&client_id="+clientId+"&client_secret="+clientCredential);
		request.setHeader("Content-Type","application/x-www-form-urlencoded");
		return execute(request, new TypeReference<TokenInfo>() {});
	}
	
	@Override
	public TokenInfo readFromAuthorizationCode(String authCode,String redirectUrl) throws Exception {
		HttpPost request = postRequest("/access_token?realm=%2Fcustomers&grant_type=authorization_code&client_id="+clientId+"&client_secret="+clientCredential+"&code="+authCode+"&redirect_uri="+redirectUrl);
		request.setHeader("Content-Type","application/x-www-form-urlencoded");
		return execute(request, new TypeReference<TokenInfo>() {});
	}
	
	@Override
	public TokenInfo read(String accessToken) throws Exception {
		HttpGet request = getRequest("/tokeninfo?access_token="+accessToken);
		return execute(request, new TypeReference<TokenInfo>() {});
	}
}
