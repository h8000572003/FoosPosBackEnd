package com.food.pos.service;

import com.food.pos.dto.PosMessageForPhoneDTO;

public interface PosMessagePhoneService {
	void post(PosMessageForPhoneDTO dto);

	void queryAllDevice(PosMessageForPhoneDTO dto);
}
