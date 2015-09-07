package io.sprucehill.zalando.api.service;

import com.fasterxml.jackson.core.type.TypeReference;
import io.sprucehill.zalando.api.model.Article;
import io.sprucehill.zalando.api.model.Domain;
import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.HttpGet;

import javax.annotation.PostConstruct;

/**
 * Implementation of the IArticleService service interface
 *
 * @author Michael Duergner
 */
public class ArticleService extends AbstractService implements IArticleService {

    Integer defaultPageSize = 200;

    /**
     * Set the default page size; default to 200
     *
     * @param defaultPageSize    The default page size to use
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
    public Article read(String id) {
        return read(id,defaultDomain);
    }

    @Override
    public Article read(String id, Domain domain) {
        HttpGet request = getRequest("/articles/" + id);
        request.addHeader(HttpHeaders.ACCEPT_LANGUAGE,domain.getLocale());
        return execute(request, new TypeReference<Article>() {});
    }
}
