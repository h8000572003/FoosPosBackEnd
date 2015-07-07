package com.food.pos.service;

import com.food.pos.dto.ContractDTO;

public interface ContractService {
	void sendMail(ContractDTO dto);
}
