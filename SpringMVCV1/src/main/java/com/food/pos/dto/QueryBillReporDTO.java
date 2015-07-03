package com.food.pos.dto;

import java.io.Serializable;

public class QueryBillReporDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String yyyy;
	private String month;

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

}
