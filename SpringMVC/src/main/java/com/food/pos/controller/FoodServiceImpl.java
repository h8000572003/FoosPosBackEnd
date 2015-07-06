package com.food.pos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.food.pos.dao.SampleDAO;
import com.food.pos.domain.SamplePO;
import com.food.pos.json.Bill;
import com.mkyong.common.model.Food;

@Service("foodService")
public class FoodServiceImpl implements FoodService {

	@Autowired
	private SampleDAO<Food> sampleDao;

	@Override
	public List<Bill> getNonBuy(FoodParmer parmer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(FoodParmer parmer) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(FoodParmer parmer) {
		// TODO Auto-generated method stub

	}

	@Override
	public void modify(FoodParmer parmer) {
		// TODO Auto-generated method stub

	}

}
