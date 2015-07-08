package com.food.pos.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.food.pos.contract.AeUtils;
import com.food.pos.dto.QueryBillReporDTO;
import com.food.pos.service.QueryBillReportService;
import com.food.pos.service.SettingFoodService;

@ManagedBean
@ViewScoped
public class QueryBillReportBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private QueryBillReporDTO dto = new QueryBillReporDTO();

	
	@ManagedProperty(value = "#{queryBillReportService}")
	private transient QueryBillReportService service;
	
	@PostConstruct
	public void init() {
		this.dto = new QueryBillReporDTO();
		this.dto.setYyyy(AeUtils.getNowYear());
	}

	public QueryBillReporDTO getDto() {
		return dto;
	}

	public void setDto(QueryBillReporDTO dto) {
		this.dto = dto;
	}

	public void doQuery() {

	}

	public String queryMonth() {
		return null;
	}
}
