package com.dmvirtualstore.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CieloResponsePayment{
    @JsonProperty("MerchantOrderId") 
    public String merchantOrderId;
    
    @JsonProperty("Payment") 
    public Payment payment;
    
       
    
	public CieloResponsePayment() {
		super();
	}
			

	public CieloResponsePayment(String merchantOrderId, Payment payment) {
		super();
		this.merchantOrderId = merchantOrderId;
	}




	public String getMerchantOrderId() {
		return merchantOrderId;
	}

	public void setMerchantOrderId(String merchantOrderId) {
		this.merchantOrderId = merchantOrderId;
	}


	public Payment getPayment() {
		return payment;
	}


	public void setPayment(Payment payment) {
		this.payment = payment;
	}

    
    
}
