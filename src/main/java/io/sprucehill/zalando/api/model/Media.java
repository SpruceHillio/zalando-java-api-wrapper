package io.sprucehill.zalando.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @author Michael Duergner
 */
public class Media extends Base {

    @JsonProperty
    List<Image> images;

    public List<Image> getImages() {
        return images;
    }
}
