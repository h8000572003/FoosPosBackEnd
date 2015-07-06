package com.food.pos.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import net.bootsfaces.render.E;

public class ToOrderBillDTO implements Serializable {

	private List<ToOrderFoodDTO> foods = new ArrayList<ToOrderFoodDTO>();

	public List<ToOrderFoodDTO> getFoods() {
		return foods;
	}

	public void setFoods(List<ToOrderFoodDTO> foods) {
		this.foods = foods;
	}
	
	

}
