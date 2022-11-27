package com.dmvirtualstore.domain;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreditCard implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@JsonProperty("CardNumber") 
    private String cardNumber;
    @JsonProperty("Holder") 
    private String holder;
    @JsonProperty("ExpirationDate") 
    private String expirationDate;
    @JsonProperty("SecurityCode") 
    private String securityCode;
    @JsonProperty("Brand") 
    private String brand;
    
    @JsonProperty("SaveCard") 
    public boolean saveCard;
          
    
	public CreditCard() {
		super();
	}
	public CreditCard(String cardNumber, String holder, String expirationDate, String securityCode, String brand) {
		super();
		this.cardNumber = cardNumber;
		this.holder = holder;
		this.expirationDate = expirationDate;
		this.securityCode = securityCode;
		this.brand = brand;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getHolder() {
		return holder;
	}
	public void setHolder(String holder) {
		this.holder = holder;
	}
	public String getExpirationDate() {
		return expirationDate;
	}
	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}
	public String getSecurityCode() {
		return securityCode;
	}
	public void setSecurityCode(String securityCode) {
		this.securityCode = securityCode;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CreditCard [cardNumber=");
		builder.append(cardNumber);
		builder.append(", holder=");
		builder.append(holder);
		builder.append(", expirationDate=");
		builder.append(expirationDate);
		builder.append(", securityCode=");
		builder.append(securityCode);
		builder.append(", brand=");
		builder.append(brand);
		builder.append("]");
		return builder.toString();
	}
    
    
	
	

}
