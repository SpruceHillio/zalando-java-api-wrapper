package io.sprucehill.zalando.api.nativecart.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpHeaders;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicNameValuePair;

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
		HttpPost request = postRequest("/access_token");
		request.setHeader(HttpHeaders.CONTENT_TYPE,"application/x-www-form-urlencoded");
		
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("realm","%2Fcustomers"));
		params.add(new BasicNameValuePair("grant_type","client_credentials"));
		params.add(new BasicNameValuePair("client_id",clientId));
		params.add(new BasicNameValuePair("client_secret",clientCredential));
		
		request.setEntity(new UrlEncodedFormEntity(params));
		
		return execute(request, new TypeReference<TokenInfo>() {});
	}
	
	@Override
	public TokenInfo readFromAuthorizationCode(String authCode,String redirectUrl) throws Exception {
		HttpPost request = postRequest("/access_token?realm=%2Fcustomers&grant_type=authorization_code&client_id="+clientId+"&client_secret="+clientCredential+"&code="+authCode+"&redirect_uri="+redirectUrl);
		request.setHeader(HttpHeaders.CONTENT_TYPE,"application/x-www-form-urlencoded");
		
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("realm","%2Fcustomers"));
		params.add(new BasicNameValuePair("grant_type","authorization_code"));
		params.add(new BasicNameValuePair("client_id",clientId));
		params.add(new BasicNameValuePair("client_secret",clientCredential));
		
		request.setEntity(new UrlEncodedFormEntity(params));
		
		return execute(request, new TypeReference<TokenInfo>() {});
	}
	
	@Override
	public TokenInfo read(String accessToken) throws Exception {
		HttpGet request = getRequest("/tokeninfo?access_token="+accessToken);
		return execute(request, new TypeReference<TokenInfo>() {});
	}
}
