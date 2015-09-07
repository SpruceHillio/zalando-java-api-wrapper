package io.sprucehill.zalando.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Michael Duergner
 */
public class Unit extends Base {

    @JsonProperty
    String id;

    @JsonProperty
    String size;

    @JsonProperty
    Boolean available;

    @JsonProperty
    Integer stock;

    public String getId() {
        return id;
    }

    public String getSize() {
        return size;
    }

    public Boolean getAvailable() {
        return available;
    }

    public Integer getStock() {
        return stock;
    }
}
