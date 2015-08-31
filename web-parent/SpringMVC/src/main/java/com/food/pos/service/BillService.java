package com.food.pos.service;

import com.food.pos.bean.BillBean;
import com.food.pos.dto.BillBeanDTO;

public interface BillService {
	public void query(BillBeanDTO dto);
	
	public void convert2History(BillBeanDTO dto);
}
