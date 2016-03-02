package io.sprucehill.zalando.api.nativecart.model;

import java.util.List;

/**
 * 
 * @author dipteewarudkar
 *
 */
public class CreateCartRequest extends Cart{

	public CreateCartRequest(String appDomainId,List<Items> items){
		super(null,appDomainId,items,null,null,null,null,null);
	}
}
