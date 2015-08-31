package com.food.pos.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PosMessageDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private List<PosMessageResultDTO>posMessageResultDTOs=new ArrayList<PosMessageResultDTO>();

	
	private PosMessageResultDTO addPostMessage=new PosMessageResultDTO();
	
	private PosMessageResultDTO selectPostMessage=new PosMessageResultDTO();
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}




	public List<PosMessageResultDTO> getPosMessageResultDTOs() {
		return posMessageResultDTOs;
	}




	public void setPosMessageResultDTOs(List<PosMessageResultDTO> posMessageResultDTOs) {
		this.posMessageResultDTOs = posMessageResultDTOs;
	}




	public PosMessageResultDTO getAddPostMessage() {
		return addPostMessage;
	}




	public void setAddPostMessage(PosMessageResultDTO addPostMessage) {
		this.addPostMessage = addPostMessage;
	}




	public PosMessageResultDTO getSelectPostMessage() {
		return selectPostMessage;
	}




	public void setSelectPostMessage(PosMessageResultDTO selectPostMessage) {
		this.selectPostMessage = selectPostMessage;
	}
	
	
	
	
}
