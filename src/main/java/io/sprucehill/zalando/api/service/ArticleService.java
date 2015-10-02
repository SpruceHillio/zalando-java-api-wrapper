package io.sprucehill.zalando.api.service;

import com.fasterxml.jackson.core.type.TypeReference;
import io.sprucehill.zalando.api.exception.NotFoundException;
import io.sprucehill.zalando.api.model.Article;
import io.sprucehill.zalando.api.model.Domain;
import org.apache.http.HttpHeaders;
import org.apache.http.NameValuePair;
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
        return read(id,defaultDomain);
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
        return variants(id, Sorting.POPULARITY);
    }

    @Override
    public List<Article> variants(String id, Sorting sorting) throws NotFoundException {
        return variants(id,sorting,defaultDomain);
    }

    @Override
    public List<Article> variants(String id, Domain domain) throws NotFoundException {
        return variants(id,Sorting.POPULARITY,domain);
    }

    @Override
    public List<Article> variants(String id, Sorting sorting, Domain domain) throws NotFoundException {
        String modelId = id.substring(0,id.lastIndexOf("-"));
        return search(Collections.singletonList(new BasicNameValuePair("articleModelId", modelId)),sorting,domain);
    }

    protected List<Article> search(List<NameValuePair> nameValuePairs, Sorting sorting, Domain domain) throws NotFoundException {
        URIBuilder builder = new URIBuilder().
                setPath("/articles").
                addParameters(nameValuePairs).
                addParameter("sorting", sorting.getSortingString());
        try {
            HttpGet request = getRequest(builder);
            request.addHeader(HttpHeaders.ACCEPT_LANGUAGE,domain.getLocale());
            return execute(request, new TypeReference<List<Article>>() {});
        }
        catch (URISyntaxException e) {
            logger.error(e.getMessage(), e);
            throw new RuntimeException(e.getMessage(),e);
        }
    }
}
