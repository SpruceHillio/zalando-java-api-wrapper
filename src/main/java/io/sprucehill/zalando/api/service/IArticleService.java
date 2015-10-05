package io.sprucehill.zalando.api.service;

import io.sprucehill.zalando.api.exception.NotFoundException;
import io.sprucehill.zalando.api.model.Article;
import io.sprucehill.zalando.api.model.Domain;

import java.util.List;

/**
 * Service interface to article related API endpoints
 *
 * @author Michael Duergner
 */
public interface IArticleService {

    /**
     * The different possibilities to sort the articles when searching
     */
    enum Sorting {
        /**
         * Sorting by popularity descending
         */
        POPULARITY("popularity"),
        /**
         * Sorting by the date the article has been first added descending
         */
        ACTIVATION_DATE("activationDate"),
        /**
         * Sorting by the article price descending
         */
        PRICE_DESC("priceDesc"),
        /**
         * Sorting by the article price ascending
         */
        PRICE_ASC("priceAsc"),
        /**
         * Sorting by whether an article is on sale or not; sale articles appear first
         */
        SALE("sale");

        private String sortingString;

        private Sorting(String sortingString) {
            this.sortingString = sortingString;
        }

        public String getSortingString() {
            return sortingString;
        }
    }

    /**
     * Read a specific article; this method will use the default domain
     *
     * @param id    The ID (SKU) of the article to read
     * @return      The article with the requested ID
     * @throws NotFoundException    A NotFoundException is thrown if the article cannot be loaded;
     */
    Article read(String id) throws NotFoundException;

    /**
     * Read a specific article for the domain specified
     *
     * @param id        The ID (SKU) of teh article to read
     * @param domain    The shop domain to use
     * @return          The article with the requested ID for the specified domain
     * @throws NotFoundException    A NotFoundException is thrown if the article cannot be loaded; you might want to try and change the domain.
     */
    Article read(String id, Domain domain) throws NotFoundException;

    /**
     * Get variants of the article specified by the ID (SKU) with sorting by popularity and using default domain
     *
     * @param id    The ID of the article to get variants for
     * @return      A list of articles being variants of the article specified by the ID submitted
     * @throws NotFoundException    A NotFoundException is thrown if the article cannot be loaded; you might want to try and change the domain.
     */
    List<Article> variants(String id) throws NotFoundException;

    /**
     * Get variants of the article specified by the ID (SKU) with the specified sorting and using default domain
     *
     * @param id        The ID of the article to get variants for
     * @param sorting   The sorting to use
     * @return          A list of articles being variants of the article specified by the ID submitted
     * @throws NotFoundException    A NotFoundException is thrown if the article cannot be loaded; you might want to try and change the domain.
     */
    List<Article> variants(String id, Sorting sorting) throws NotFoundException;

    /**
     * Get variants of the article specified by the ID (SKU) with sorting by popularity and using the specified domain
     *
     * @param id        The ID of the article to get variants for
     * @param domain    The domain to use
     * @return          A list of articles being variants of the article specified by the ID submitted
     * @throws NotFoundException    A NotFoundException is thrown if the article cannot be loaded; you might want to try and change the domain.
     */
    List<Article> variants(String id, Domain domain) throws NotFoundException;

    /**
     * Get variants of the article specified by the ID (SKU) with the specified sorting and using the specified domain
     *
     * @param id        The ID of the article to get variants for
     * @param sorting   The sorting to use
     * @param domain    The domain to use
     * @return          A list of articles being variants of the article specified by the ID submitted
     * @throws NotFoundException    A NotFoundException is thrown if the article cannot be loaded; you might want to try and change the domain.
     */
    List<Article> variants(String id, Sorting sorting, Domain domain) throws NotFoundException;
}
