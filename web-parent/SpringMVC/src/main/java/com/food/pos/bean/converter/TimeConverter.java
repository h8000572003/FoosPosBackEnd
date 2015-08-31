package com.food.pos.bean.converter;

import java.util.ArrayList;
import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@FacesConverter("com.food.pos.bean.converter.TimeConverter")
public class TimeConverter implements Converter {

	private static Logger LOG = LoggerFactory.getLogger(TimeConverter.class);

	private int[] words = new int[] { 2, 2, 2 };

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) throws ConverterException {
		if (value == null) {
			return null;
		}
		if (value.length() != 6) {
			return value;
		}
		if (value.matches("\\d{6}")) {
			return value;
		}
		if (value.matches("\\d{2}:\\d{2}:\\d{2}")) {
			return value.replaceAll(":", "");
		}

		return value;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) throws ConverterException {

		if (value instanceof String) {
			String str = (String) value;
			if (str.matches("[0-9]{6}")) {
				List<String> parts = new ArrayList<String>();

				String tmp = str;
				for (int word : words) {
					parts.add(tmp.substring(0, word));
					tmp = tmp.substring(word);
				}
				return StringUtils.join(parts, ":");
			} else {
				return str;
			}

		}

		return (String) value;
	}

}
