package com.food.pos.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.food.pos.dto.SettingFeatureDTO;
import com.food.pos.dto.SettingFeatureResultDTO;
import com.food.pos.service.SettingFeatureService;

@ManagedBean
@ViewScoped
public class SettingFeatureBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private SettingFeatureDTO dto;

	@ManagedProperty(value = "#{settingFeatureService}")
	private transient SettingFeatureService service;

	@PostConstruct
	public void init() {
		this.dto = new SettingFeatureDTO();
		this.service.loadAllFeatures(dto);
	}

	public SettingFeatureDTO getDto() {
		return dto;
	}

	public void setDto(SettingFeatureDTO dto) {
		this.dto = dto;
	}

	public String saveFeatures() {
		this.service.saveFeatures(dto);
		this.setDto(new SettingFeatureDTO());

		this.service.loadAllFeatures(dto);

		FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, "新增成功", null);
		FacesContext.getCurrentInstance().addMessage(null, facesMsg);
		return null;
	}

	public SettingFeatureService getService() {
		return service;
	}

	public void setService(SettingFeatureService service) {
		this.service = service;
	}

	public String addTenColumns() {
		for (int i = 0; i < 5; i++) {
			this.getDto().getResults().add(new SettingFeatureResultDTO());
		}
		return null;
	}

}
