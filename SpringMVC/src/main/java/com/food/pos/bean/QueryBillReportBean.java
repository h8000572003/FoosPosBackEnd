package com.food.pos.bean;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.food.pos.contract.AeUtils;
import com.food.pos.dto.QueryBillReporDTO;
import com.food.pos.service.QueryBillReportService;

@ManagedBean
@ViewScoped
public class QueryBillReportBean implements Serializable {

	private static Logger LOG = LoggerFactory
			.getLogger(QueryBillReportBean.class);

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private QueryBillReporDTO dto = new QueryBillReporDTO();

	private StreamedContent file;

	@ManagedProperty(value = "#{queryBillReportService}")
	private transient QueryBillReportService service;

	@PostConstruct
	public void init() {
		this.dto = new QueryBillReporDTO();
		this.dto.setYyyy(AeUtils.getNowYear());
	}

	public QueryBillReporDTO getDto() {
		return dto;
	}

	public void setDto(QueryBillReporDTO dto) {
		this.dto = dto;
	}

	public void doQuery() {

		try {
			File fo = new File("/POS/tmp/xxx.txt");
			LOG.info(fo.getAbsolutePath());
			
			InputStream io = new FileInputStream(fo);
			file = new DefaultStreamedContent(io, "java/*", "xxx.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public String queryMonth() {
		return null;
	}

	public StreamedContent getFile() {
		return file;
	}

	public void setFile(StreamedContent file) {
		this.file = file;
	}

	public QueryBillReportService getService() {
		return service;
	}

	public void setService(QueryBillReportService service) {
		this.service = service;
	}

}
