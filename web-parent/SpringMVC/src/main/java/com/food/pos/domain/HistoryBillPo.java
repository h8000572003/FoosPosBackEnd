package com.food.pos.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "HistoryBill")
public class HistoryBillPo {
	@Id
	@Column(name = "txId")
	private String txId;

	@Column(name = "useNo")
	private String useNo;

	@Column(name = "orderDate")
	private String orderDate;

	@Column(name = "orderTime")
	private String orderTime;

	@Column(name = "outOrIn")
	private String outOrIn;

	@Column(name = "isPaid")
	private String isPaid;

	@Column(name = "isMealOut")
	private String isMealOut;

	@Column(name = "dollar")
	private String dollar;

	@Column(name = "seat")
	private String seat;

	@Column(name = "feature")
	private String feature;

	@Column(name = "isSpeakOut")
	private String isSpeakOut = "N";

	public String getTxId() {
		return txId;
	}

	public void setTxId(String txId) {
		this.txId = txId;
	}

	public String getUseNo() {
		return useNo;
	}

	public void setUseNo(String useNo) {
		this.useNo = useNo;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public String getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(String orderTime) {
		this.orderTime = orderTime;
	}

	public String getOutOrIn() {
		return outOrIn;
	}

	public void setOutOrIn(String outOrIn) {
		this.outOrIn = outOrIn;
	}

	public String getIsPaid() {
		return isPaid;
	}

	public void setIsPaid(String isPaid) {
		this.isPaid = isPaid;
	}

	public String getIsMealOut() {
		return isMealOut;
	}

	public void setIsMealOut(String isMealOut) {
		this.isMealOut = isMealOut;
	}

	public String getDollar() {
		return dollar;
	}

	public void setDollar(String dollar) {
		this.dollar = dollar;
	}

	public String getSeat() {
		return seat;
	}

	public void setSeat(String seat) {
		this.seat = seat;
	}

	public String getFeature() {
		return feature;
	}

	public void setFeature(String feature) {
		this.feature = feature;
	}

	public String getIsSpeakOut() {
		return isSpeakOut;
	}

	public void setIsSpeakOut(String isSpeakOut) {
		this.isSpeakOut = isSpeakOut;
	}
	
	
}
