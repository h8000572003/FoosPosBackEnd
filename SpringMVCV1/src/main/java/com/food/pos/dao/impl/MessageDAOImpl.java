package com.food.pos.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;

import com.food.pos.dao.MealDAO;
import com.food.pos.dao.MessageDAO;
import com.food.pos.domain.MealPo;
import com.food.pos.domain.MessagePo;

@Repository
public class MessageDAOImpl extends BaseDAOHibernate<MessagePo> implements MessageDAO {

	@Override
	public List<MessagePo> findFirstTen() {
		Criteria criteria = getSession().createCriteria(MessagePo.class);
		criteria.setMaxResults(10);
		criteria.addOrder(Order.asc("id"));
		return criteria.list();
	}

}
