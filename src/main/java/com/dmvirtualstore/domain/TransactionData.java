package com.dmvirtualstore.domain;

import java.io.Serializable;

public class TransactionData implements Serializable{


	private static final long serialVersionUID = 1L;
	
	private String qr_code;
	private String bank_transfer_id;
	private String transaction_id;
	private String e2e_id;
	private String financial_institution;
	private String ticket_url;
	private BankInfo bank_info;
	private String qr_code_base64;
	public String getQr_code() {
		return qr_code;
	}
	public void setQr_code(String qr_code) {
		this.qr_code = qr_code;
	}
	public String getBank_transfer_id() {
		return bank_transfer_id;
	}
	public void setBank_transfer_id(String bank_transfer_id) {
		this.bank_transfer_id = bank_transfer_id;
	}
	public String getTransaction_id() {
		return transaction_id;
	}
	public void setTransaction_id(String transaction_id) {
		this.transaction_id = transaction_id;
	}
	public String getE2e_id() {
		return e2e_id;
	}
	public void setE2e_id(String e2e_id) {
		this.e2e_id = e2e_id;
	}
	public String getFinancial_institution() {
		return financial_institution;
	}
	public void setFinancial_institution(String financial_institution) {
		this.financial_institution = financial_institution;
	}
	public String getTicket_url() {
		return ticket_url;
	}
	public void setTicket_url(String ticket_url) {
		this.ticket_url = ticket_url;
	}
	public BankInfo getBank_info() {
		return bank_info;
	}
	public void setBank_info(BankInfo bank_info) {
		this.bank_info = bank_info;
	}
	public String getQr_code_base64() {
		return qr_code_base64;
	}
	public void setQr_code_base64(String qr_code_base64) {
		this.qr_code_base64 = qr_code_base64;
	}
	
	
	

}
