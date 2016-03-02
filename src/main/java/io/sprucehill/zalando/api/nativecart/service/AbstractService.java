package io.sprucehill.zalando.api.nativecart.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.sprucehill.zalando.api.model.Domain;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.*;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * @author Michael Duergner
 */
public abstract class AbstractService {

    String apiBase = "https://api.zalando.com";

    String scheme;

    String host;

    Integer port;

    String pathPrefix;

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
            throw new RuntimeException("'defaultDomain' must be set!");
        }
        if (null == apiBase) {
            throw new RuntimeException("'apiBase' must be set!");
        }
        try {
            URI uri = new URI(apiBase);
            scheme = uri.getScheme();
            host = uri.getHost();
            port = uri.getPort();
            pathPrefix = uri.getPath();
            if (("https".equalsIgnoreCase(scheme) && 443 == port) || ("http".equalsIgnoreCase(scheme) && 80 == port)) {
                port = null;
            }
            if ("/".equalsIgnoreCase(pathPrefix)) {
                pathPrefix = null;
            }
            else if (pathPrefix.endsWith("/")) {
                pathPrefix = pathPrefix.substring(0,pathPrefix.length()-1);
            }
        }
        catch (URISyntaxException e) {
            throw new RuntimeException("'apiBase' is invalid");
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
     * Create an initialize a GET request for the specified URIBuilder
     *
     * @param uriBuilder    The URIBuilder to work upon
     * @return              A HttGet object for the specified URIBuilder's URI
     * @throws URISyntaxException   Throw if URI cannot be built from the supplied URIBuilder
     */
    HttpGet getRequest(URIBuilder uriBuilder) throws URISyntaxException {
        return enrich(new HttpGet(normalize(uriBuilder)));
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
     * the current implementation only append a '/' if none is present and prefix with API Base
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
     * Helper method to normalize a supplied path;
     * the current implementation will set scheme, host, port and prefix with pathPrefix if present
     *
     * @param uriBuilder    The URIBuilder to work upon
     * @return              A normalized path with defaults set if necessary
     * @throws URISyntaxException   Throw if the URL cannot be built
     */
    protected String normalize(URIBuilder uriBuilder) throws URISyntaxException {
        if (null == uriBuilder.getHost() || null == uriBuilder.getScheme()) {
            uriBuilder.setHost(host);
            uriBuilder.setScheme(scheme);
            if (null != port) {
                uriBuilder.setPort(port);
            }
            if (null != pathPrefix) {
                uriBuilder.setPath(pathPrefix + uriBuilder.getPath());
            }
        }
        return uriBuilder.build().toString();
    }

    /**
     * Enrich a HttpRequest with some default stuff;
     * the current implementation does nothing here
     *
     * @param request    The request to enrich
     * @param <T>        Generic method to handle different types of HttpRequests
     * @return           The supplied HttpRequest object
     */
    protected <T extends HttpRequestBase> T enrich(T request) {
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
    protected <T> T execute(HttpRequestBase request, TypeReference<T> typeReference)  {
        try {
            if (null == request.getHeaders(HttpHeaders.ACCEPT_LANGUAGE)) {
                request.addHeader(HttpHeaders.ACCEPT_LANGUAGE,defaultDomain.getLocale());
            }
            HttpResponse httpResponse = httpClient.execute(request);
            if (200 == httpResponse.getStatusLine().getStatusCode()) {
                return objectMapper.readValue(httpResponse.getEntity().getContent(),typeReference);
            }
            else {
                throw new RuntimeException("StatusCode: "+httpResponse.getStatusLine().getStatusCode() + ", Reason: " + httpResponse.getStatusLine().getReasonPhrase());
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

    protected static abstract class Init<S extends AbstractService, I, B extends Init<S,I,B>> {

        protected S service;

        protected Init(S service) {
            this.service = service;
        }

        public B withHttpClient(HttpClient httpClient) {
            service.setHttpClient(httpClient);
            return self();
        }

        public B withObjectMapper(ObjectMapper objectMapper) {
            service.setObjectMapper(objectMapper);
            return self();
        }

        public B withApiBase(String apiBase) {
            service.setApiBase(apiBase);
            return self();
        }

        public B withDefaultDomain(Domain defaultDomain) {
            service.setDefaultDomain(defaultDomain);
            return self();
        }

        protected void onBuild() {
            service.postConstruct();
        }

        protected abstract B self();

        public abstract I build();
    }
}
