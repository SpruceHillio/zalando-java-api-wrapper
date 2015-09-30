package io.sprucehill.zalando.api.service;

import io.sprucehill.zalando.api.exception.NotFoundException;
import io.sprucehill.zalando.api.model.Brand;
import io.sprucehill.zalando.api.model.Domain;

import java.util.List;

/**
 * Service interface for all brand related API endpoints
 *
 * @author Michael Duergner
 */
public interface IBrandService {

    /**
     * Get a list of all available brands
     *
     * @return  A list of all available brands
     * @throws NotFoundException    This exception is thrown when a 404 status code is encountered on the response
     */
    List<Brand> list() throws NotFoundException;

    /**
     * Get a list of available brands, limited to the specified page with the specified page size
     *
     * @param page        The page to request
     * @param pageSize    The page size to use
     * @return            A list of available brands for the specified page and pagesize
     * @throws NotFoundException    This exception is thrown when a 404 status code is encountered on the response
     */
    List<Brand> list(Integer page, Integer pageSize) throws NotFoundException;

    /**
     * Get a list of all available brands for the specified domain
     * @param domain    The shop domain to use
     * @return          A list of all available brands for the specified domain
     * @throws NotFoundException    This exception is thrown when a 404 status code is encountered on the response
     */
    List<Brand> list(Domain domain) throws NotFoundException;

    /**
     * Get a list of available brands, limited to the specified page with the specified page size for the domain specified
     *
     * @param domain      The shop domain to use
     * @param page        The page to request
     * @param pageSize    The page size to use
     * @return            A list of available brands for the specified page and pagesize for the specified domain
     * @throws NotFoundException    This exception is thrown when a 404 status code is encountered on the response
     */
    List<Brand> list(Domain domain, Integer page, Integer pageSize) throws NotFoundException;

    /**
     * Get information for a specific brand
     *
     * @param code    The code of the brand to retrieve
     * @return        The brand specified by the code submitted
     * @throws NotFoundException    This exception is thrown when a 404 status code is encountered on the response
     */
    Brand read(String code) throws NotFoundException;

    /**
     * Get information for a specific brand within the specified domain
     *
     * @param code      The code of the brand to retrieve
     * @param domain    The shop domain to use
     * @return          The brand specified bt the code submitted for the specified domain
     * @throws NotFoundException    This exception is thrown when a 404 status code is encountered on the response
     */
    Brand read(String code, Domain domain) throws NotFoundException;
}
