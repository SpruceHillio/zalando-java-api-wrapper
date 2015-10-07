package io.sprucehill.zalando.api.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.HttpGet;
import com.fasterxml.jackson.core.type.TypeReference;

import io.sprucehill.zalando.api.exception.NotFoundException;
import io.sprucehill.zalando.api.model.Category;
import io.sprucehill.zalando.api.model.Domain;

public class CategoryService extends AbstractService implements ICategoryService{

	@Override
	public List<Category> list(Domain domain) throws NotFoundException{
		HttpGet request = getRequest("/categories");
		request.addHeader(HttpHeaders.ACCEPT_LANGUAGE,domain.getLocale());
		return execute(request, new TypeReference<List<Category>>() {});
	}

	@Override
	public List<Category> list(Domain domain, String targetGroup,String[] keys) throws NotFoundException {
		// TODO Auto-generated method stub
		List<Category> categories = new ArrayList<Category>();
		
		for(String key : keys){

			String s ="/categories/"+key;
			HttpGet request = getRequest(s);
			request.addHeader(HttpHeaders.ACCEPT_LANGUAGE,domain.getLocale());
			Category category =  execute(request, new TypeReference<Category>() {});
			categories.add(category);
		}
		return categories;
	}

}


