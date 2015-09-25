package io.sprucehill.zalando.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Michael Duergner
 */
public class Image extends Base {

    public enum Type {
        STYLE,NON_MODEL,MODEL,UNSPECIFIED,PREMIUM,MANUFACTURER
    }

    @JsonProperty
    Integer orderNumber;

    @JsonProperty
    Type type;

    @JsonProperty
    String thumbnailHdUrl;

    @JsonProperty
    String smallUrl;

    @JsonProperty
    String smallHdUrl;

    @JsonProperty
    String mediumUrl;

    @JsonProperty
    String mediumHdUrl;

    @JsonProperty
    String largeUrl;

    @JsonProperty
    String largeHdUrl;

    public Integer getOrderNumber() {
        return orderNumber;
    }

    public Type getType() {
        return type;
    }

    public String getThumbnailHdUrl() {
        return thumbnailHdUrl;
    }

    public String getSmallUrl() {
        return smallUrl;
    }

    public String getSmallHdUrl() {
        return smallHdUrl;
    }

    public String getMediumUrl() {
        return mediumUrl;
    }

    public String getMediumHdUrl() {
        return mediumHdUrl;
    }

    public String getLargeUrl() {
        return largeUrl;
    }

    public String getLargeHdUrl() {
        return largeHdUrl;
    }
}
