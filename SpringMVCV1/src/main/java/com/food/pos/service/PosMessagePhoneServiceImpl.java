package com.food.pos.service;

import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.food.pos.bean.PosMessageForPhoneBean;
import com.food.pos.dao.SampleDAO;
import com.food.pos.domain.GCMPo;
import com.food.pos.dto.PosMessageForPhoneDTO;
import com.food.pos.dto.PosMessageForPhoneResultDTO;
import com.food.pos.util.POST2GCM;

@Service("posMessagePhoneService")
public class PosMessagePhoneServiceImpl implements PosMessagePhoneService {

	private Logger LOG = LoggerFactory
			.getLogger(PosMessagePhoneServiceImpl.class);

	@Autowired
	private SampleDAO<GCMPo> sampleDao;

	@Override
	public void post(PosMessageForPhoneDTO dto) {

		for (PosMessageForPhoneResultDTO device : dto.getSelectItems()) {

			POST2GCM.post(device.getId(), dto.getMessage());
			LOG.info(ToStringBuilder.reflectionToString(device));
		}

	}

	@Override
	public void queryAllDevice(PosMessageForPhoneDTO dto) {

		List<GCMPo> pos = this.sampleDao.findAll(GCMPo.class);
		dto.getItems().clear();
		dto.getSelectItems().clear();
		for (GCMPo po : pos) {
			PosMessageForPhoneResultDTO device = new PosMessageForPhoneResultDTO();
			device.setId(po.getId());
			device.setUser(po.getDeviceId());
			dto.getItems().add(device);
		}
	}

}
