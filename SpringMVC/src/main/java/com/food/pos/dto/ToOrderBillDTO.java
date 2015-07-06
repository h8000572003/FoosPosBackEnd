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

	private ToOrderFoodDTO selectFoodDTO = null;

	public List<ToOrderFoodDTO> getFoods() {
		return foods;
	}

	public void setFoods(List<ToOrderFoodDTO> foods) {
		this.foods = foods;
	}

	public ToOrderFoodDTO getSelectFoodDTO() {
		return selectFoodDTO;
	}

	public void setSelectFoodDTO(ToOrderFoodDTO selectFoodDTO) {
		this.selectFoodDTO = selectFoodDTO;
	}

	
}
