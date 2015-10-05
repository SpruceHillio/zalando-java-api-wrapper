package io.sprucehill.zalando.api.service;

import io.sprucehill.zalando.api.exception.NotFoundException;
import io.sprucehill.zalando.api.model.Article;
import io.sprucehill.zalando.api.model.Domain;

import java.util.List;

/**
 * Service interface for methods related to recommendations
 *
 * @author Michael Duergner
 */
public interface IRecommendationService {

    /**
     * Get a list of articles similar to the one specified by the ID submitted; this method will use the default domain
     *
     * @param id    The ID (SKU) to get similar articles for
     * @return      A list of articles similar to the article identified by the ID submitted
     * @throws      NotFoundException   A NotFoundException is thrown if the article to get recommendations for is not
     *              available
     */
    List<Article> list(String id) throws NotFoundException;

    /**
     * Get a list of articles similar to the one specified by the ID submitted on the domain specified
     *
     * @param id        The ID (SKU) to get similar articles for
     * @param domain    The domain to use
     * @return          A list of articles similar to the article identified by the ID submitted
     * @throws          NotFoundException   A NotFoundException is thrown if the article to get recommendations for is
     *                  not available
     */
    List<Article> list(String id, Domain domain) throws NotFoundException;
}
