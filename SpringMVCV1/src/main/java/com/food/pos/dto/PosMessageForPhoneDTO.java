package com.food.pos.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import net.bootsfaces.render.E;

public class PosMessageForPhoneDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String message = "";

	private List<PosMessageForPhoneResultDTO> items = new ArrayList<PosMessageForPhoneResultDTO>();
	private List<PosMessageForPhoneResultDTO> selectItems = new ArrayList<PosMessageForPhoneResultDTO>();

	public List<PosMessageForPhoneResultDTO> getItems() {
		return items;
	}

	public void setItems(List<PosMessageForPhoneResultDTO> items) {
		this.items = items;
	}

	public List<PosMessageForPhoneResultDTO> getSelectItems() {
		return selectItems;
	}

	public void setSelectItems(List<PosMessageForPhoneResultDTO> selectItems) {
		this.selectItems = selectItems;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
