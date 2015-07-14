package com.food.pos.util.report;

import java.util.List;
import java.util.Map;

public class IReprtParmeter implements ReportParmter {

	private Map<String, Object> title;
	private List<Map<String, String>> contentData;
	private Report report = null;

	/**
	 * 
	 * @param reportId
	 * @param title
	 * @param contentData
	 */
	public final void set(Report reportId, Map<String, Object> title,
			List<Map<String, String>> contentData) {
		this.report = reportId;
		this.title = title;
		this.contentData = contentData;
	}

	public static enum Report {

		R001

		;

	}

	@Override
	public String getReportID() {
		return this.report.toString();
	}

	public Map<String, Object> getTitle() {
		return title;
	}

	public List<Map<String, String>> getContentData() {
		return contentData;
	}

}
