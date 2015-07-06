package com.food.pos.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ToOrderBillDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<ToOrderFoodDTO> foods = new ArrayList<ToOrderFoodDTO>();
	private List<ToOrderFeatureDTO> features = new ArrayList<ToOrderFeatureDTO>();

	private List<String> featureStringList = new ArrayList<String>();

	private List<ToOrderFoodItemDTO> toOrderFoods = new ArrayList<ToOrderFoodItemDTO>();

	private String name = "";
	private String dollar = "";
	private String number = "";
	private String outOrIn = "";
	private String seat = "";
	private String seqNo = "";
	
	

	public String getOutOrIn() {
		return outOrIn;
	}

	public void setOutOrIn(String outOrIn) {
		this.outOrIn = outOrIn;
	}

	public String getSeat() {
		return seat;
	}

	public void setSeat(String seat) {
		this.seat = seat;
	}

	public String getSeqNo() {
		return seqNo;
	}

	public void setSeqNo(String seqNo) {
		this.seqNo = seqNo;
	}

	public List<ToOrderFoodDTO> getFoods() {
		return foods;
	}

	public void setFoods(List<ToOrderFoodDTO> foods) {
		this.foods = foods;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDollar() {
		return dollar;
	}

	public void setDollar(String dollar) {
		this.dollar = dollar;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public List<ToOrderFeatureDTO> getFeatures() {
		return features;
	}

	public void setFeatures(List<ToOrderFeatureDTO> features) {
		this.features = features;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<String> getFeatureStringList() {
		return featureStringList;
	}

	public void setFeatureStringList(List<String> featureStringList) {
		this.featureStringList = featureStringList;
	}

	public List<ToOrderFoodItemDTO> getToOrderFoods() {
		return toOrderFoods;
	}

	public void setToOrderFoods(List<ToOrderFoodItemDTO> toOrderFoods) {
		this.toOrderFoods = toOrderFoods;
	}

}
