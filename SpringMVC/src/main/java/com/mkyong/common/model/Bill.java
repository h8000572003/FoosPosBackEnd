package com.mkyong.common.model;

import java.util.ArrayList;
import java.util.List;

public class Bill {
	private String seq = "";
	private List<Food> foodList = new ArrayList<Food>();

	public List<Food> getFoodList() {
		return foodList;
	}

	public void setFoodList(List<Food> foodList) {
		this.foodList = foodList;
	}

	public String getSeq() {
		return seq;
	}

	public void setSeq(String seq) {
		this.seq = seq;
	}

}
