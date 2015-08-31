package com.food.pos.json;

import java.util.ArrayList;
import java.util.List;

import com.food.pos.domain.BillPo;
import com.food.pos.domain.MealPo;

public class Bill {
	private BillPo bill;
	private List<MealPo> meals = new ArrayList<MealPo>();
	public BillPo getBill() {
		return bill;
	}
	public void setBill(BillPo bill) {
		this.bill = bill;
	}
	public List<MealPo> getMeals() {
		return meals;
	}
	public void setMeals(List<MealPo> meals) {
		this.meals = meals;
	}
	
	
}
