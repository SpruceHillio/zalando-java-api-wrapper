package io.sprucehill.zalando.api.service;

import com.fasterxml.jackson.core.type.TypeReference;
import io.sprucehill.zalando.api.exception.NotFoundException;
import io.sprucehill.zalando.api.model.Article;
import io.sprucehill.zalando.api.model.Domain;
import io.sprucehill.zalando.api.model.internal.Page;
import org.apache.http.HttpHeaders;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.message.BasicNameValuePair;

import javax.annotation.PostConstruct;
import java.net.URISyntaxException;
import java.util.Collections;
import java.util.List;

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
    public Article read(String id) throws NotFoundException {
        return read(id, defaultDomain);
    }

    @Override
    public Article read(String id, Domain domain) throws NotFoundException {
        HttpGet request = getRequest("/articles/" + id);
        request.addHeader(HttpHeaders.ACCEPT_LANGUAGE,domain.getLocale());
        return execute(request, new TypeReference<Article>() {
        });
    }

    @Override
    public List<Article> variants(String id) throws NotFoundException {
        return variants(id,null,defaultDomain);
    }

    @Override
    public List<Article> variants(String id, Sorting sorting) throws NotFoundException {
        return variants(id,null,defaultDomain);
    }

    @Override
    public List<Article> variants(String id, Domain domain) throws NotFoundException {
        return variants(id, null, domain);
    }

    @Override
    public List<Article> variants(String id, Sorting sorting, Domain domain) throws NotFoundException {
        String modelId = id.substring(0, id.lastIndexOf("-"));
        return search(Collections.singletonList(new BasicNameValuePair("articleModelId", modelId)), null, domain);
    }

    protected List<Article> search(List<NameValuePair> nameValuePairs, Sorting sorting, Domain domain) throws NotFoundException {
        URIBuilder builder = new URIBuilder().
                setPath("/articles").
                addParameters(nameValuePairs);
        if (null != sorting) {
            builder.addParameter("sorting",sorting.getSortingString());
        }
        try {
            HttpGet request = getRequest(builder);
            request.addHeader(HttpHeaders.ACCEPT_LANGUAGE,domain.getLocale());
            return execute(request, new TypeReference<Page<List<Article>>>() {}).getContent();
        }
        catch (URISyntaxException e) {
            logger.error(e.getMessage(), e);
            throw new RuntimeException(e.getMessage(),e);
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    protected static abstract class Init<B extends Init<B>> extends AbstractService.Init<ArticleService, IArticleService, B> {

        protected Init() {
            super(new ArticleService());
        }
    }

    public static class Builder extends Init<Builder> {

        @Override
        protected Builder self() {
            return this;
        }

        @Override
        public IArticleService build() {
            onBuild();
            return service;
        }
    }
}
