package com.dmvirtualstore.domain;

import java.io.Serializable;

public class CieloRequest implements Serializable{
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CieloRequest [merchantOrderId=");
		builder.append(merchantOrderId);
		builder.append(", payment=");
		builder.append(payment.toString());
		builder.append("]");
		return builder.toString();
	}
	private static final long serialVersionUID = 1L;
	
	
	 	//@JsonProperty("MerchantOrderId") 
	    public String merchantOrderId;
	    //@JsonProperty("Payment") 
	    public PaymentRequest payment;
		public CieloRequest() {
			super();
		}
		
		
		
		
		public CieloRequest(String merchantOrderId, PaymentRequest payment) {
			super();
			this.merchantOrderId = merchantOrderId;
			this.payment = payment;
		}




		public String getMerchantOrderId() {
			return merchantOrderId;
		}
		public void setMerchantOrderId(String merchantOrderId) {
			this.merchantOrderId = merchantOrderId;
		}
		public PaymentRequest getPayment() {
			return payment;
		}
		public void setPayment(PaymentRequest payment) {
			this.payment = payment;
		}
	    
	    
	
}
