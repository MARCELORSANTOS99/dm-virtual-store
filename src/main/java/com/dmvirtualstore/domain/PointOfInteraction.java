package com.dmvirtualstore.domain;

import java.io.Serializable;

public class PointOfInteraction implements Serializable{


		private static final long serialVersionUID = 1L;
	
	 	private String type;
	 	private BusinessInfo business_info;
	 	private Location location;
	 	private ApplicationData application_data;
	 	private TransactionData transaction_data;
	 	
	 	
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public BusinessInfo getBusiness_info() {
			return business_info;
		}
		public void setBusiness_info(BusinessInfo business_info) {
			this.business_info = business_info;
		}
		public Location getLocation() {
			return location;
		}
		public void setLocation(Location location) {
			this.location = location;
		}
		public ApplicationData getApplication_data() {
			return application_data;
		}
		public void setApplication_data(ApplicationData application_data) {
			this.application_data = application_data;
		}
		public TransactionData getTransaction_data() {
			return transaction_data;
		}
		public void setTransaction_data(TransactionData transaction_data) {
			this.transaction_data = transaction_data;
		}
	    
	    
	    

}
