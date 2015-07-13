package com.food.pos.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.food.pos.dao.BillDAO;
import com.food.pos.domain.BillPo;
import com.food.pos.dto.QueryBillReporDTO;
import com.food.pos.util.report.IReportComnent;
import com.food.pos.util.report.IReprtParmeter.Report;

@Service("queryBillReportService")
public class QueryBillReportServiceImpl implements QueryBillReportService {

	@Autowired
	private transient BillDAO billDAO;

	@Autowired
	private transient IReportComnent mIReportComnent;

	@Override
	public void query(QueryBillReporDTO dto) {
		List<BillPo> bills = this.billDAO.findBillByLikeDate(dto.getYyyy()
				+ dto.getMonth());

		final Map<String, Object> title = new HashMap<String, Object>();

		final List<Map<String, String>> contentData = new ArrayList<Map<String, String>>();

		title.put("title", "XXX");
		dto.set(Report.R001, title, contentData);

		this.mIReportComnent.report(dto);

	}
}
