package com.food.pos.service;

import com.food.pos.dto.SettingFeatureDTO;

public interface SettingFeatureService {
	void loadAllFeatures(SettingFeatureDTO dto);

	void saveFeatures(SettingFeatureDTO dto);
}
