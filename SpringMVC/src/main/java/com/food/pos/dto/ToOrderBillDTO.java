package com.food.pos.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import net.bootsfaces.render.E;

public class ToOrderBillDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<ToOrderFoodDTO> foods = new ArrayList<ToOrderFoodDTO>();

	private String name = "";
	private String dollar = "";
	private String number = "";

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

	

}
