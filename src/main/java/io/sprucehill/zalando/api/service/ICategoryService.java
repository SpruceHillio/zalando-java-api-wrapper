package io.sprucehill.zalando.api.service;

import java.util.List;

import io.sprucehill.zalando.api.exception.NotFoundException;
import io.sprucehill.zalando.api.model.Category;
import io.sprucehill.zalando.api.model.Domain;
/**
 * Service interface to category related API endpoints
 * @author dipteewarudkar
 *
 */
public interface ICategoryService {
	
	 /**
     * Read a specific category; 
     *
     * @param key    The key of the category to read
     * @param domain The shop domain to use
     * @return      The category with the requested key
     * @throws NotFoundException    A NotFoundException is thrown if the category cannot be loaded;
     */
	Category read(Domain domain,String key) throws NotFoundException;

	/**
     * List all the categories for the given domain
     *
     * @return The category with the requested key
     * @throws NotFoundException    A NotFoundException is thrown if the category cannot be loaded;
     */
	List<Category> list(Domain domain) throws NotFoundException;

	
	/**
     * List all the categories for the defaultdomain
     *
     * @return The category with the requested key
     * @throws NotFoundException    A NotFoundException is thrown if the category cannot be loaded;
     */
	List<Category> list() throws NotFoundException;

	
	
	/**
     * Read a specific category; 
     *
     * @param key    The key of the category to read; this method uses default domain
     * @param domain The shop domain to use
     * @return      The category with the requested key
     * @throws NotFoundException    A NotFoundException is thrown if the category cannot be loaded;
     */
	Category read(String key) throws NotFoundException;

}
