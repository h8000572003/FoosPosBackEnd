package com.food.pos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.food.pos.dao.SampleDAO;
import com.food.pos.domain.GCMDTO;
import com.food.pos.domain.GCMPo;

@Service("gCMService")
public class GCMServiceImpl implements GCMService {
	@Autowired
	private SampleDAO<GCMPo> sampleDao;

	@Override
	@Transactional
	public void insert(GCMDTO dto) {
		sampleDao.create(dto.getgCMPo());

	}

	@Override
	public List<GCMPo> queryAll(GCMDTO dto) {
		// TODO Auto-generated method stub
		return sampleDao.findAll(GCMPo.class);
	}

}
