package com.food.pos.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.food.pos.contract.AeUtils;
import com.food.pos.dto.BillBeanDTO;
import com.food.pos.json.Bill;
import com.food.pos.service.BillService;

/**
 * 檢視現有菜單
 * 
 * @author 1109001
 *
 */
@ManagedBean(name = "billBean", eager = false)
@ViewScoped
public class BillBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BillBeanDTO dto = new BillBeanDTO();

	private static Logger LOG = LoggerFactory.getLogger(BillBean.class);

	@ManagedProperty(value = "#{billService}")
	private transient BillService service;

	@PostConstruct
	public void init() {
		this.dto = new BillBeanDTO();
		this.dto.setYyyymmdd(AeUtils.getNowDate());
		this.doQuery();
	}

	public void selectBill(Bill bill) {
		dto.setSelectBill(bill);
	}

	public void convert2History() {

		this.service.convert2History(dto);
	}

	public BillBeanDTO getDto() {
		return dto;
	}

	public void setDto(BillBeanDTO dto) {
		this.dto = dto;
	}

	public String doQuery() {

		service.query(dto);
		LOG.info("doQuery end..");
		return null;

	}

	public BillService getService() {
		return service;
	}

	public void setService(BillService service) {
		this.service = service;
	}

}
