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

	private static final String _JASPER = ".jasper";
	private static final String _PDF = ".pdf";

	/**
 * 
 */
	@Override
	public String report(IReprtParmeter iReprtParmeter) {
		JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(
				iReprtParmeter.getContentData());
		LOG.debug("report begin");
		String outPutPath = "";
		try {
			final String reportPath = this.posSystemConfig.getReport()
					+ iReprtParmeter.getReportID() + _JASPER;
			File f = new File(reportPath);
			LOG.info("input reportPath:" + f.getAbsolutePath());

			final JasperPrint jasperPrint = JasperFillManager.fillReport(
					reportPath, iReprtParmeter.getTitle(),
					beanCollectionDataSource);

			final String path = this.posSystemConfig.getTmpReport()
					+ AeUtils.getNowYearMon() + "/";
			new File(path).mkdirs();

			outPutPath = path + iReprtParmeter.getReportID() + "_"
					+ AeUtils.getTx() + _PDF;

			LOG.info("output path:" + outPutPath);
			this.downLoadPDF(jasperPrint, outPutPath);
		} catch (JRException e) {
			LOG.error("report e:" + e);
			throw new RuntimeException("產製檔案失敗");
		}
		LOG.debug("report finish");
		return outPutPath;
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
