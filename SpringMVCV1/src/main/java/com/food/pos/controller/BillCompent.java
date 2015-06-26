package com.food.pos.controller;

import java.util.List;

import com.food.pos.domain.BillPo;
import com.food.pos.json.Bill;

public interface BillCompent {
	/**
	 * 取得今日尚未結帳與出菜完成清單
	 * 
	 * @return
	 */
	List<Bill> getTodayUnBuyBill();

	public List<Bill> findTodayUnBuyAndNoSpeakOut(String date);

	public List<Bill> findTodayUnBuyAndIsSpeakOut(String date);

	void updateIsSpeakOut(String txId, String value);

	void updateIsPay(String txId, String value);

	void updateSeat(String txId, String value);

	void updateIsMealOut(String txId, String value);

	void update2Pay(String txId);

	void insert(Bill bill);

	void deleteTotal();
}
