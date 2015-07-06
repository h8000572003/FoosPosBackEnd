package com.food.pos.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.food.pos.dao.MealDAO;
import com.food.pos.domain.BillPo;
import com.food.pos.domain.MealPo;

@Repository
public class MealDAOImpl extends BaseDAOHibernate<MealPo> implements MealDAO {

	private static final Logger LOG = LoggerFactory
			.getLogger(MealDAOImpl.class);

	@Override
	public List<MealPo> findMealsByBillId(String billId) {
		Criteria criteria = getSession().createCriteria(MealPo.class);
		criteria.add(Restrictions.eq("txId", billId));

		return criteria.list();
	}

}
