package io.sprucehill.zalando.api.nativecart.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @author dipteewarudkar
 *
 */
public abstract class Order extends Base{
	@JsonProperty
	private String order_number;	
	@JsonProperty
	private String customer_number;
	@JsonProperty
	private Address billing_address	;
	@JsonProperty
	private Address shipping_address;	
	@JsonProperty
	private Delivery delivery;
	@JsonProperty
	private Money gross_total;
	@JsonProperty
	private Money tax_total;	
	@JsonProperty
	private String created;
	@JsonProperty
	private String detail_url;	
	@JsonProperty
	private String external_payment_url;
	
	public Order(){}
	
	public Order(String order_number,String customer_number,Address billing_address,Address shipping_address,Delivery delivery,
			Money gross_total,Money tax_total,String created,String detail_url,String external_payment_url){
		this.order_number=order_number;
		this.customer_number=customer_number;
		this.billing_address=billing_address;
		this.shipping_address=shipping_address;
		this.delivery=delivery;
		this.gross_total=gross_total;
		this.tax_total=tax_total;
		this.created=created;
		this.detail_url=detail_url;
		this.external_payment_url=external_payment_url;
	}
	
	
	public String getOrder_number() {
		return order_number;
	}
	public String getCustomer_number() {
		return customer_number;
	}
	public Address getBilling_address() {
		return billing_address;
	}
	public Address getShipping_address() {
		return shipping_address;
	}
	public Delivery getDelivery() {
		return delivery;
	}
	public Money getGross_total() {
		return gross_total;
	}
	public Money getTax_total() {
		return tax_total;
	}
	public String getCreated() {
		return created;
	}
	public String getDetail_url() {
		return detail_url;
	}
	public String getExternal_payment_url() {
		return external_payment_url;
	}	

	
}
