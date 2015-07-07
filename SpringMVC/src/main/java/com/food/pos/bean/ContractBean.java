package com.food.pos.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import com.food.pos.dto.ContractDTO;
import com.food.pos.service.ContractService;

@ManagedBean
@RequestScoped
public class ContractBean implements Serializable {
	private transient ContractDTO dto;

	@ManagedProperty(value = "#{contractService}")
	private transient ContractService service;

	@PostConstruct
	public void init() {
		this.dto = new ContractDTO();
	}

	public void sendMail() {
		dto.setFrom("wa.addi@gmail.com");
		dto.setTo("wa.addi@gmail.com");
		dto.setSubject("ABC");
		dto.setMsg("MESSAGE");
		this.service.sendMail(dto);

	}

	public ContractDTO getDto() {
		return dto;
	}

	public void setDto(ContractDTO dto) {
		this.dto = dto;
	}

	public ContractService getService() {
		return service;
	}

	public void setService(ContractService service) {
		this.service = service;
	}

}
