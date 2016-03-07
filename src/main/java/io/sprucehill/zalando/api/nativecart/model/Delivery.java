package io.sprucehill.zalando.api.nativecart.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.sprucehill.zalando.api.model.Base;

/**
 * 
 * @author dipteewarudkar
 *
 */
public class Delivery extends Base {
	
	@JsonProperty
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date earliest;
	
	@JsonProperty
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date latest;
	
	public Date getEarliest() {
		return earliest;
	}
	
	public void setEarliest(Date earliest) {
		this.earliest = earliest;
	}
	
	public Date getLatest() {
		return latest;
	}
	
	public void setLatest(Date latest) {
		this.latest = latest;
	}
}
