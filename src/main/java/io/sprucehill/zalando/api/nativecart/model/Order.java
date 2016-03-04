package io.sprucehill.zalando.api.nativecart.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.sprucehill.zalando.api.model.Base;

/**
 * 
 * @author dipteewarudkar
 *
 */
public class Order extends Base {

	@JsonProperty(value="checkout_id")
	private String checkoutId;
	
	@JsonProperty(value="order_number")
	private String orderNumber;

	@JsonProperty(value="customer_number")
	private String customerNumber;

	@JsonProperty(value="billing_address")
	private Address billingAddress	;

	@JsonProperty(value="shipping_address")
	private Address shippingAddress;

	@JsonProperty
	private Delivery delivery;

	@JsonProperty(value="gross_total")
	private Money grossTotal;

	@JsonProperty(value="tax_total")
	private Money taxTotal;

	@JsonProperty
	private String created;

	@JsonProperty(value="detail_url")
	private String detailUrl;	

	@JsonProperty(value="external_payment_url")
	private String externalPaymentUrl;

	public Order(){}

	public Order(String orderNumber,String customerNumber,Address billingAddress,Address shippingAddress,Delivery delivery,
			Money grossTotal,Money taxTotal,String created,String detailUrl,String externalPaymentUrl){
		this.orderNumber=orderNumber;
		this.customerNumber=customerNumber;
		this.billingAddress=billingAddress;
		this.shippingAddress=shippingAddress;
		this.delivery=delivery;
		this.grossTotal=grossTotal;
		this.taxTotal=taxTotal;
		this.created=created;
		this.detailUrl=detailUrl;
		this.externalPaymentUrl=externalPaymentUrl;
	}

	public String getOrderNumber() {
		return orderNumber;
	}
	
	public String getCustomerNumber() {
		return customerNumber;
	}
	
	public Address getBillingAddress() {
		return billingAddress;
	}
	
	public Address getShippingAddress() {
		return shippingAddress;
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
	
	public String getCreated() {
		return created;
	}
	
	public String getDetailUrl() {
		return detailUrl;
	}
	
	public String getExternalPaymentUrl() {
		return externalPaymentUrl;
	}
	
	public void setCheckoutId(String checkoutId) {
		this.checkoutId = checkoutId;
	}
}
