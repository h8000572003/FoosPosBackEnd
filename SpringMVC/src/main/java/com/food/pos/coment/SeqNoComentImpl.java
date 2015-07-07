package com.food.pos.coment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.food.pos.contract.AeUtils;
import com.food.pos.dao.SeqNoDAO;
import com.food.pos.domain.SeqNoPo;

@Component
public class SeqNoComentImpl implements SeqNoComent {

	@Autowired
	private transient SeqNoDAO dao;

	@Override
	public String getNowSeqNo() {
		SeqNoPo seqNoPo = null;
		final String date = AeUtils.getNowDate();
		final List<SeqNoPo> seqNos = dao.getSeqNo(date);
		if (seqNos == null || seqNos.isEmpty()) {

			seqNoPo = new SeqNoPo();
			seqNoPo.setSeq(String.format("%07d", 1));
			seqNoPo.setDate(date);
			this.dao.create(seqNoPo);
		} else {
			seqNoPo = seqNos.get(0);
			int newSeq = Integer.parseInt(seqNoPo.getSeq()) + 1;
			seqNoPo.setSeq(String.format("%07d", newSeq));
			seqNoPo.setDate(date);
			this.dao.create(seqNoPo);
		}
		// TODO Auto-generated method stub
		return seqNoPo.getSeq();
	}
}
