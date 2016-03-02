package io.sprucehill.zalando.api.nativecart.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @author dipteewarudkar
 *
 */
public class Delivery extends Base{
	@JsonProperty
	private String earliest;
	@JsonProperty
	private String latest;
	public String getEarliest() {
		return earliest;
	}
	public void setEarliest(String earliest) {
		this.earliest = earliest;
	}
	public String getLatest() {
		return latest;
	}
	public void setLatest(String latest) {
		this.latest = latest;
	}

}
