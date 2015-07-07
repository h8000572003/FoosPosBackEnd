package com.food.pos.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
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
		this.service.sendBill(dto);
		this.dto = new ToOrderBillDTO();
		this.service.readData(dto);
		
		FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, "新增成功", null);
		FacesContext.getCurrentInstance().addMessage(null, facesMsg);
		return null;
	}

	public String remove(ToOrderFoodItemDTO select) {
		dto.getToOrderFoods().remove(select);
		return null;

	}

	public void toAdd() {

		ToOrderFoodItemDTO foodItem = new ToOrderFoodItemDTO();
		foodItem.setName(dto.getName());
		foodItem.setDollar(Integer.parseInt(dto.getDollar()));
		foodItem.setNumber(dto.getNumber());
		foodItem.setSpecailize(StringUtils.join(dto.getFeatureStringList(), ","));

		if (dto.getToOrderFoods().contains(foodItem)) {
			foodItem = dto.getToOrderFoods().get(
					dto.getToOrderFoods().indexOf(foodItem));
			foodItem.setNumber(Integer.parseInt(foodItem.getNumber())
					+ Integer.parseInt(dto.getNumber()) + "");
		} else {
			dto.getToOrderFoods().add(foodItem);
		}

	}

	public String changeValue() {
		for (ToOrderFoodDTO food : dto.getFoods()) {
			if (StringUtils.equals(food.getName(), dto.getName())) {
				dto.setDollar(food.getDollar() + "");
			}
		}
		return "";
	}

	public void count() {
		int total = 0;
		for (ToOrderFoodItemDTO item : dto.getToOrderFoods()) {
			total += item.getDollar() * Integer.parseInt(item.getNumber());
		}
		dto.setTotalMoney(total + "");
	}

	public void hasPay() {
		this.getDto().setPayied("Y");
	}
}
