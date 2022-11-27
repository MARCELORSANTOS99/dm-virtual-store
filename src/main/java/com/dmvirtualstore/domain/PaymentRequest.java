package com.dmvirtualstore.domain;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PaymentRequest implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@JsonProperty("Type") 
    private String type;
    @JsonProperty("Amount") 
    private Integer amount;
    @JsonProperty("Installments") 
    private Integer installments;
    @JsonProperty("SoftDescriptor") 
    private String softDescriptor;
    @JsonProperty("CreditCard") 
    private CreditCard creditCard;
        
    
    
	public PaymentRequest(String type, int amount, int installments, String softDescriptor, CreditCard creditCard) {
		super();
		this.type = type;
		this.amount = amount;
		this.installments = installments;
		this.softDescriptor = softDescriptor;
		System.out.println("*** RETORNOU ****");
		this.creditCard = creditCard;
	}

	public PaymentRequest() {
		super();
	}
	
	
	

	

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public void setInstallments(Integer installments) {
		this.installments = installments;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getInstallments() {
		return installments;
	}

	public void setInstallments(int installments) {
		this.installments = installments;
	}

	public String getSoftDescriptor() {
		return softDescriptor;
	}

	public void setSoftDescriptor(String softDescriptor) {
		this.softDescriptor = softDescriptor;
	}

	public CreditCard getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(CreditCard creditCard) {
		this.creditCard = creditCard;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Payment [type=");
		builder.append(type);
		builder.append(", amount=");
		builder.append(amount);
		builder.append(", installments=");
		builder.append(installments);
		builder.append(", softDescriptor=");
		builder.append(softDescriptor);
		builder.append(", creditCard=");
		builder.append(creditCard.toString());
		builder.append("]");
		return builder.toString();
	}
	
	
    
    
    

}
