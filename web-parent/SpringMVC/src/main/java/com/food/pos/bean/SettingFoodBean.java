package com.food.pos.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.commons.lang3.StringUtils;

import com.food.pos.dto.SettingFoodDTO;
import com.food.pos.dto.SettingFoodItem;
import com.food.pos.service.SettingFoodService;

@ManagedBean
@ViewScoped
public class SettingFoodBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SettingFoodDTO dto = new SettingFoodDTO();

	@ManagedProperty(value = "#{settingFoodService}")
	private transient SettingFoodService service;

	private boolean isValidity = false;

	@PostConstruct
	public void init() {
		this.dto = new SettingFoodDTO();
		this.service.findAllFoods(dto);
	}

	public SettingFoodDTO getDto() {
		return dto;
	}

	public void setDto(SettingFoodDTO dto) {
		this.dto = dto;
	}

	public SettingFoodService getService() {
		return service;
	}

	public void setService(SettingFoodService service) {
		this.service = service;
	}

	public String doQuery() {
		this.service.findAllFoods(dto);
		return null;
	}

	public String validity() {
		this.isValidity = false;
		for (SettingFoodItem food : dto.getItems()) {

			if (StringUtils.isNotBlank(food.getName())
					&& StringUtils.isBlank(food.getDollar())) {
				FacesMessage facesMsg = new FacesMessage(
						FacesMessage.SEVERITY_WARN, "金額需填寫", null);
				FacesContext.getCurrentInstance().addMessage(null, facesMsg);
			}
		}
		this.isValidity = true;
		return null;
	}

	public String updateFoods() {
		this.service.saveFoods(dto);

		FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO,
				"新增成功", null);
		FacesContext.getCurrentInstance().addMessage(null, facesMsg);

		return null;
	}

	public String addTenColumns() {
		for (int i = 0; i < 10; i++) {
			dto.getItems().add(new SettingFoodItem());
		}
		return null;
	}

	public boolean isValidity() {
		return isValidity;
	}

	public void setValidity(boolean isValidity) {
		this.isValidity = isValidity;
	}
	
	
}
