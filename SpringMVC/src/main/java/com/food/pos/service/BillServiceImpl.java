package com.food.pos.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.food.pos.contract.AeUtils;
import com.food.pos.controller.BillCompent;
import com.food.pos.domain.MealPo;
import com.food.pos.dto.BillBeanDTO;
import com.food.pos.json.Bill;

@Service("billService")
public class BillServiceImpl implements BillService {

	private static Logger LOG = LoggerFactory.getLogger(BillServiceImpl.class);

	@Autowired
	private BillCompent billCompent;

	private static final String OUT_EAT = "O";
	private static final String IN_EAT = "I";

	@Override
	public void query(BillBeanDTO dto) {

		dto.setYyyymmdd(AeUtils.getDate(dto.getQueryDate()));

		dto.getBills().clear();
		dto.getBills().addAll(billCompent.findAll(dto.getYyyymmdd()));
		LOG.info(ToStringBuilder.reflectionToString(dto.getBills()));

		this.setOutBill(dto);
		this.setInBill(dto);
	}

	private void setOutBill(BillBeanDTO dto) {

		dto.setOutBill(this.getTotalBill(OUT_EAT, dto.getBills()));

	}

	private Bill getTotalBill(String inOrOut, List<Bill> bills) {
		// 餐點 與 數量
		final Map<MealPo, Integer> map = new HashMap<MealPo, Integer>();
		final Bill topBill = new Bill();

		for (Bill bill : bills) {
			if (!bill.getBill().getOutOrIn().equals(inOrOut)) {
				continue;
			}
			for (MealPo meal : bill.getMeals()) {
				if (map.containsKey(meal)) {
					int nowNo = map.get(meal);
					map.put(meal, nowNo + Integer.parseInt(meal.getNumber()));
				} else {
					map.put(meal, Integer.parseInt(meal.getNumber()));
				}
			}

		}

		for (Entry<MealPo, Integer> data : map.entrySet()) {
			final MealPo mealPo = new MealPo();
			mealPo.setName(data.getKey().getName());
			mealPo.setNumber(data.getValue() + "");
			topBill.getMeals().add(mealPo);
		}
		return topBill;
	}

	private void setInBill(BillBeanDTO dto) {
		dto.setInBill(this.getTotalBill(IN_EAT, dto.getBills()));
	}

}
