package io.sprucehill.zalando.api.nativecart.model;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.sprucehill.zalando.api.model.Base;

/**
 * 
 * @author dipteewarudkar
 *
 */
public class Cart extends Base {
	
	@JsonProperty
	private String id;
	
	@JsonProperty(value="sales_channel")
	private String appDomainId;
	
	@JsonProperty
	private List<Items> items = new ArrayList<Items>();
	
	@JsonProperty(value="items_out_of_stock")
	private List<String> itemsOutOfStock = new ArrayList<String>();
	
	@JsonProperty
	private Delivery delivery;
	
	@JsonProperty
	private Money grossTotal;
	
	@JsonProperty
	private Money taxTotal;
	
	@JsonProperty(value="cart_url")
	private String cartUrl;
	
	public Cart() {}
	
	public Cart(String id,String appDomainId ,List<Items> items,List<String> itemsOutOfStock,Delivery delivery,
			Money grossTotal,Money taxTotal,String cartUrl){
		this.id =id;
		this.appDomainId=appDomainId;
		this.items =items;
		this.itemsOutOfStock =itemsOutOfStock;
		this.delivery =delivery;
		this.grossTotal =grossTotal;
		this.taxTotal= taxTotal;
		this.cartUrl=cartUrl;
	}
	
	public String getId() {
		return id;
	}
	
	public String getAppDomainId() {
		return appDomainId;
	}
	
	public List<Items> getItems() {
		return items;
	}
	
	public List<String> getItemsOutOfStock() {
		return itemsOutOfStock;
	}
	
	public Delivery getDelivery() {
		return delivery;
	}
	
	public Money getGrossTotal() {
		return grossTotal;
	}
	
	public Money getTaxTotal() {
		return taxTotal;
	}
	
	public String getCartUrl() {
		return cartUrl;
	}
}
