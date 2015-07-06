package com.food.pos.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ShowMessagDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<ShowMessagResultDTO>messages=new ArrayList<ShowMessagResultDTO>();

	public List<ShowMessagResultDTO> getMessages() {
		return messages;
	}

	public void setMessages(List<ShowMessagResultDTO> messages) {
		this.messages = messages;
	}
	
	
	
	
}
