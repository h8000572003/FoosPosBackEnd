package com.food.pos.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class FacesContextUtil {

	public static FacesMessage addMessage(String message,
			FacesMessage.Severity severity) {
		FacesMessage facesMsg = new FacesMessage(severity, message, null);
		FacesContext.getCurrentInstance().addMessage(null, facesMsg);
		return facesMsg;
	}

	public static FacesMessage addInfoMessage(String message) {
		return addMessage(message, FacesMessage.SEVERITY_INFO);
	}
	public static FacesMessage adWarmMessage(String message) {
		return addMessage(message, FacesMessage.SEVERITY_WARN);
	}
	public static FacesMessage adErrorMessage(String message) {
		return addMessage(message, FacesMessage.SEVERITY_ERROR);
	}

}
