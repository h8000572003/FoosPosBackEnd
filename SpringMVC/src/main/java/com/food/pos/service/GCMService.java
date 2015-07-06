package com.food.pos.service;

import java.util.List;

import com.food.pos.domain.GCMDTO;
import com.food.pos.domain.GCMPo;

public interface GCMService {
	public void insert(GCMDTO dto);

	public List<GCMPo> queryAll(GCMDTO dto);
}
