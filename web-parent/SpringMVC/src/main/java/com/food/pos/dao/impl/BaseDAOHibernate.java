package com.food.pos.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import com.food.pos.dao.GenericDAO;


/**
 * Copyright (c) 2012 IISIGROUP All Rights Reserved.
 * 
 * 負責底層Hibernate持久層DAO處理介面。
 * 
 * 補充說明：@Component 是一個泛化的概念，僅表示一個組件 (Bean)
 * 
 * @author tbs
 * @param <T>
 * @date 2012/12/4
 */
@Repository
public class BaseDAOHibernate<T> extends HibernateDaoSupport implements GenericDAO<T> {

	@Autowired
	public final void init(final SessionFactory factory) {
		setSessionFactory(factory);
	}

	private Class<T> entityClass;

	@SuppressWarnings("unchecked")
	public BaseDAOHibernate() {
		this.entityClass = GenericsUtils.getSuperClassGenricType(getClass(), 0);
	}

	public final Class<T> getEntityClass() {
		return this.entityClass;
	}

	/**
	 * @param entityClass
	 *            要設定的 entityClass。
	 */
	public final void setEntityClass(final Class<T> entityClass) {
		this.entityClass = entityClass;
	}

	@Override
	public final List<T> findAll(final Class<T> entityClass) {
		return getHibernateTemplate().loadAll(entityClass);
	}

	@SuppressWarnings("unchecked")
	public final List<T> findAll(final Class<T> entityClass, final String orderBy, final boolean isAsc) {
		Assert.hasText(orderBy);
		if (isAsc) {
			return getHibernateTemplate().findByCriteria(DetachedCriteria.forClass(entityClass).addOrder(Order.asc(orderBy)));
		} else {
			return getHibernateTemplate().findByCriteria(DetachedCriteria.forClass(entityClass).addOrder(Order.desc(orderBy)));
		}
	}

	@Override
	public final T findById(final Serializable id) {
		return (T) getHibernateTemplate().get(this.entityClass, id);
	}

	@Override
	public final void deleteById(final Serializable id) {
		delete(this.findById(id));
	}

	@Override
	public final void delete(final Object o) {
		getHibernateTemplate().delete(o);
	}

	@Override
	public final void create(final Object o) {
		getHibernateTemplate().save(o);
	}

	@Override
	public final void createOrUpdate(final Object o) {
		getHibernateTemplate().saveOrUpdate(o);
	}

	@Override
	public final void update(final Object o) {
		getHibernateTemplate().update(o);
	}

	@Override
	public final void flush() {
		getHibernateTemplate().flush();
		getHibernateTemplate().clear();
	}

	@Override
	public final void createAll(final List<Object> entities) {
		for (Object entity : entities) {
			getHibernateTemplate().save(entity);
		}
	}

	@Override
	public final void updateAll(final List<Object> entities) {
		for (Object entity : entities) {
			getHibernateTemplate().update(entity);
		}
	}

	@Override
	public final void createOrUpdateAll(final List<Object> entities) {
		getHibernateTemplate().saveOrUpdateAll(entities);
	}

	@Override
	public final void deleteAll(final List<Object> entities) {
		getHibernateTemplate().deleteAll(entities);
	}

	@Override
	public final List<T> findByExample(final Object o) {
		return getHibernateTemplate().findByExample(o);
	}
}
