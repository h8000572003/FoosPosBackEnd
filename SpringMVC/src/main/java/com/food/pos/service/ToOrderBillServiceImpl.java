package com.food.pos.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.food.pos.dao.SampleDAO;
import com.food.pos.domain.FeaturePo;
import com.food.pos.domain.FoodPo;
import com.food.pos.dto.ToOrderBillDTO;
import com.food.pos.dto.ToOrderFeatureDTO;
import com.food.pos.dto.ToOrderFoodDTO;

@Service("toOrderBillService")
public class ToOrderBillServiceImpl implements ToOrderBillService {

	private Logger LOG = LoggerFactory.getLogger(ToOrderBillServiceImpl.class);

	@Autowired
	private SampleDAO<FoodPo> sampleDao;

	@Autowired
	private SampleDAO<FeaturePo> featureDao;

	@Override
	public void readData(ToOrderBillDTO dto) {

		final List<FoodPo> foods = sampleDao.findAll(FoodPo.class);

		dto.getFoods().clear();
		for (FoodPo food : foods) {
			final ToOrderFoodDTO foodDTO = new ToOrderFoodDTO();
			foodDTO.setName(food.getName());
			foodDTO.setDollar(Integer.parseInt(food.getDollar()));

			dto.getFoods().add(foodDTO);
		}

		final List<FeaturePo> features = featureDao.findAll(FeaturePo.class);

		dto.getFeatures().clear();
		for (FeaturePo featureItem : features) {
			final ToOrderFeatureDTO feature = new ToOrderFeatureDTO();
			try {
				BeanUtils.copyProperties(feature, featureItem);
				dto.getFeatures().add(feature);
			} catch (Exception e) {
				LOG.error("e:", e);
			}
		}

	}

	@Override
	public void sendBill(ToOrderBillDTO dto) {
		// TODO Auto-generated method stub

	}

}
