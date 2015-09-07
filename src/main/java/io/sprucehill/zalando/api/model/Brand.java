package io.sprucehill.zalando.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Michael Duergner
 */
public class Brand extends Base {

    @JsonProperty
    String code;

    @JsonProperty
    String name;

    @JsonProperty
    String logoUrl;

    @JsonProperty
    String logoLargeUrl;

    @JsonProperty
    BrandFamily brandFamily;

    @JsonProperty
    String shopUrl;

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public String getLogoLargeUrl() {
        return logoLargeUrl;
    }

    public BrandFamily getBrandFamily() {
        return brandFamily;
    }

    public String getShopUrl() {
        return shopUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Brand brand = (Brand) o;

        return code.equals(brand.code);

    }

    @Override
    public int hashCode() {
        return code.hashCode();
    }
}
