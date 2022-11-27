package com.dmvirtualstore.domain;

import java.io.Serializable;

public class Payer implements Serializable{


	private static final long serialVersionUID = 1L;
	private Object first_name;
	private Object last_name;
	private String email;
	private Identification identification;
	private Phone phone;
	private Object type;
	private Object entity_type;
	private String id;
	private Object account_id;
	private Object long_name;
	private Object external_account_id;
	
	public Payer() {
		
	}
	
	

	public Payer(Object first_name, Object last_name, String email, Identification identification) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.identification = identification;
	}



	public Payer(Object first_name, Object last_name, String email, Identification identification, Phone phone,
			Object type, Object entity_type, String id, Object account_id, Object long_name,
			Object external_account_id) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.identification = identification;
		this.phone = phone;
		this.type = type;
		this.entity_type = entity_type;
		this.id = id;
		this.account_id = account_id;
		this.long_name = long_name;
		this.external_account_id = external_account_id;
	}

	public Object getFirst_name() {
		return first_name;
	}

	public void setFirst_name(Object first_name) {
		this.first_name = first_name;
	}

	public Object getLast_name() {
		return last_name;
	}

	public void setLast_name(Object last_name) {
		this.last_name = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Identification getIdentification() {
		return identification;
	}

	public void setIdentification(Identification identification) {
		this.identification = identification;
	}

	public Phone getPhone() {
		return phone;
	}

	public void setPhone(Phone phone) {
		this.phone = phone;
	}

	public Object getType() {
		return type;
	}

	public void setType(Object type) {
		this.type = type;
	}

	public Object getEntity_type() {
		return entity_type;
	}

	public void setEntity_type(Object entity_type) {
		this.entity_type = entity_type;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Object getAccount_id() {
		return account_id;
	}

	public void setAccount_id(Object account_id) {
		this.account_id = account_id;
	}

	public Object getLong_name() {
		return long_name;
	}

	public void setLong_name(Object long_name) {
		this.long_name = long_name;
	}

	public Object getExternal_account_id() {
		return external_account_id;
	}

	public void setExternal_account_id(Object external_account_id) {
		this.external_account_id = external_account_id;
	}

	
	
    
    

}
