package com.food.pos.dto;

import java.io.Serializable;

public class ToOrderFoodDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private int dollar = 0;

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

	
}
