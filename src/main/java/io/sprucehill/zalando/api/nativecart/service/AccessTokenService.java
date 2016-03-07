package io.sprucehill.zalando.api.nativecart.service;

import org.apache.http.client.methods.HttpGet;
import com.fasterxml.jackson.core.type.TypeReference;
import io.sprucehill.zalando.api.service.AbstractService;

/**
 * 
 * @author dipteewarudkar
 *
 */
public class AccessTokenService extends AbstractService implements IAccessTokenService {

	@Override
	public String read() throws Exception {
		HttpGet request = getRequest("https://token.services.auth.zalando.com/oauth2/access_token?realm=/external-services");
		return execute(request, new TypeReference<String>() {});
	}
}
