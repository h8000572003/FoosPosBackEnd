package com.food.pos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.food.pos.dao.SampleDAO;
import com.food.pos.domain.GCMPo;
import com.food.pos.json.ReqCode;
import com.food.pos.util.POST2GCM;

@Component
public class GCMComentImpl implements GCMComent {

	@Autowired
	private SampleDAO<GCMPo> sampleDao;

	@Override
	public void sendAll(ReqCode ReqCode) {
		final List<GCMPo> mGCMPs = sampleDao.findAll(GCMPo.class);
		for (GCMPo mGCM : mGCMPs) {
			this.sendById(mGCM.getId(), ReqCode);
		}
	}

	@Override
	public void sendById(String id, ReqCode message) {
		POST2GCM.post(id, message.getCode());

	}

}
