package com.food.pos.controller;

import java.util.List;

import com.food.pos.json.Bill;

public interface FoodService {
	public List<Bill> getNonBuy(FoodParmer parmer);

	public void insert(FoodParmer parmer);

	public void delete(FoodParmer parmer);

	public void modify(FoodParmer parmer);

}
