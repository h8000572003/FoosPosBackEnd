package com.food.pos.dao;

import java.util.List;

import com.food.pos.domain.SeqNoPo;

public interface SeqNoDAO extends GenericDAO<SeqNoPo> {
	/**
	 * 取得今天尚未結單與出菜清單
	 * 
	 * @param date
	 * @return
	 */
	public List<SeqNoPo> getSeqNo(String date);

}
