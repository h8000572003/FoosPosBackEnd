package com.food.pos.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

import org.apache.commons.lang3.StringUtils;

import com.food.pos.dto.ToOrderBillDTO;
import com.food.pos.dto.ToOrderFoodDTO;
import com.food.pos.dto.ToOrderFoodItemDTO;
import com.food.pos.service.ToOrderBillService;

@ManagedBean
@ViewScoped
public class ToOrderBillBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ToOrderBillDTO dto = new ToOrderBillDTO();

	@ManagedProperty(value = "#{toOrderBillService}")
	private transient ToOrderBillService service;

	@PostConstruct
	public void init() {
		this.dto = new ToOrderBillDTO();
		this.service.readData(dto);

	}

	public ToOrderBillDTO getDto() {
		return dto;
	}

	public void setDto(ToOrderBillDTO dto) {
		this.dto = dto;
	}

	public ToOrderBillService getService() {
		return service;
	}

	public void setService(ToOrderBillService service) {
		this.service = service;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String toSend() {
		return "";
	}

	public String remove(ToOrderFoodItemDTO select) {
		dto.getToOrderFoods().remove(select);
		return null;
		
	}

	public String toAdd() {

		ToOrderFoodItemDTO foodItem = new ToOrderFoodItemDTO();
		foodItem.setName(dto.getName());
		foodItem.setDollar(Integer.parseInt(dto.getDollar()));
		foodItem.setNumber(dto.getNumber());
		foodItem.setSpecailize(StringUtils.join(dto.getFeatureStringList(), ","));

		dto.getToOrderFoods().add(foodItem);
		return null;
	}

	public String changeValue() {
		for (ToOrderFoodDTO food : dto.getFoods()) {
			if (StringUtils.equals(food.getName(), dto.getName())) {
				dto.setDollar(food.getDollar() + "");
			}
		}
		return "";
	}

}
