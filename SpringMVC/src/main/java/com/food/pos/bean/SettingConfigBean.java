package com.food.pos.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.food.pos.dto.SettingConfigDTO;
import com.food.pos.service.SettingConfigService;

@ManagedBean
@ViewScoped
public class SettingConfigBean implements Serializable {
	private Logger LOG = LoggerFactory.getLogger(SettingConfigBean.class);

	private SettingConfigDTO dto = new SettingConfigDTO();

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{settingConfigService}")
	private transient SettingConfigService service;

	@PostConstruct
	public void init() {
		
		LOG.debug("SettingConfigBean init...");
		dto = new SettingConfigDTO();
		this.service.load(dto);
	}

	public SettingConfigDTO getDto() {
		return dto;
	}

	public void setDto(SettingConfigDTO dto) {
		this.dto = dto;
	}

	public SettingConfigService getService() {
		return service;
	}

	public void setService(SettingConfigService service) {
		this.service = service;
	}

}
