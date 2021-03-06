package com.food.pos.bean;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.FileUploadEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.food.pos.contract.AeUtils;
import com.food.pos.contract.PosSystemConfig;
import com.food.pos.dto.PosMessageDTO;
import com.food.pos.service.PosMessageService;

@ManagedBean
@ViewScoped
public class PosMessageBean implements Serializable {
	private Logger LOG = LoggerFactory.getLogger(PosMessageForPhoneBean.class);
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private PosMessageDTO dto = new PosMessageDTO();

	private boolean isModify = false;

	@ManagedProperty(value = "#{posMessageService}")
	private transient PosMessageService service;

	private boolean isLock = true;

	@ManagedProperty(value = "#{posSystemConfig}")
	private transient PosSystemConfig posSystemConfig;

	@PostConstruct
	public void init() {
		this.dto = new PosMessageDTO();

		this.service.loadMessage(dto);
	}

	public String beginModify() {
		this.isModify = true;
		return null;
	}

	public void handleFileUpload(FileUploadEvent event) {

		File f = new File(event.getFile().getFileName());
		this.dto.getAddPostMessage().setPath(f.getPath());
		try {

			InputStream in = event.getFile().getInputstream();
			OutputStream out = new FileOutputStream(f);
			int read = 0;
			byte[] bytes = new byte[1024];

			while ((read = in.read(bytes)) != -1) {
				out.write(bytes, 0, read);
			}

			in.close();
			out.flush();
			out.close();

		} catch (Exception e) {
			LOG.error("e={}", e);
		}

	}

	public void insertNewMessageWhen2Query() {

		dto.getAddPostMessage().setCreateDate(AeUtils.getShowDate());
		dto.getAddPostMessage().setCreateTime(AeUtils.getNowShowTime());

		this.service.insertNewMessageWhen2Query(dto);

		FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO,
				"完成", null);
		FacesContext.getCurrentInstance().addMessage(null, facesMsg);

	}

	public String modify2Query() {
		this.service.modify2Query(dto);
		this.isModify = false;

		FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO,
				"修改完成", null);
		FacesContext.getCurrentInstance().addMessage(null, facesMsg);
		return null;
	}

	public String delete2Query() {

		this.service.delete2Query(dto);
		this.isModify = false;
		FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO,
				"刪除完成", null);
		FacesContext.getCurrentInstance().addMessage(null, facesMsg);
		return null;

	}

	public void unLock() {
		this.isLock = false;
	}

	public String cancel() {
		this.isModify = false;
		this.dto = new PosMessageDTO();
		this.service.loadMessage(dto);
		return null;
	}

	public PosMessageDTO getDto() {
		return dto;
	}

	public void setDto(PosMessageDTO dto) {
		this.dto = dto;
	}

	public boolean isModify() {
		return isModify;
	}

	public void setModify(boolean isModify) {
		this.isModify = isModify;
	}

	public PosMessageService getService() {
		return service;
	}

	public void setService(PosMessageService service) {
		this.service = service;
	}

	public Logger getLOG() {
		return LOG;
	}

	public void setLOG(Logger lOG) {
		LOG = lOG;
	}

	public boolean isLock() {
		return isLock;
	}

	public void setLock(boolean isLock) {
		this.isLock = isLock;
	}

	public PosSystemConfig getPosSystemConfig() {
		return posSystemConfig;
	}

	public void setPosSystemConfig(PosSystemConfig posSystemConfig) {
		this.posSystemConfig = posSystemConfig;
	}

}
