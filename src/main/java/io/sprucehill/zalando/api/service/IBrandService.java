package io.sprucehill.zalando.api.service;

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
     */
    List<Brand> list();

    /**
     * Get a list of available brands, limited to the specified page with the specified page size
     *
     * @param page        The page to request
     * @param pageSize    The page size to use
     * @return            A list of available brands for the specified page and pagesize
     */
    List<Brand> list(Integer page, Integer pageSize);

    /**
     * Get a list of all available brands for the specified domain
     * @param domain    The shop domain to use
     * @return          A list of all available brands for the specified domain
     */
    List<Brand> list(Domain domain);

    /**
     * Get a list of available brands, limited to the specified page with the specified page size for the domain specified
     *
     * @param domain      The shop domain to use
     * @param page        The page to request
     * @param pageSize    The page size to use
     * @return            A list of available brands for the specified page and pagesize for the specified domain
     */
    List<Brand> list(Domain domain, Integer page, Integer pageSize);

    /**
     * Get information for a specific brand
     *
     * @param code    The code of the brand to retrieve
     * @return        The brand specified by the code submitted
     */
    Brand read(String code);

    /**
     * Get information for a specific brand within the specified domain
     *
     * @param code      The code of the brand to retrieve
     * @param domain    The shop domain to use
     * @return          The brand specified bt the code submitted for the specified domain
     */
    Brand read(String code, Domain domain);
}
