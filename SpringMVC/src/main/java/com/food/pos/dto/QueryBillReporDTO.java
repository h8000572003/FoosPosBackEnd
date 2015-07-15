package com.food.pos.dto;

import java.io.Serializable;

import com.food.pos.util.report.IReprtParmeter;

public class QueryBillReporDTO extends IReprtParmeter implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String yyyy;
	private String month;
	private int totalMoney = 0;
	private String begin = "";
	private String endDate = "";
	private String path = "";
	
	

	private QueryBillReporDTOResutDTO queryBillReporDTOResutDTO = new QueryBillReporDTOResutDTO();

	public String getYyyy() {
		return yyyy;
	}

	public void setYyyy(String yyyy) {
		this.yyyy = yyyy;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public QueryBillReporDTOResutDTO getQueryBillReporDTOResutDTO() {
		return queryBillReporDTOResutDTO;
	}

	public void setQueryBillReporDTOResutDTO(
			QueryBillReporDTOResutDTO queryBillReporDTOResutDTO) {
		this.queryBillReporDTOResutDTO = queryBillReporDTOResutDTO;
	}

	public int getTotalMoney() {
		return totalMoney;
	}

	public void setTotalMoney(int totalMoney) {
		this.totalMoney = totalMoney;
	}

	public String getBegin() {
		return begin;
	}

	public void setBegin(String begin) {
		this.begin = begin;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

}
