package io.sprucehill.zalando.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Michael Duergner
 */
public class Brand extends Base {

    @JsonProperty
    String key;

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

    public String getKey() {
        return key;
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

        return key.equals(brand.key);

    }

    @Override
    public int hashCode() {
        return key.hashCode();
    }
}
