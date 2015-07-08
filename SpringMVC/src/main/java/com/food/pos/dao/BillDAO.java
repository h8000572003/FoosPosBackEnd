package com.food.pos.dao;

import java.util.List;

import com.food.pos.domain.BillPo;

public interface BillDAO extends GenericDAO<BillPo> {
	/**
	 * 取得今天尚未結單與出菜清單
	 * 
	 * @param date
	 * @return
	 */
	public List<BillPo> findTodayUnBuy(String date);

	public List<BillPo> findTodayUnBuyAndNoSpeakOut(String date);

	public List<BillPo> findTodayUnBuyAndSpeakOut(String date);

	public List<BillPo> findToday(String date);

	public List<BillPo> findBillByTxId(String txId);

	public List<BillPo> findBillByLikeDate(String date);

}
