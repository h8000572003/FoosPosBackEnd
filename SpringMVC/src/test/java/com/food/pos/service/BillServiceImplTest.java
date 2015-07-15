package com.food.pos.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.food.pos.dto.BillBeanDTO;

@RunWith(MockitoJUnitRunner.class)
public class BillServiceImplTest {

	private BillService service;

	@Before
	public void setup() {
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				"mvc-dispatcher-servlet.xml");
		service = (BillService) ac.getBean(BillService.class);
	}

	@Test
	public void testQuery01() {
		BillBeanDTO dto = new BillBeanDTO();
		this.service.query(dto);
	}
}
