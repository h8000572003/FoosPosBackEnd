package com.food.pos.dto;

public class ToOrderFoodItemDTO {
	private String name;
	private int dollar = 0;
	private String number = "";
	private String specailize = "";
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDollar() {
		return dollar;
	}
	public void setDollar(int dollar) {
		this.dollar = dollar;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getSpecailize() {
		return specailize;
	}
	public void setSpecailize(String specailize) {
		this.specailize = specailize;
	}
	
}
