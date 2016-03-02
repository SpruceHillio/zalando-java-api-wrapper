package io.sprucehill.zalando.api.nativecart.model;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @author dipteewarudkar
 *
 */
public class Payment extends Base{
	@JsonProperty
	private String callback_url;
	@JsonProperty
	private Map<String, String> templateParameters = new HashMap<String, String>();
	@JsonProperty
	private String selection_page_url;
	@JsonProperty
	private Selected selected;

	public String getCallback_url() {
		return callback_url;
	}
	public Map<String, String> getTemplateParameters() {
		return templateParameters;
	}
	public String getSelection_page_url() {
		return selection_page_url;
	}
	public Selected getSelected() {
		return selected;
	}

	public static class Selected extends Base {
		@JsonProperty
		private String method;
		@JsonProperty
		private Map<String, String> metadata = new HashMap<String, String>();
		public String getMethod() {
			return method;
		}
		public Map<String, String> getMetadata() {
			return metadata;
		}
	}

}

