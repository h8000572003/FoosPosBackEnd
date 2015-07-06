/*
 * Copyright (c) 2012. 資拓宏宇科技. All right reserved.
 */
package com.food.pos.dao;

import java.io.Serializable;
import java.util.List;

/**
 * 泛型DAO介面 ref：Hibernate Generic D.A.O.
 * Framework(http://code.google.com/p/hibernate-generic-dao)
 * exp：http://www.cnblogs.com/xwdreamer/archive/2011/12/25/2300986.html
 * 
 * @author jackey.wu 在 2012/12/22 建立
 */
public interface GenericDAO<T> {

	void setEntityClass(final Class<T> entityClass);

	void create(final Object entity);

	void createAll(final List<Object> entities);

	void update(final Object entity);

	void updateAll(final List<Object> entities);

	void createOrUpdate(final Object entity);

	void createOrUpdateAll(final List<Object> entities);

	void delete(final Object entity);

	void deleteById(final Serializable id);

	void deleteAll(final List<Object> entities);

	T findById(final Serializable id);

	List<T> findAll(final Class<T> entityClass);

	List<T> findByExample(final Object o);

	void flush();
	// ...

}
