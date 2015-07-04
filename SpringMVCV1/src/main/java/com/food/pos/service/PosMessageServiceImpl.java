package com.food.pos.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.food.pos.dao.MessageDAO;
import com.food.pos.domain.MessagePo;
import com.food.pos.dto.PosMessageDTO;
import com.food.pos.dto.PosMessageResultDTO;

@Service("posMessageService")
public class PosMessageServiceImpl implements PosMessageService {

	private Logger LOG = LoggerFactory.getLogger(PosMessageServiceImpl.class);

	@Autowired
	private MessageDAO messageDAO;

	@Override
	public void loadMessage(PosMessageDTO dto) {

		LOG.debug("loadMessage..begin..");

		List<MessagePo> messageLists = messageDAO.findFirstTen();

		dto.getPosMessageResultDTOs().clear();
		for (MessagePo message : messageLists) {
			final PosMessageResultDTO posMessageResultDTO = new PosMessageResultDTO();
			posMessageResultDTO.setCreateDate(message.getCreateDate());
			posMessageResultDTO.setCreateTime(message.getCreateTime());
			posMessageResultDTO.setMessage(message.getMessage());
			posMessageResultDTO.setId(message.getId());
			dto.getPosMessageResultDTOs().add(posMessageResultDTO);
		}

		LOG.debug("loadMessage..end..");
	}

	@Override
	@Transactional
	public void insertNewMessageWhen2Query(PosMessageDTO dto) {

		LOG.debug("insertNewMessageWhen2Query..begin..");

		final MessagePo message = new MessagePo();
		message.setCreateDate(dto.getAddPostMessage().getCreateDate());
		message.setCreateTime(dto.getAddPostMessage().getCreateTime());
		message.setMessage(dto.getAddPostMessage().getMessage());

		this.messageDAO.create(message);
		this.loadMessage(dto);
		LOG.debug("insertNewMessageWhen2Query..end..");

		dto.setAddPostMessage(new PosMessageResultDTO());

	}

	@Override
	@Transactional
	public void modify2Query(PosMessageDTO dto) {
		final MessagePo message = new MessagePo();
		message.setCreateDate(dto.getAddPostMessage().getCreateDate());
		message.setCreateTime(dto.getAddPostMessage().getCreateTime());
		message.setMessage(dto.getAddPostMessage().getMessage());
		message.setId(dto.getAddPostMessage().getId());
		this.messageDAO.update(message);
		this.loadMessage(dto);
		

		dto.setAddPostMessage(new PosMessageResultDTO());
	}

	@Override
	public void delete2Query(PosMessageDTO dto) {
		final MessagePo message = new MessagePo();
		message.setCreateDate(dto.getAddPostMessage().getCreateDate());
		message.setCreateTime(dto.getAddPostMessage().getCreateTime());
		message.setMessage(dto.getAddPostMessage().getMessage());
		message.setId(dto.getAddPostMessage().getId());
		
		this.messageDAO.delete(message);
		this.loadMessage(dto);
		dto.setAddPostMessage(new PosMessageResultDTO());
	}

}
