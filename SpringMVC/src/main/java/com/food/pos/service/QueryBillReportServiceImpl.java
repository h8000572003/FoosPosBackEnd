package com.food.pos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.food.pos.dao.BillDAO;
import com.food.pos.domain.BillPo;
import com.food.pos.dto.QueryBillReporDTO;

@Service("queryBillReportService")
public class QueryBillReportServiceImpl implements QueryBillReportService {

	@Autowired
	private transient BillDAO billDAO;

	@Override
	public void query(QueryBillReporDTO dto) {
		List<BillPo> bills = this.billDAO.findBillByLikeDate(dto.getYyyy()
				+ dto.getMonth());
		
		
		
		
		

	}

}
