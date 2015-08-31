package com.food.pos.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.food.pos.dao.SeqNoDAO;
import com.food.pos.domain.MealPo;
import com.food.pos.domain.SeqNoPo;

@Repository
public class SeqNoDAOImpl extends BaseDAOHibernate<SeqNoPo> implements SeqNoDAO {

	private static final Logger LOG = LoggerFactory
			.getLogger(MealDAOImpl.class);

	@Override
	public List<SeqNoPo> getSeqNo(String date) {

		Criteria criteria = getSession().createCriteria(SeqNoPo.class);
		criteria.add(Restrictions.eq("date", date));

		criteria.addOrder(Order.desc("seq"));

		// TODO Auto-generated method stub
		return criteria.list();
	}
}
