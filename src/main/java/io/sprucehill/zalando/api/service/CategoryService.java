package io.sprucehill.zalando.api.service;

import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.HttpGet;
import com.fasterxml.jackson.core.type.TypeReference;

import io.sprucehill.zalando.api.exception.NotFoundException;
import io.sprucehill.zalando.api.model.Category;
import io.sprucehill.zalando.api.model.Domain;

/**
 * Implementation of the ICategoryService  interface
 *
 * @author Diptee Warudkar
 */
public class CategoryService extends AbstractService implements ICategoryService{

	@Override
	public List<Category> list()  throws NotFoundException{
		return list(defaultDomain);
	}
	
	@Override
	public List<Category> list(Domain domain)  throws NotFoundException{
		HttpGet request = getRequest("/categories");
		request.addHeader(HttpHeaders.ACCEPT_LANGUAGE,domain.getLocale());
		return execute(request, new TypeReference<List<Category>>() {});
	}
	
	@Override
	public Category read(String key) throws NotFoundException {
		return read(defaultDomain,key);
	}

	@Override
	public Category read(Domain domain, String key) throws NotFoundException {
		HttpGet request = getRequest("/categories/" + key);
		request.addHeader(HttpHeaders.ACCEPT_LANGUAGE,domain.getLocale());
		return execute(request, new TypeReference<Category>() {});
	}
}


