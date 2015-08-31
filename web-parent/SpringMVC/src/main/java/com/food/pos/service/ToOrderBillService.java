package com.food.pos.service;

import com.food.pos.dto.ToOrderBillDTO;

public interface ToOrderBillService {
	public void readData(ToOrderBillDTO dto);

	public void sendBill(ToOrderBillDTO dto);
}
