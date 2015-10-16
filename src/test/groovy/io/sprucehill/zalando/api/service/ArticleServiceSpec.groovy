package io.sprucehill.zalando.api.service

import com.fasterxml.jackson.databind.ObjectMapper
import io.sprucehill.zalando.api.exception.NotFoundException
import io.sprucehill.zalando.api.model.Currency
import io.sprucehill.zalando.api.model.Domain
import org.apache.http.impl.client.HttpClientBuilder
import spock.lang.Specification

/**
 *
 *
 * @author Michael Duergner
 */
class ArticleServiceSpec extends Specification {

    IArticleService articleService = ArticleService.
            builder().
            withHttpClient(HttpClientBuilder.
                    create().
                    build()).
            withObjectMapper(new ObjectMapper()).
            withDefaultDomain(Domain.DE).
            build()

    def 'read an existing single article with default domain'() {
        when:
        def article = articleService.read('LM121C05Q-K11')
        then:
        'LM121C05Q-K11' == article.getId()
        'Blau' == article.getColor()
    }

    def 'read an existing single article with specific domain'() {
        when:
        def article = articleService.read('LM121C05Q-K11',Domain.GB)
        then:
        'LM121C05Q-K11' == article.getId()
        'Blue' == article.getColor()
    }

    def 'read an existing single article with SE domain'() {
        when:
        def article = articleService.read('LM121C05Q-K11',Domain.SE)
        then:
        'LM121C05Q-K11' == article.getId()
        Currency.SEK == article.getUnits().first().getPrice().getCurrency()
        'Blå' == article.getColor()
    }

    def 'read a not existing article with default domain'() {
        when:
        articleService.read('LM121C05Q-K12')
        then:
        NotFoundException e = thrown()
    }

    def 'read a not existing article with specific domain'() {
        when:
        articleService.read('LM121C05Q-K12',Domain.GB)
        then:
        NotFoundException e = thrown()
    }

    def 'variants for an existing article with default sorting and default domain'() {
        when:
        def variants = articleService.variants('LM121C05Q-K11')
        then:
        0 < variants.size()
    }

    def 'variants for an existing article with default sorting and specific domain'() {
        when:
        def variants = articleService.variants('LM121C05Q-K11',Domain.GB)
        then:
        0 < variants.size()
    }

    def 'variants for a not existing article with default sorting and default domain'() {

    }

    def 'variants for a not existing article with default sorting and specific domain'() {

    }

    def 'variants for an existing article with specific sorting and default domain'() {

    }

    def 'variants for an existing article with specific sorting and specific domain'() {

    }

    def 'variants for a not existing article with specific sorting and default domain'() {

    }

    def 'variants for a not existing article with specific sorting and specific domain'() {

    }
}
