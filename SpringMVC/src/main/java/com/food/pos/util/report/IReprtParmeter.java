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

		R001("month001")

		;

		private Report(String path) {

			this.path = path;
		}

		public String getPath() {
			return path;
		}

		public void setPath(String path) {
			this.path = path;
		}

		private String path = "";
	}

	@Override
	public String getReportID() {
		return this.report.getPath();
	}

	public Map<String, Object> getTitle() {
		return title;
	}

	public List<Map<String, String>> getContentData() {
		return contentData;
	}

}
