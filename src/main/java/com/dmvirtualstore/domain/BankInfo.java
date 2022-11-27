package com.dmvirtualstore.domain;

import java.io.Serializable;

public class BankInfo implements Serializable{


	private static final long serialVersionUID = 1L;
	public Payer payer;
    public Collector collector;
    public Object is_same_bank_account_owner;
    public Object origin_bank_id;
    public Object origin_wallet_id;

}
