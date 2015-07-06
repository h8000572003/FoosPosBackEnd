package com.food.pos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.food.pos.dao.SampleDAO;
import com.food.pos.domain.FoodPo;
import com.food.pos.dto.ToOrderBillDTO;
import com.food.pos.dto.ToOrderFoodDTO;

@Service("toOrderBillService")
public class ToOrderBillServiceImpl implements ToOrderBillService {

	@Autowired
	private SampleDAO<FoodPo> sampleDao;

	@Override
	public void readData(ToOrderBillDTO dto) {

		final List<FoodPo> foods = sampleDao.findAll(FoodPo.class);

		dto.getFoods().clear();
		for (FoodPo food : foods) {
			final ToOrderFoodDTO foodDTO = new ToOrderFoodDTO();
			foodDTO.setName(food.getName());
			foodDTO.setDollar(Integer.parseInt(food.getDollar()));
			foodDTO.setNumber("");
			dto.getFoods().add(foodDTO);
		}

	}

	@Override
	public void sendBill(ToOrderBillDTO dto) {
		// TODO Auto-generated method stub

	}

}
