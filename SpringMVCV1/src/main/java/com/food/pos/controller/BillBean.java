package com.food.pos.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.food.pos.contract.AeUtils;
import com.food.pos.dto.BillBeanDTO;
import com.food.pos.service.BillService;

@ManagedBean(name = "billBean", eager = false)
@RequestScoped
public class BillBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BillBeanDTO dto=new BillBeanDTO();

	private static Logger LOG = LoggerFactory.getLogger(BillBean.class);

	@ManagedProperty(value = "#{billService}")
	private transient BillService service;

	@PostConstruct
	public void init() {
		this.dto = new BillBeanDTO();
		this.dto.setYyyymmdd(AeUtils.getNowTime());
	}

	public BillBeanDTO getDto() {
		return dto;
	}

	public void setDto(BillBeanDTO dto) {
		this.dto = dto;
	}

	public String doQuery() {
		service.query(dto);
		return null;

	}

	public BillService getService() {
		return service;
	}

	public void setService(BillService service) {
		this.service = service;
	}

}
