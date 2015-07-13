package com.food.pos.util.report;

import java.util.List;
import java.util.Map;

public class IReprtParmeter implements ReportParmter {

	private Map<String, Object> title;
	private List<Map<String, String>> contentData;
	private String reportID = "";

	/**
	 * 
	 * @param reportId
	 * @param title
	 * @param contentData
	 */
	public final void set(String reportId, Map<String, Object> title,
			List<Map<String, String>> contentData) {
		this.reportID = reportId;
		this.title = title;
		this.contentData = contentData;
	}

	@Override
	public String getReportID() {
		return this.reportID;
	}

	public Map<String, Object> getTitle() {
		return title;
	}

	public List<Map<String, String>> getContentData() {
		return contentData;
	}

}
