package com.food.pos.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.food.pos.json.Bill;

public class BillBeanDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String yyyymmdd = "";

	private List<Bill> bills = new ArrayList<Bill>();

	private Date queryDate = new Date();

	private Bill selectBill = new Bill();

	public String getYyyymmdd() {
		return yyyymmdd;
	}

	public void setYyyymmdd(String yyyymmdd) {
		this.yyyymmdd = yyyymmdd;
	}

	public List<Bill> getBills() {
		return bills;
	}

	public void setBills(List<Bill> bills) {
		this.bills = bills;
	}

	public Date getQueryDate() {
		return queryDate;
	}

	public void setQueryDate(Date queryDate) {
		this.queryDate = queryDate;
	}

	public Bill getSelectBill() {
		return selectBill;
	}

	public void setSelectBill(Bill selectBill) {
		this.selectBill = selectBill;
	}
	
	

}
