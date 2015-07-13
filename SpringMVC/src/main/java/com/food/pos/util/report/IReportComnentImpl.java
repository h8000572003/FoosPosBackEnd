package com.food.pos.util.report;

import java.io.File;
import java.io.FileOutputStream;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.food.pos.contract.AeUtils;
import com.food.pos.contract.PosSystemConfig;
import com.sun.star.uno.RuntimeException;

@Component
public class IReportComnentImpl implements IReportComnent {

	private Logger LOG = LoggerFactory.getLogger(IReportComnentImpl.class);

	@Autowired
	private transient PosSystemConfig posSystemConfig;

	private static final String REPORT = "report";
	private static final String _JASPER = ".jasper";

	/**
 * 
 */
	@Override
	public String report(IReprtParmeter iReprtParmeter) {
		JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(
				iReprtParmeter.getContentData());

		final String path = File.separator + posSystemConfig.getShare() + "/"
				+ AeUtils.getNowDate() + AeUtils.getNowTime() + ".pdf";
		try {
			final String reportPath = File.separator
					+ posSystemConfig.getConfig() + File.separator + REPORT
					+ File.separator + iReprtParmeter.getReportID() + _JASPER;

			JasperPrint jasperPrint = JasperFillManager.fillReport(reportPath,
					iReprtParmeter.getTitle(), beanCollectionDataSource);
			this.downLoadPDF(jasperPrint, path);
		} catch (JRException e) {
			LOG.error("e:" + e);
			throw new RuntimeException("產製檔案失敗");
		}

		return path;
	}

	public void downLoadPDF(JasperPrint print, final String generateFilePath) {
		try {
			FileOutputStream fos = new FileOutputStream(generateFilePath);
			JasperExportManager.exportReportToPdfStream(print, fos);
			fos.flush();
			fos.close();
		} catch (Exception e) {
			LOG.error("e:" + e);
			throw new RuntimeException("產製檔案失敗");
		}
	}
}
