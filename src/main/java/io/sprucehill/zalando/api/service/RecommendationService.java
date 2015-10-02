package io.sprucehill.zalando.api.service;

import com.fasterxml.jackson.core.type.TypeReference;
import io.sprucehill.zalando.api.exception.NotFoundException;
import io.sprucehill.zalando.api.model.Article;
import io.sprucehill.zalando.api.model.Domain;
import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.HttpGet;

import java.util.List;

/**
 * Implementation of the IRecommendationService interface
 *
 * @author Michael Duergner <michael@sprucehill.io>
 */
public class RecommendationService extends AbstractService implements IRecommendationService {

    @Override
    public List<Article> list(String id) throws NotFoundException {
        return list(id,defaultDomain);
    }

    @Override
    public List<Article> list(String id, Domain domain) throws NotFoundException {
        HttpGet request = getRequest("/recommendations/" + id);
        request.addHeader(HttpHeaders.ACCEPT_LANGUAGE,domain.getLocale());
        return execute(request, new TypeReference<List<Article>>() {});
    }
}
