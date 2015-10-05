package io.sprucehill.zalando.api.model.internal;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.sprucehill.zalando.api.model.Base;

/**
 * @author Michael Duergner
 */
public class Page<T> extends Base {

    @JsonProperty
    T content;

    @JsonProperty
    Integer totalElements;

    @JsonProperty
    Integer totalPages;

    @JsonProperty
    Integer page;

    @JsonProperty
    Integer size;

    public T getContent() {
        return content;
    }

    public Integer getTotalElements() {
        return totalElements;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public Integer getPage() {
        return page;
    }

    public Integer getSize() {
        return size;
    }
}
