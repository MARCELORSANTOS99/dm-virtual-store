package com.dmvirtualstore.domain;

import java.io.Serializable;

public class Identification  implements Serializable{


	private static final long serialVersionUID = 1L;
	
	private String number;
	private String type;
	
	
	
	public Identification() {
	}



	public Identification(String number, String type) {
		super();
		this.number = number;
		this.type = type;
	}



	public String getNumber() {
		return number;
	}



	public void setNumber(String number) {
		this.number = number;
	}



	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}
	
	
	
	

}
