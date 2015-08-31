package com.food.pos.bean.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "com.food.pos.bean.converter.CodeConverter")
public class CodeConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) throws ConverterException {
		if (value.equals("O")) {
			return "外帶";
		}
		if (value.equals("I")) {
			return "內用";
		}
		// TODO Auto-generated method stub
		return value;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) throws ConverterException {
		if (value.equals("O")) {
			return "外帶";
		}
		if (value.equals("I")) {
			return "內用";
		}
		return (String) value;
	}

}
