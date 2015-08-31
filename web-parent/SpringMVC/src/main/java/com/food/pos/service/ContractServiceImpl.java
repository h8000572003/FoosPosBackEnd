package com.food.pos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.food.pos.coment.MailSenderComent;
import com.food.pos.dto.ContractDTO;
import com.food.pos.dto.MailDTO;

@Service("contractService")
public class ContractServiceImpl implements ContractService {

	@Autowired
	private transient MailSenderComent mailSenderComent;

	@Override
	public void sendMail(ContractDTO dto) {
		MailDTO emailDTO = new MailDTO();
		emailDTO.setFrom(dto.getFrom());
		emailDTO.setMsg(dto.getMsg());
		emailDTO.setSubject(dto.getSubject());
		emailDTO.setTo(dto.getTo());

		this.mailSenderComent.sendMail(emailDTO);

	}

}
