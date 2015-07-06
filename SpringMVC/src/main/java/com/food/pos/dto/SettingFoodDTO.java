package com.food.pos.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import net.bootsfaces.render.E;

public class SettingFoodDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<SettingFoodItem> items = new ArrayList<SettingFoodItem>();

	public List<SettingFoodItem> getItems() {
		return items;
	}

	public void setItems(List<SettingFoodItem> items) {
		this.items = items;
	}
	
	
}
