package com.food.pos.dto;

import java.io.Serializable;

public class PosMessageForPhoneResultDTO  implements Serializable{
	private String id;
	private String user;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	
	
	
}
