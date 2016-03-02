package io.sprucehill.zalando.api.nativecart.model;

import java.util.List;

/**
 * 
 * @author dipteewarudkar
 *
 */
public class UpdateCartItemsRequest extends Cart{
	
	public UpdateCartItemsRequest(List<Items> items){
		super(null,null,items,null,null,null,null,null);
	}
}
