package io.sprucehill.zalando.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Michael Duergner
 */
public class BrandFamily extends Base {

    @JsonProperty
    String code;

    @JsonProperty
    String name;

    @JsonProperty
    String shopUrl;

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getShopUrl() {
        return shopUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BrandFamily that = (BrandFamily) o;

        return code.equals(that.code);

    }

    @Override
    public int hashCode() {
        return code.hashCode();
    }
}
