package io.sprucehill.zalando.api.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.sprucehill.zalando.api.model.Domain;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.*;
import org.apache.http.impl.client.HttpClientBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import java.io.IOException;

/**
 * @author Michael Duergner
 */
public abstract class AbstractService {

    String apiBase = "https://api.zalando.com";

    protected Domain defaultDomain;

    protected Logger logger = LoggerFactory.getLogger(getClass());

    protected HttpClient httpClient;

    protected ObjectMapper objectMapper;

    /**
     * Set a different API base
     *
     * @param apiBase    The API base to use; defaults to 'https://api.zalando.com'
     */
    public void setApiBase(String apiBase) {
        this.apiBase = apiBase;
    }

    /**
     * Set the default domain to use; this is a mandatory setter to be called
     *
     * @param defaultDomain    The default shop domain to use
     */
    public void setDefaultDomain(Domain defaultDomain) {
        this.defaultDomain = defaultDomain;
    }

    /**
     * Set a custom HttpClient to use; the bean will create a default HttpClient on its postConstruct method if no HttpClient has been set previously.
     * You might want to set your custom HttpClient as the default implementation does not use any pooling or threading implementation.
     *
     * @param httpClient    The HttpClient to use.
     */
    public void setHttpClient(HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    /**
     * Set a custom ObjectMapper to use; the bean will create a default ObjectMapper on its postConstruct method if no ObjectMapper has been set previously.
     *
     * @param objectMapper    The ObjectMapper to use.
     */
    public void setObjectMapper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    /**
     * Call this method on postConstruct for any subclasses as it takes care to initialize the bean
     */
    @PostConstruct
    public void postConstruct() {
        if (null == httpClient) {
            httpClient = HttpClientBuilder.create().build();
        }
        if (null == objectMapper) {
            objectMapper = new ObjectMapper();
        }
        if (null == defaultDomain) {
            throw new RuntimeException("You need to set a 'defaultDomain'");
        }
    }

    /**
     * Create and initialize a GET request for the specified path
     *
     * @param path    The path of the GET request
     * @return        A HttpGet object for the specified path
     */
    HttpGet getRequest(String path) {
        return enrich(new HttpGet(normalizePath(path)));
    }

    /**
     * Create and initialize a POST request for the specified path
     *
     * @param path    The path of the POST request
     * @return        A HttpGet object for the specified path
     */
    HttpPost postRequest(String path) {
        return enrich(new HttpPost(normalizePath(path)));
    }

    /**
     * Create and initialize a PUT request for the specified path
     *
     * @param path    The path of the PUT request
     * @return        A HttpGet object for the specified path
     */
    HttpPut putRequest(String path) {
        return enrich(new HttpPut(normalizePath(path)));
    }

    /**
     * Create and initialize a DELETE request for the specified path
     *
     * @param path    The path of the DELETE request
     * @return        A HttpGet object for the specified path
     */
    HttpDelete deleteRequest(String path) {
        return enrich(new HttpDelete(normalizePath(path)));
    }

    /**
     * Helper method to normalize a supplied path;
     * the current implementation only append a '/' if none is present.
     *
     * @param path    The path to normalize
     * @return        The normalized path
     */
    protected String normalizePath(String path) {
        if (!path.startsWith("/")) {
            path = "/" + path;
        }
        return apiBase + path;
    }

    /**
     * Enrich a HttpRequest with some default stuff;
     * the current implementation only adds the default domain if present.
     *
     * @param request    The request to enrich
     * @param <T>        Generic method to handle different types of HttpRequests
     * @return           The supplied HttpRequest object
     */
    protected <T extends HttpRequestBase> T enrich(T request) {
        if (null != defaultDomain) {
            request.addHeader(HttpHeaders.ACCEPT_LANGUAGE,defaultDomain.getLocale());
        }
        return request;
    }

    /**
     * Execute a HttpRequest and handle common response states.
     *
     * @param request          The HttpRequest to execute
     * @param typeReference    The type of the expected response
     * @param <T>              Generic method to request different response data
     * @return                 The response data for the request
     */
    protected <T> T execute(HttpRequestBase request, TypeReference<T> typeReference) {
        try {
            HttpResponse httpResponse = httpClient.execute(request);
            if (200 == httpResponse.getStatusLine().getStatusCode()) {
                return objectMapper.readValue(httpResponse.getEntity().getContent(),typeReference);
            }
            else {
                throw new RuntimeException("StatusCode: "+httpResponse.getStatusLine().getStatusCode());
            }
        }
        catch (IOException e) {
            logger.error(e.getMessage(), e);
            throw new RuntimeException(e);
        }
        finally {
            if (null != request && !request.isAborted()) {
                request.abort();
            }
        }
    }
}
