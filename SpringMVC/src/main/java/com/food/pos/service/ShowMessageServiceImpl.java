package com.food.pos.service;

import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.food.pos.dao.MessageDAO;
import com.food.pos.domain.MessagePo;
import com.food.pos.dto.ShowMessagDTO;
import com.food.pos.dto.ShowMessagResultDTO;

@Service("showMessageService")
public class ShowMessageServiceImpl implements ShowMessageService {

	private Logger LOG = LoggerFactory.getLogger(PosMessagePhoneServiceImpl.class);

	@Autowired
	MessageDAO dao;

	@Override
	public void loadMessage(ShowMessagDTO dto) {

		final List<MessagePo> messageLists = dao.findFirstTen();
		LOG.info("showMessageService load:{}", ToStringBuilder.reflectionToString(messageLists));

		dto.getMessages().clear();
		for (MessagePo message : messageLists) {
			final ShowMessagResultDTO showMessagResultDTO = new ShowMessagResultDTO();
			showMessagResultDTO.setCreateDate(message.getCreateDate());
			showMessagResultDTO.setCreateTime(message.getCreateTime());
			showMessagResultDTO.setMessage(message.getMessage());
			showMessagResultDTO.setId(message.getId());
			showMessagResultDTO.setPath(message.getMessagePath());
			dto.getMessages().add(showMessagResultDTO);
		}

	}

}
