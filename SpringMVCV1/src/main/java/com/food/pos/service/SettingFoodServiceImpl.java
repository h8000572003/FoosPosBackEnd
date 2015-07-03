package com.food.pos.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.food.pos.dao.SampleDAO;
import com.food.pos.domain.FoodPo;
import com.food.pos.dto.SettingFoodDTO;
import com.food.pos.dto.SettingFoodItem;

@Service("settingFoodService")
public class SettingFoodServiceImpl implements SettingFoodService {

	private static Logger LOG = LoggerFactory.getLogger(BillServiceImpl.class);

	@Autowired
	private SampleDAO<FoodPo> sampleDao;

	@Override
	@Transactional
	public void saveFoods(SettingFoodDTO dto) {
		List foods = sampleDao.findAll(FoodPo.class);
		sampleDao.deleteAll(foods);
		Long i = 0L;
		for (SettingFoodItem food : dto.getItems()) {
			
			if (StringUtils.isNotBlank(food.getName())
					&& StringUtils.isNotBlank(food.getDollar())) {
				FoodPo foodPo = new FoodPo();
				foodPo.setId(i);
				foodPo.setName(food.getName());
				foodPo.setDollar(food.getDollar());
				sampleDao.create(foodPo);
				i++;
			}
		}

	}

	@Override
	public void findAllFoods(SettingFoodDTO dto) {
		List<FoodPo> foods = sampleDao.findAll(FoodPo.class);

		dto.getItems().clear();
		for (FoodPo food : foods) {
			final SettingFoodItem foodPo = new SettingFoodItem();
			foodPo.setName(food.getName());
			foodPo.setDollar(food.getDollar());
			dto.getItems().add(foodPo);
		}

	}
}
