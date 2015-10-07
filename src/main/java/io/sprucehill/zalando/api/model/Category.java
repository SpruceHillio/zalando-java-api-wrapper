package io.sprucehill.zalando.api.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Diptee Warudkar
 */
public class Category extends Base {

    @JsonProperty
    String name;

    @JsonProperty
    String key;

    @JsonProperty
    String parentKey;

    @JsonProperty
    List<String> childKeys;

    @JsonProperty
    String type;

    @JsonProperty
    Boolean outlet;

    @JsonProperty
    Boolean hidden;

    @JsonProperty
    String targetGroup;

    @JsonProperty
    List<String> suggestedFilters;

    public String getName() {
        return name;
    }


    public String getParentKey() {
        return parentKey;
    }


    public List<String> getChildKeys() {
        return childKeys;
    }


    public String getType() {
        return type;
    }


    public Boolean isOutlet() {
        return outlet;
    }


    public Boolean isHidden() {
        return hidden;
    }


    public String getTargetGroup() {
        return targetGroup;
    }


    public List<String> getSuggestedFilters() {
        return suggestedFilters;
    }

    public String getKey() {
        return key;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Category category = (Category) o;

        return key.equals(category.key);
    }

    @Override
    public int hashCode() {
        return key.hashCode();
    }
}