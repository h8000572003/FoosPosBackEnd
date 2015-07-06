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
import org.apache.poi.util.StringUtil;

import com.food.pos.dto.ToOrderBillDTO;
import com.food.pos.dto.ToOrderFoodDTO;
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

	private class TestConverter implements Converter {

		@Override
		public Object getAsObject(FacesContext arg0, UIComponent arg1,
				String arg2) throws ConverterException {

			for (ToOrderFoodDTO food : dto.getFoods()) {
				if (StringUtils.equals(arg2, food.getName())) {
					return arg2;
				}
			}
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public String getAsString(FacesContext arg0, UIComponent arg1,
				Object arg2) throws ConverterException {
			// TODO Auto-generated method stub
			return null;
		}

	}

	public TestConverter getFakeConverter() {
		return new TestConverter();
	}
}
