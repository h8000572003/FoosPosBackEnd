package com.food.pos.contract;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PosSystemConfig {
	@Value("${system.id}")
	private String SysyemId;

	@Value("${config.path}")
	private String config;

	@Value("${share.path}")
	private String share;

	@Value("${temp.path}")
	private String temp;

	public String getSysyemId() {
		return SysyemId;
	}

	public String getConfig() {
		return config;
	}

	public String getShare() {
		return share;
	}

	public String getTemp() {
		return temp;
	}

}
