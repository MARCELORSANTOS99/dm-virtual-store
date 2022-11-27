package com.dmvirtualstore.domain;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Payment implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@JsonProperty("ServiceTaxAmount") 
    public int serviceTaxAmount;
    @JsonProperty("Installments") 
    private int installments;
    @JsonProperty("Interest") 
    private int interest;
    @JsonProperty("Capture") 
    private boolean capture;
    @JsonProperty("Authenticate") 
    private boolean authenticate;
    @JsonProperty("Recurrent") 
    private boolean recurrent;
    @JsonProperty("CreditCard") 
    private CreditCard creditCard;
    @JsonProperty("Tid") 
    private String tid;
    @JsonProperty("ProofOfSale") 
    private String proofOfSale;
    @JsonProperty("AuthorizationCode") 
    private String authorizationCode;
    @JsonProperty("SoftDescriptor") 
    private String softDescriptor;
    @JsonProperty("Provider") 
    private String provider;
    @JsonProperty("IsQrCode") 
    private boolean isQrCode;
    @JsonProperty("DynamicCurrencyConversion") 
    private boolean dynamicCurrencyConversion;
    @JsonProperty("Amount") 
    private int amount;
    @JsonProperty("ReceivedDate") 
    private String receivedDate;
    @JsonProperty("Status") 
    private int status;
    @JsonProperty("IsSplitted") 
    private boolean isSplitted;
    @JsonProperty("ReturnMessage") 
    private String returnMessage;
    @JsonProperty("ReturnCode") 
    private String returnCode;
    @JsonProperty("PaymentId") 
    private String paymentId;
    @JsonProperty("Type") 
    private String type;
    @JsonProperty("Currency") 
    private String currency;
    @JsonProperty("Country") 
    private String country;
    
    
    
    
	public Payment(String type, int amount, int installments, String softDescriptor, CreditCard creditCard) {
		super();
		this.type = type;
		this.amount = amount;
		this.installments = installments;
		this.softDescriptor = softDescriptor;
		System.out.println("*** RETORNOU ****");
		this.creditCard = creditCard;
	}

	public Payment() {
		super();
	}

	public int getServiceTaxAmount() {
		return serviceTaxAmount;
	}

	public void setServiceTaxAmount(int serviceTaxAmount) {
		this.serviceTaxAmount = serviceTaxAmount;
	}

	public int getInstallments() {
		return installments;
	}

	public void setInstallments(int installments) {
		this.installments = installments;
	}

	public int getInterest() {
		return interest;
	}

	public void setInterest(int interest) {
		this.interest = interest;
	}

	public boolean isCapture() {
		return capture;
	}

	public void setCapture(boolean capture) {
		this.capture = capture;
	}

	public boolean isAuthenticate() {
		return authenticate;
	}

	public void setAuthenticate(boolean authenticate) {
		this.authenticate = authenticate;
	}

	public boolean isRecurrent() {
		return recurrent;
	}

	public void setRecurrent(boolean recurrent) {
		this.recurrent = recurrent;
	}

	public CreditCard getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(CreditCard creditCard) {
		this.creditCard = creditCard;
	}

	public String getTid() {
		return tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
	}

	public String getProofOfSale() {
		return proofOfSale;
	}

	public void setProofOfSale(String proofOfSale) {
		this.proofOfSale = proofOfSale;
	}

	public String getAuthorizationCode() {
		return authorizationCode;
	}

	public void setAuthorizationCode(String authorizationCode) {
		this.authorizationCode = authorizationCode;
	}

	public String getSoftDescriptor() {
		return softDescriptor;
	}

	public void setSoftDescriptor(String softDescriptor) {
		this.softDescriptor = softDescriptor;
	}

	public String getProvider() {
		return provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

	public boolean isQrCode() {
		return isQrCode;
	}

	public void setQrCode(boolean isQrCode) {
		this.isQrCode = isQrCode;
	}

	public boolean isDynamicCurrencyConversion() {
		return dynamicCurrencyConversion;
	}

	public void setDynamicCurrencyConversion(boolean dynamicCurrencyConversion) {
		this.dynamicCurrencyConversion = dynamicCurrencyConversion;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getReceivedDate() {
		return receivedDate;
	}

	public void setReceivedDate(String receivedDate) {
		this.receivedDate = receivedDate;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public boolean isSplitted() {
		return isSplitted;
	}

	public void setSplitted(boolean isSplitted) {
		this.isSplitted = isSplitted;
	}

	public String getReturnMessage() {
		return returnMessage;
	}

	public void setReturnMessage(String returnMessage) {
		this.returnMessage = returnMessage;
	}

	public String getReturnCode() {
		return returnCode;
	}

	public void setReturnCode(String returnCode) {
		this.returnCode = returnCode;
	}

	public String getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	
		
    
    
    

}
