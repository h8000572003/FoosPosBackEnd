package com.food.pos.controller;

import java.util.ArrayList;
import java.util.List;

import org.omg.CORBA.PRIVATE_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.food.pos.contract.AeUtils;
import com.food.pos.dao.BillDAO;
import com.food.pos.dao.MealDAO;
import com.food.pos.dao.SampleDAO;
import com.food.pos.domain.BillPo;
import com.food.pos.domain.MealPo;
import com.food.pos.json.Bill;

@Component
public class BillCompentImpl implements BillCompent {

	@Autowired
	private BillDAO billDAO;

	@Autowired
	private MealDAO mealPoDAO;

	@Override
	public List<Bill> getTodayUnBuyBill() {

		final List<Bill> bills = new ArrayList<Bill>();
		List<BillPo> BillPos = billDAO.findTodayUnBuy(AeUtils.getNowTime());

		for (BillPo po : BillPos) {
			List<MealPo> meals = mealPoDAO.findMealsByBillId(po.getTxId());

			final Bill bill = new Bill();
			bill.setBill(po);
			bill.setMeals(meals);
			bills.add(bill);
		}

		return bills;
	}

	@Override
	public List<Bill> findTodayUnBuyAndNoSpeakOut(String date) {
		final List<Bill> bills = new ArrayList<Bill>();
		List<BillPo> BillPos = billDAO.findTodayUnBuyAndNoSpeakOut(date);

		for (BillPo po : BillPos) {
			List<MealPo> meals = mealPoDAO.findMealsByBillId(po.getTxId());

			final Bill bill = new Bill();
			bill.setBill(po);
			bill.setMeals(meals);
			bills.add(bill);
		}

		return bills;
	}
	@Override
	public List<Bill> findTodayUnBuyAndIsSpeakOut(String date) {
		final List<Bill> bills = new ArrayList<Bill>();
		List<BillPo> BillPos = billDAO.findTodayUnBuyAndSpeakOut(date);

		for (BillPo po : BillPos) {
			List<MealPo> meals = mealPoDAO.findMealsByBillId(po.getTxId());

			final Bill bill = new Bill();
			bill.setBill(po);
			bill.setMeals(meals);
			bills.add(bill);
		}

		return bills;
	}


	@Override
	@Transactional
	public void update2Pay(String txId) {
		List<BillPo> billPos = billDAO.findBillByTxId(txId);
		for (BillPo billPo : billPos) {
			billPo.setIsPaid("Y");
			billDAO.update(billPo);
		}

	}

	@Override
	@Transactional
	public void insert(Bill bill) {

		billDAO.create(bill.getBill());
		for (MealPo meal : bill.getMeals()) {
			billDAO.create(meal);
		}

	}

	@Override
	@Transactional
	public void deleteTotal() {
		final List<BillPo> bills = billDAO.findToday(AeUtils.getNowTime());
		for (BillPo po : bills) {
			List<MealPo> meals = mealPoDAO.findMealsByBillId(po.getTxId());
			billDAO.delete(po);
			for (MealPo meal : meals) {
				mealPoDAO.delete(meal);
			}

		}

	}

	@Override
	@Transactional
	public void updateIsSpeakOut(String txId, String value) {
		final List<BillPo> bills = billDAO.findBillByTxId(txId);
		for (BillPo bill : bills) {
			bill.setIsSpeakOut(value);
			billDAO.update(bill);
		}

	}

	@Override
	@Transactional
	public void updateIsMealOut(String txId, String value) {
		final List<BillPo> bills = billDAO.findBillByTxId(txId);
		for (BillPo bill : bills) {
			bill.setIsMealOut(value);
			billDAO.update(bill);
		}

	}

	@Override
	@Transactional
	public void updateIsPay(String txId, String value) {
		final List<BillPo> bills = billDAO.findBillByTxId(txId);
		for (BillPo bill : bills) {
			bill.setIsPaid(value);
			billDAO.update(bill);
		}

	}

	@Override
	@Transactional
	public void updateSeat(String txId, String value) {
		final List<BillPo> bills = billDAO.findBillByTxId(txId);
		for (BillPo bill : bills) {
			bill.setSeat(value);
			billDAO.update(bill);
		}

	}


}
