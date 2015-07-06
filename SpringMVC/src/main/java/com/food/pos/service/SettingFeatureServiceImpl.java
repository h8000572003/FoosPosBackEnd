package com.food.pos.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.food.pos.dao.SampleDAO;
import com.food.pos.domain.FeaturePo;
import com.food.pos.dto.SettingFeatureDTO;
import com.food.pos.dto.SettingFeatureResultDTO;

@Service("settingFeatureService")
public class SettingFeatureServiceImpl implements SettingFeatureService {

	private Logger LOG = LoggerFactory.getLogger(SettingFeatureServiceImpl.class);

	@Autowired
	private SampleDAO<FeaturePo> sampleDao;

	@Override
	public void loadAllFeatures(SettingFeatureDTO dto) {

		List<FeaturePo> list = this.sampleDao.findAll(FeaturePo.class);
		dto.getResults().clear();
		for (FeaturePo feature : list) {
			final SettingFeatureResultDTO item = new SettingFeatureResultDTO();
			try {
				BeanUtils.copyProperties(item, feature);
				dto.getResults().add(item);
			} catch (Exception e) {
				LOG.error("e:", e);
			}
		}

	}

	@Override
	@Transactional
	public void saveFeatures(SettingFeatureDTO dto) {
		List list = this.sampleDao.findAll(FeaturePo.class);
		this.sampleDao.deleteAll(list);

		for (SettingFeatureResultDTO feature : dto.getResults()) {
			final FeaturePo item = new FeaturePo();
			try {
				if (StringUtils.isBlank(feature.getName())) {
					continue;
				}
				BeanUtils.copyProperties(item, feature);
				this.sampleDao.create(item);

			} catch (Exception e) {
				LOG.error("e:", e);
			}
		}

		// TODO Auto-generated method stub

	}

}
