package com.food.pos.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.food.pos.dto.ShowMessagDTO;
import com.food.pos.service.ShowMessageService;

@ManagedBean
@ViewScoped
public class ShowMessageBean implements Serializable {

	private Logger LOG = LoggerFactory.getLogger(ShowMessageBean.class);

	private ShowMessagDTO dto = new ShowMessagDTO();
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{showMessageService}")
	private transient ShowMessageService service;

	@PostConstruct
	public void init() {
		LOG.debug("ShowMessageBean init");
		this.dto = new ShowMessagDTO();
		this.loadMessage();
	}

	public void loadMessage() {
		this.service.loadMessage(dto);
	}

	public ShowMessagDTO getDto() {
		return dto;
	}

	public void setDto(ShowMessagDTO dto) {
		this.dto = dto;
	}

	public ShowMessageService getService() {
		return service;
	}

	public void setService(ShowMessageService service) {
		this.service = service;
	}
	
	
}
