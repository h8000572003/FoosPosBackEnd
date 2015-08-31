package com.food.pos.service;

import com.food.pos.dto.SettingFoodDTO;

public interface SettingFoodService {
	public void saveFoods(SettingFoodDTO dto);

	public void findAllFoods(SettingFoodDTO dto);
}
