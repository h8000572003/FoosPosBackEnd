package com.food.pos.dao;

import java.util.List;

import com.food.pos.domain.MealPo;
import com.food.pos.domain.MessagePo;

public interface MessageDAO extends GenericDAO<MessagePo> {
	public List<MessagePo> findFirstTen();

}
