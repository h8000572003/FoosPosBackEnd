package com.food.pos.service;

import com.food.pos.dto.PosMessageDTO;

public interface PosMessageService {
	public void loadMessage(PosMessageDTO dto);
	public void insertNewMessageWhen2Query(PosMessageDTO dto);
	
	void modify2Query(PosMessageDTO dto);
	void delete2Query(PosMessageDTO dto);
}
