package io.sprucehill.zalando.api.service;

import java.util.List;

import io.sprucehill.zalando.api.exception.NotFoundException;
import io.sprucehill.zalando.api.model.Category;
import io.sprucehill.zalando.api.model.Domain;

public interface ICategoryService {
	
	List<Category> list(Domain domain, String targetGroup,List<String> keys) throws NotFoundException;

	List<Category> list(Domain domain) throws NotFoundException;

}
