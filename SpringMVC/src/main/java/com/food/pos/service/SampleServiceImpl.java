/*
 * Copyright (c) 2012. 資拓宏宇科技. All right reserved.
 */

package com.food.pos.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.food.pos.dao.SampleDAO;
import com.food.pos.domain.SamplePO;
import com.food.pos.dto.SampleDTO;
import com.food.pos.job.SampleJob;

/**
 * 
 * SampleService介面實作
 * 
 * 
 * 補充說明：@Service 通常作用在業務層
 * 
 * @author Administrator 在 2012/12/6 建立
 */
@Service
public class SampleServiceImpl implements SampleService {

	// 記錄到系統訊息的LOG
	private static final Logger LOG = LoggerFactory
			.getLogger(SampleServiceImpl.class);

	@Autowired
	private SampleDAO<SamplePO> sampleDao;

	/** Batch API */
	@Autowired
	private JobServiceAPI jobService;

	/** Spring Batch */
	@Autowired
	private SampleJob job;

	public SampleServiceImpl() {
	}

	@Override
	public final void executeJob(SampleDTO sampleDto) {
		this.job.setDto(sampleDto);

		LOG.debug("Running Job start");
		this.jobService.addOneJob(this.job);
		LOG.debug("Running Job end");

	}

	@Override
	public final List<SampleDTO> findAllSample() throws DataAccessException {
		final List<SamplePO> result = this.sampleDao.findAll(SamplePO.class);
		final List<SampleDTO> resultDtoList = new ArrayList<SampleDTO>();
		for (final SamplePO vo : result) {
			resultDtoList.add(this.convertVo2Dto(vo));
		}
		return resultDtoList;
	}

	@Override
	public final void updateSample(final SampleDTO sampleDto)
			throws DataAccessException {
		this.sampleDao.update(this.convertDto2Vo(sampleDto));
	}

	@Override
	public final void saveSample(final SampleDTO sampleDto)
			throws DataAccessException {
		this.sampleDao.createOrUpdate(this.convertDto2Vo(sampleDto));
	}

	@Override
	public final void deleteSample(final SampleDTO sampleDto)
			throws DataAccessException {
		this.sampleDao.delete(this.convertDto2Vo(sampleDto));
	}

	private SampleDTO convertVo2Dto(final SamplePO vo) {
		final SampleDTO result = new SampleDTO();
		result.setId(vo.getId());
		result.setName(vo.getName());
		result.setPhone(vo.getPhone());

		return result;
	}

	private SamplePO convertDto2Vo(final SampleDTO dto) {
		final SamplePO result = new SamplePO();
		result.setId(dto.getId());
		result.setName(dto.getName());
		result.setPhone(dto.getPhone());

		return result;
	}
}
