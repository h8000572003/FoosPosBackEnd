package com.food.pos.coment;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.mail.MailParseException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.food.pos.dto.MailDTO;

@Component("mailSenderComent")
public class MailSenderComentImpl implements MailSenderComent {

//	@Autowired
	private transient JavaMailSender javaMailSender;

	@Override
	public void sendMail(MailDTO dto) {
		MimeMessage mimeMessage = this.javaMailSender.createMimeMessage();
		try {
			MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

			helper.setFrom(dto.getFrom());
			helper.setTo(dto.getTo());
			helper.setSubject(dto.getSubject());
			helper.setText(dto.getMsg());

		} catch (MessagingException e) {
			throw new MailParseException(e);
		}

		javaMailSender.send(mimeMessage);
	}

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"mvc-dispatcher*.xml");
		// 從AppContext-*.xml 找尋Bean Id名稱為 【mailSend】的物件並注入 ms 中
		MailSenderComent ms = (MailSenderComent) context
				.getBean(MailSenderComentImpl.class);
		MailDTO emailDTO = new MailDTO();
		emailDTO.setFrom("wa.addi@gmail.com");
		emailDTO.setTo("wa.addi@gmail.com");
		emailDTO.setTo("TEST");
		emailDTO.setMsg("MSAAGE");
		ms.sendMail(emailDTO);
	}
}
