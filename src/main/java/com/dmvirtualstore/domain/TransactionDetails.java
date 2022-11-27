package com.dmvirtualstore.domain;

import java.io.Serializable;

public class TransactionDetails implements Serializable{


	private static final long serialVersionUID = 1L;
	
	
	public Object payment_method_reference_id;
    public int net_received_amount;
    public double total_paid_amount;
    public int overpaid_amount;
    public Object external_resource_url;
    public int installment_amount;
    public Object financial_institution;
    public Object payable_deferral_period;
    public Object acquirer_reference;
    public Object bank_transfer_id;
    public Object transaction_id;

}
