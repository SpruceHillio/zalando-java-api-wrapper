package io.sprucehill.zalando.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * @author Michael Duergner
 */
public class Article extends Base {

    public enum Gender {
        MALE,FEMALE
    }

    public enum AgeGroup {
        BABY,CHILD,TEEN,ADULT
    }

    public static class Attribute {

        @JsonProperty
        String name;

        @JsonProperty
        List<String> values;

        public String getName() {
            return name;
        }

        public List<String> getValues() {
            return values;
        }
    }

    @JsonProperty
    String id;

    @JsonProperty
    String modelId;

    @JsonProperty
    String name;

    @JsonProperty
    String shopUrl;

    @JsonProperty
    String color;

    @JsonProperty
    Boolean available;

    @JsonProperty
    String season;

    @JsonProperty
    String seasonYear;

    @JsonProperty
    Date activationDate;

    @JsonProperty
    Set<Gender> genders;

    @JsonProperty
    Set<AgeGroup> ageGroups;

    @JsonProperty
    Brand brand;

    @JsonProperty
    Set<String> categoryKeys;

    @JsonProperty
    List<Attribute> attributes;

    @JsonProperty
    List<String> additionalInfos;

    @JsonProperty
    List<Unit> units;

    @JsonProperty
    Media media;

    public String getId() {
        return id;
    }

    public String getModelId() {
        return modelId;
    }

    public String getName() {
        return name;
    }

    public String getShopUrl() {
        return shopUrl;
    }

    public String getColor() {
        return color;
    }

    public Boolean getAvailable() {
        return available;
    }

    public String getSeason() {
        return season;
    }

    public String getSeasonYear() {
        return seasonYear;
    }

    public Date getActivationDate() {
        return activationDate;
    }

    public Set<Gender> getGenders() {
        return genders;
    }

    public Set<AgeGroup> getAgeGroups() {
        return ageGroups;
    }

    public Brand getBrand() {
        return brand;
    }

    public Set<String> getCategoryKeys() {
        return categoryKeys;
    }

    public List<Attribute> getAttributes() {
        return attributes;
    }

    public List<String> getAdditionalInfos() {
        return additionalInfos;
    }

    public List<Unit> getUnits() {
        return units;
    }

    public Media getMedia() {
        return media;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Article article = (Article) o;

        return id.equals(article.id);

    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
