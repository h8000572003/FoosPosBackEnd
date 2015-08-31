package com.food.pos.contract;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * setting.properties 檔案系統位置
 * 
 * @author 1109001
 *
 */
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
	
	@Value("${share.report.path}")
	private String report="";
	
	@Value("${temp.report.path}")
	private String tmpReport="";

	public String getReport() {
		return report;
	}

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

	public String getTmpReport() {
		return tmpReport;
	}

}
