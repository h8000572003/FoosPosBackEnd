package com.food.pos.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SettingFeatureDTO implements Serializable {
	private List<SettingFeatureResultDTO> results=new ArrayList<SettingFeatureResultDTO>();

	public List<SettingFeatureResultDTO> getResults() {
		return results;
	}

	public void setResults(List<SettingFeatureResultDTO> results) {
		this.results = results;
	}
	
	
}
