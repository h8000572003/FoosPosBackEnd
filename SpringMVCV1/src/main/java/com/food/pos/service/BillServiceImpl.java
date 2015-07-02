package com.food.pos.service;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.food.pos.controller.BillCompent;
import com.food.pos.dto.BillBeanDTO;

@Service("billService")
public class BillServiceImpl implements BillService {

	private static Logger LOG = LoggerFactory.getLogger(BillServiceImpl.class);

	@Autowired
	private BillCompent billCompent;

	@Override
	public void query(BillBeanDTO dto) {
		
		dto.getBills().clear();
		dto.getBills().addAll(billCompent.findAll(dto.getYyyymmdd()));
		LOG.info(ToStringBuilder.reflectionToString(dto.getBills()));
	}

}
