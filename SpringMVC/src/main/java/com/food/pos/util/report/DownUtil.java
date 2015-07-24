package com.food.pos.util.report;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import javax.faces.context.FacesContext;
import javax.management.RuntimeErrorException;
import javax.servlet.ServletContext;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.food.pos.bean.QueryBillReportBean;

@Component
public class DownUtil {
	private static Logger LOG = LoggerFactory.getLogger(DownUtil.class);

	public static StreamedContent getStreamedContent(String path, String name) {

		File fo = new File(path);

		LOG.info("AbsolutePath={}", fo.getAbsolutePath());

		try {
			InputStream io = new FileInputStream(fo);
			return new DefaultStreamedContent(io, "pdf/*", name);
		} catch (FileNotFoundException e) {
			LOG.error("檔案不存在");
			throw new RuntimeException("檔案不存在 e:", e);

		}

	}
}
