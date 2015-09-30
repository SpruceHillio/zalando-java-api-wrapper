package io.sprucehill.zalando.api.service;

import com.fasterxml.jackson.core.type.TypeReference;
import io.sprucehill.zalando.api.exception.NotFoundException;
import io.sprucehill.zalando.api.model.Brand;
import io.sprucehill.zalando.api.model.Domain;
import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.HttpGet;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * Implementation of the IBrandService service interface
 *
 * @author Michael Duergner
 */
public class BrandService extends AbstractService implements IBrandService {

    Integer defaultPageSize = 200;

    /**
     * Set the default page size to use; defaults to 200
     *
     * @param defaultPageSize    The defauilt page size to use
     */
    public void setDefaultPageSize(Integer defaultPageSize) {
        this.defaultPageSize = defaultPageSize;
    }

    @PostConstruct
    @Override
    public void postConstruct() {
        super.postConstruct();
    }

    @Override
    public List<Brand> list() throws NotFoundException {
        return list(defaultDomain);
    }

    @Override
    public List<Brand> list(Integer page, Integer pageSize) throws NotFoundException {
        return list(defaultDomain,page,pageSize);
    }

    @Override
    public List<Brand> list(Domain domain) throws NotFoundException {
        return list(domain,1,defaultPageSize);
    }

    @Override
    public List<Brand> list(Domain domain, Integer page, Integer pageSize) throws NotFoundException {
        HttpGet request = getRequest("/brands?page=" + page + "&pageSize=" + pageSize);
        request.addHeader(HttpHeaders.ACCEPT_LANGUAGE,domain.getLocale());
        return execute(request, new TypeReference<List<Brand>>() {});
    }

    @Override
    public Brand read(String code) throws NotFoundException {
        return read(code,defaultDomain);
    }

    @Override
    public Brand read(String code, Domain domain) throws NotFoundException {
        HttpGet request = getRequest("/brands/" + code);
        request.addHeader(HttpHeaders.ACCEPT_LANGUAGE,domain.getLocale());
        return execute(request, new TypeReference<Brand>() {});
    }
}
