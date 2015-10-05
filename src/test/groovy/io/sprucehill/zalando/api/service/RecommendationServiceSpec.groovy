package io.sprucehill.zalando.api.service

import com.fasterxml.jackson.databind.ObjectMapper
import io.sprucehill.zalando.api.model.Domain
import org.apache.http.impl.client.HttpClientBuilder
import spock.lang.Specification

/**
 *
 *
 * @author Michael Duergner
 */
class RecommendationServiceSpec extends Specification {

    IRecommendationService recommendationService = RecommendationService.
            builder().
            withHttpClient(HttpClientBuilder.
                    create().
                    build()).
            withObjectMapper(new ObjectMapper()).
            withDefaultDomain(Domain.DE).
            build()

    def 'list with existing article and default domain'() {
        when:
        def recommendations = recommendationService.list('LM121C05Q-K11')
        then:
        0 < recommendations.size()
    }

    def 'list with existing article and specific domain'() {
        when:
        def recommendations = recommendationService.list('LM121C05Q-K11',Domain.GB)
        then:
        0 < recommendations.size()
    }

    def 'list with not existing article and default domain'() {
        when:
        def recommendations = recommendationService.list('lm121c05q-k11')
        then:
        0 == recommendations.size()
    }

    def 'list with not existing article and specific domain'() {
        when:
        def recommendations = recommendationService.list('lm121c05q-k11',Domain.GB)
        then:
        0 == recommendations.size()
    }
}
