package com.food.pos.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.food.pos.dao.HistoryBillDAO;
import com.food.pos.domain.BillPo;
import com.food.pos.domain.HistoryBillPo;


@Repository
public class HistoryBillDAOImpl extends BaseDAOHibernate<HistoryBillPo>
		implements HistoryBillDAO {

}
