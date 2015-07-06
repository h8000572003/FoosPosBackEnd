package com.mkyong.common.model;

public class Food {

	private String name = "";
	private int count = 0;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public Food(String name, int count) {
		super();
		this.name = name;
		this.count = count;
	}
	
	
	
}
