package io.sprucehill.zalando.api.nativecart.model;

import java.util.ArrayList;
import java.util.List;

public class GetCartResponse  extends Base{
	private String id = null;
	private String appDomainId = null;
	private List<Items> items = new ArrayList<Items>();
	private List<String> itemsOutOfStock = new ArrayList<String>();
	private Delivery delivery = null;
	private Money grossTotal = null;
	private Money taxTotal = null;
	private String cartUrl = null;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAppDomainId() {
		return appDomainId;
	}
	public void setAppDomainId(String appDomainId) {
		this.appDomainId = appDomainId;
	}
	public List<Items> getItems() {
		return items;
	}
	public void setItems(List<Items> items) {
		this.items = items;
	}
	public List<String> getItemsOutOfStock() {
		return itemsOutOfStock;
	}
	public void setItemsOutOfStock(List<String> itemsOutOfStock) {
		this.itemsOutOfStock = itemsOutOfStock;
	}
	public Delivery getDelivery() {
		return delivery;
	}
	public void setDelivery(Delivery delivery) {
		this.delivery = delivery;
	}
	public Money getGrossTotal() {
		return grossTotal;
	}
	public void setGrossTotal(Money grossTotal) {
		this.grossTotal = grossTotal;
	}
	public Money getTaxTotal() {
		return taxTotal;
	}
	public void setTaxTotal(Money taxTotal) {
		this.taxTotal = taxTotal;
	}
	public String getCartUrl() {
		return cartUrl;
	}
	public void setCartUrl(String cartUrl) {
		this.cartUrl = cartUrl;
	}
}
