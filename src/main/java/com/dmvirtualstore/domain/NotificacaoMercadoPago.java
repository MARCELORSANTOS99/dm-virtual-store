package com.dmvirtualstore.domain;

import java.io.Serializable;
import java.util.Date;

//Classe para o receber o id do pagamento via pix na notificação de pagamento
public class NotificacaoMercadoPago implements Serializable{
	private static final long serialVersionUID = 1L;
	 	private int id;
	 	private  boolean live_mode;
	 	private String type;
	 	private Date date_created;
	 	private int application_id;
	 	private int user_id;
	 	private int version;
	 	private String api_version;
	 	private String action;
	    private Data data;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public boolean isLive_mode() {
			return live_mode;
		}
		public void setLive_mode(boolean live_mode) {
			this.live_mode = live_mode;
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public Date getDate_created() {
			return date_created;
		}
		public void setDate_created(Date date_created) {
			this.date_created = date_created;
		}
		public int getApplication_id() {
			return application_id;
		}
		public void setApplication_id(int application_id) {
			this.application_id = application_id;
		}
		public int getUser_id() {
			return user_id;
		}
		public void setUser_id(int user_id) {
			this.user_id = user_id;
		}
		public int getVersion() {
			return version;
		}
		public void setVersion(int version) {
			this.version = version;
		}
		public String getApi_version() {
			return api_version;
		}
		public void setApi_version(String api_version) {
			this.api_version = api_version;
		}
		public String getAction() {
			return action;
		}
		public void setAction(String action) {
			this.action = action;
		}
		public Data getData() {
			return data;
		}
		public void setData(Data data) {
			this.data = data;
		}
	    
	    
	
	
}
