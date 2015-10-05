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
class BrandServiceSpec extends Specification {

    IBrandService brandService = BrandService.
            builder().
            withHttpClient(HttpClientBuilder.
                    create().
                    build()).
            withObjectMapper(new ObjectMapper()).
            withDefaultDomain(Domain.DE).
            build()

    def 'list all brands with default domain'() {
        when:
        def brands = brandService.list()
        then:
        0 < brands.size()
    }

    def 'list a specific page of brands with default domain'() {

    }

    def 'list all brands with specific domain'() {

    }

    def 'list a specific page of brands with specific domain'() {

    }

    def 'read an existing single brand with default domain'() {

    }

    def 'read an existing single brand with specific domain'() {

    }

    def 'read a not existing single brand with default domain'() {

    }

    def 'read a not existing single brand with specific domain'() {

    }
}
