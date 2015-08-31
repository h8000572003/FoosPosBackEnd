package com.food.pos.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.food.pos.dao.BillDAO;
import com.food.pos.domain.BillPo;

@Repository
public class BillDAOImpl extends BaseDAOHibernate<BillPo> implements BillDAO {

	private static final Logger LOG = LoggerFactory
			.getLogger(SampleDAOImpl.class);

	@Override
	public List<BillPo> findTodayUnBuy(String date) {
		Criteria criteria = getSession().createCriteria(BillPo.class);
		criteria.addOrder(Order.asc("txId"));
		criteria.add(Restrictions.or(
				//
				Restrictions.ne("isPaid", "Y"),
				Restrictions.ne("isMealOut", "Y")));
		criteria.add(Restrictions.eq("orderDate", date));
		return criteria.list();

	}

	public List<BillPo> findBillByTxId(String txid) {
		Criteria criteria = getSession().createCriteria(BillPo.class);

		criteria.add(Restrictions.eq("txId", txid));

		return criteria.list();
	}

	@Override
	public List<BillPo> findToday(String date) {
		Criteria criteria = getSession().createCriteria(BillPo.class);
		criteria.addOrder(Order.asc("txId"));

		criteria.add(Restrictions.eq("orderDate", date));

		return criteria.list();
	}

	/**
	 * 取得[日期下]尚未叫餐帳單
	 */
	@Override
	public List<BillPo> findTodayUnBuyAndNoSpeakOut(String date) {
		Criteria criteria = getSession().createCriteria(BillPo.class);
		criteria.addOrder(Order.asc("txId"));
		criteria.add(Restrictions.or(
				//
				Restrictions.ne("isPaid", "Y"),
				Restrictions.ne("isMealOut", "Y")));
		criteria.add(Restrictions.eq("orderDate", date));
		criteria.add(Restrictions.eq("isSpeakOut", "N"));
		return criteria.list();
	}

	@Override
	public List<BillPo> findTodayUnBuyAndSpeakOut(String date) {
		Criteria criteria = getSession().createCriteria(BillPo.class);
		criteria.addOrder(Order.asc("txId"));
		criteria.add(Restrictions.or(
				//
				Restrictions.ne("isPaid", "Y"),
				Restrictions.ne("isMealOut", "Y")));
		criteria.add(Restrictions.eq("orderDate", date));
		criteria.add(Restrictions.eq("isSpeakOut", "Y"));
		return criteria.list();
	}

	@Override
	public List<BillPo> findBillByLikeDate(String date) {
		Criteria criteria = getSession().createCriteria(BillPo.class);
		criteria.addOrder(Order.asc("txId"));

		criteria.add(Restrictions.like("orderDate", date + "%"));
		return criteria.list();
	}
}
