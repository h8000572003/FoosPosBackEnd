package com.food.pos.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.food.pos.controller.GCMController;
import com.food.pos.dto.PosMessageForPhoneDTO;
import com.food.pos.service.PosMessagePhoneService;

@ManagedBean
@ViewScoped
public class PosMessageForPhoneBean implements Serializable {
	
	private Logger LOG = LoggerFactory.getLogger(PosMessageForPhoneBean.class);
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private PosMessageForPhoneDTO dto = new PosMessageForPhoneDTO();

	@ManagedProperty(value = "#{posMessagePhoneService}")
	private transient PosMessagePhoneService service;

	@PostConstruct
	public void init() {
		this.dto = new PosMessageForPhoneDTO();

		this.service.queryAllDevice(dto);

	}

	public String posMessage() {

		this.service.post(dto);
		FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO,
				"訊息已發送", null);
		FacesContext.getCurrentInstance().addMessage(null, facesMsg);

		return null;
	}

	public PosMessageForPhoneDTO getDto() {
		return dto;
	}

	public void setDto(PosMessageForPhoneDTO dto) {
		this.dto = dto;
	}

	public PosMessagePhoneService getService() {
		return service;
	}

	public void setService(PosMessagePhoneService service) {
		this.service = service;
	}
	
	
}
