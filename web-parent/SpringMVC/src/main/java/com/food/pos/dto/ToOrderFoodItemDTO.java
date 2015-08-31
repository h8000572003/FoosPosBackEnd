package com.food.pos.dto;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.util.StringUtil;

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

	@Override
	public boolean equals(Object obj) {

		if (obj instanceof ToOrderFoodItemDTO) {
			ToOrderFoodItemDTO select = (ToOrderFoodItemDTO) obj;
			if (StringUtils.equals(select.getName(), getName())
					&& StringUtils.equals(select.getSpecailize(),
							getSpecailize())) {
				return true;
			}
		}
		// TODO Auto-generated method stub
		return super.equals(obj);
	}
}
