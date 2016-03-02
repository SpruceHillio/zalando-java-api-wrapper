package io.sprucehill.zalando.api.nativecart.model;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.sprucehill.zalando.api.model.Base;

/**
 * 
 * @author dipteewarudkar
 *
 */
public class Payment extends Base {
	
	@JsonProperty(value="callback_url")
	private String callbackUrl;
	
	@JsonProperty
	private Map<String, String> templateParameters = new HashMap<String, String>();
	
	@JsonProperty(value="selection_page_url")
	private String selectionPageUrl;
	
	@JsonProperty
	private Selected selected;

	public String getCallbackUrl() {
		return callbackUrl;
	}
	
	public Map<String, String> getTemplateParameters() {
		return templateParameters;
	}
	
	public String getSelectionPageUrl() {
		return selectionPageUrl;
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

