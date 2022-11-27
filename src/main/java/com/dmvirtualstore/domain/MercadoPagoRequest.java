package com.dmvirtualstore.domain;

import java.io.Serializable;

public class MercadoPagoRequest implements Serializable{



	private static final long serialVersionUID = 1L;
	private String description;
	private PayerRequest payer;
	private String payment_method_id;
	private double transaction_amount;
	private String notification_url;
	
	
	
	public MercadoPagoRequest() {
	}
	
	public MercadoPagoRequest(String description, PayerRequest payer, double transaction_amount, String notification_url, String payment_method_id) {
		super();
		this.description = description;
		this.payer = payer;
		this.transaction_amount = transaction_amount;
		this.notification_url = notification_url;
		this.payment_method_id = payment_method_id;
	}
	
	public String getPayment_method_id() {
		return payment_method_id;
	}

	public void setPayment_method_id(String payment_method_id) {
		this.payment_method_id = payment_method_id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public PayerRequest getPayer() {
		return payer;
	}

	public void setPayer(PayerRequest payer) {
		this.payer = payer;
	}

	public double getTransaction_amount() {
		return transaction_amount;
	}

	public void setTransaction_amount(double transaction_amount) {
		this.transaction_amount = transaction_amount;
	}

	public String getNotification_url() {
		return notification_url;
	}

	public void setNotification_url(String notification_url) {
		this.notification_url = notification_url;
	}
	
	

}
