package io.sprucehill.zalando.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public  class Category extends Base{

	@JsonProperty
	String name;
	
	@JsonProperty
	String key;

	
	@JsonProperty
	String parentKey;

	@JsonProperty
	String childKeys[];

	@JsonProperty
	String type;

	@JsonProperty
	boolean outlet;

	@JsonProperty
	boolean hidden;

	@JsonProperty
	String targetGroup;

	@JsonProperty
	String[] suggestedFilters;

	public String getName() {
		return name;
	}


	public String getParentKey() {
		return parentKey;
	}


	public String[] getChildKeys() {
		return childKeys;
	}


	public String getType() {
		return type;
	}


	public boolean isOutlet() {
		return outlet;
	}


	public boolean isHidden() {
		return hidden;
	}


	public String getTargetGroup() {
		return targetGroup;
	}


	public String[] getSuggestedFilters() {
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