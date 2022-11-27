package com.dmvirtualstore.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CieloResponseEstorno {
    @JsonProperty("Status") 
    private Integer status;
    @JsonProperty("ReasonCode") 
    private Integer reasonCode;
    @JsonProperty("ReasonMessage") 
    private String reasonMessage;
    @JsonProperty("ProviderReturnCode") 
    private String providerReturnCode;
    @JsonProperty("ProviderReturnMessage") 
    private String providerReturnMessage;
    @JsonProperty("ReturnCode") 
    private String returnCode;
    @JsonProperty("ReturnMessage") 
    private String returnMessage;
    @JsonProperty("Tid") 
    private String tid;
    @JsonProperty("ProofOfSale") 
    private String proofOfSale;
    @JsonProperty("AuthorizationCode") 
    private String authorizationCode;
    
	public CieloResponseEstorno() {
		super();
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getReasonCode() {
		return reasonCode;
	}

	public void setReasonCode(Integer reasonCode) {
		this.reasonCode = reasonCode;
	}

	public String getReasonMessage() {
		return reasonMessage;
	}

	public void setReasonMessage(String reasonMessage) {
		this.reasonMessage = reasonMessage;
	}

	public String getProviderReturnCode() {
		return providerReturnCode;
	}

	public void setProviderReturnCode(String providerReturnCode) {
		this.providerReturnCode = providerReturnCode;
	}

	public String getProviderReturnMessage() {
		return providerReturnMessage;
	}

	public void setProviderReturnMessage(String providerReturnMessage) {
		this.providerReturnMessage = providerReturnMessage;
	}

	public String getReturnCode() {
		return returnCode;
	}

	public void setReturnCode(String returnCode) {
		this.returnCode = returnCode;
	}

	public String getReturnMessage() {
		return returnMessage;
	}

	public void setReturnMessage(String returnMessage) {
		this.returnMessage = returnMessage;
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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CieloResponseEstorno [status=");
		builder.append(status);
		builder.append(", reasonCode=");
		builder.append(reasonCode);
		builder.append(", reasonMessage=");
		builder.append(reasonMessage);
		builder.append(", providerReturnCode=");
		builder.append(providerReturnCode);
		builder.append(", providerReturnMessage=");
		builder.append(providerReturnMessage);
		builder.append(", returnCode=");
		builder.append(returnCode);
		builder.append(", returnMessage=");
		builder.append(returnMessage);
		builder.append(", tid=");
		builder.append(tid);
		builder.append(", proofOfSale=");
		builder.append(proofOfSale);
		builder.append(", authorizationCode=");
		builder.append(authorizationCode);
		builder.append("]");
		return builder.toString();
	}
	
	
	
    
    

}