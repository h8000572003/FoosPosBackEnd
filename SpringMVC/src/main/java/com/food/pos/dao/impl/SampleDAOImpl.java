/*
 * Copyright (c) 2012. 資拓宏宇科技. All right reserved.
 */
package com.food.pos.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.food.pos.dao.SampleDAO;

/**
 * DAO實作類別範例，必須要繼承BaseDAOHibernate父類別，方可使用HibernateTemplate與Session
 * 
 * 補充說明：@Repository 
 * 只能標注在 DAO實作類別， 該注解的作用不只是將類識別為Spring Bean，
 * 同時它還能將所標注的類中拋出的數據訪問異常封裝為 Spring 的資料庫存取異常類型，
 * 用於封裝不同的持久層框架拋出的異常，使得異常獨立於底層的框架。
 * 
 * @author Administrator 
 * 在 2012/12/7 建立
 */
@Repository
public class SampleDAOImpl<T extends Object> extends BaseDAOHibernate<T> implements SampleDAO<T> {

    private static final Logger LOG = LoggerFactory.getLogger(SampleDAOImpl.class);
    
}

