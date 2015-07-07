package com.food.pos.service;

import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.food.pos.coment.SeqNoComent;
import com.food.pos.contract.AeUtils;
import com.food.pos.dao.SampleDAO;
import com.food.pos.domain.BillPo;
import com.food.pos.domain.FeaturePo;
import com.food.pos.domain.FoodPo;
import com.food.pos.domain.MealPo;
import com.food.pos.dto.ToOrderBillDTO;
import com.food.pos.dto.ToOrderFeatureDTO;
import com.food.pos.dto.ToOrderFoodDTO;
import com.food.pos.dto.ToOrderFoodItemDTO;

@Service("toOrderBillService")
public class ToOrderBillServiceImpl implements ToOrderBillService {

	private Logger LOG = LoggerFactory.getLogger(ToOrderBillServiceImpl.class);

	@Autowired
	private SampleDAO<FoodPo> sampleDao;

	@Autowired
	private SampleDAO<FeaturePo> featureDao;

	@Autowired
	private transient SeqNoComent seqNoComent;

	@Override
	public void readData(ToOrderBillDTO dto) {
		dto.setTime(AeUtils.getNowTime());
		dto.setDate(AeUtils.getNowDate());
		dto.setTx(dto.getDate() + dto.getTime());
		dto.setSeqNo(seqNoComent.getNowSeqNo());

		final List<FoodPo> foods = sampleDao.findAll(FoodPo.class);

		dto.getFoods().clear();
		for (FoodPo food : foods) {
			final ToOrderFoodDTO foodDTO = new ToOrderFoodDTO();
			foodDTO.setName(food.getName());
			foodDTO.setDollar(Integer.parseInt(food.getDollar()));

			dto.getFoods().add(foodDTO);
		}

		final List<FeaturePo> features = this.featureDao
				.findAll(FeaturePo.class);

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
	@Transactional
	public void sendBill(ToOrderBillDTO dto) {

		final BillPo billPo = new BillPo();

		billPo.setDollar(dto.getTotalMoney() + "");
		billPo.setFeature("");
		billPo.setIsMealOut("N");
		billPo.setIsPaid(dto.getPayied());
		billPo.setIsSpeakOut("N");
		billPo.setOrderDate(dto.getDate());
		billPo.setOrderTime(dto.getTime());
		billPo.setOutOrIn(dto.getOutOrIn());
		billPo.setSeat(dto.getSeat());
		billPo.setTxId(dto.getTx());
		billPo.setUseNo("0");
		this.sampleDao.create(billPo);
		for (ToOrderFoodItemDTO itemFood : dto.getToOrderFoods()) {
			MealPo mealPo = new MealPo();
			mealPo.setDollar(itemFood.getDollar() + "");
			
			mealPo.setTxId(dto.getTx());
			mealPo.setName(itemFood.getName());
			mealPo.setNumber(itemFood.getNumber());
			mealPo.setSpcialize(itemFood.getSpecailize());
			mealPo.setUseNumber("0");
			this.sampleDao.create(mealPo);
			;
		}
		
	}

}
