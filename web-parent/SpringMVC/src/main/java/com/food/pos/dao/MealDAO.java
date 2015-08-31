package com.food.pos.dao;

import java.util.List;

import com.food.pos.domain.MealPo;

public interface MealDAO extends GenericDAO<MealPo> {
	public List<MealPo> findMealsByBillId(String billId);

}
