package com.food.pos.service;

import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;
import org.mockito.Mock;

import com.food.pos.AbstractMockTesJob;
import com.food.pos.controller.BillCompent;
import com.food.pos.dto.BillBeanDTO;

public class BillServiceImplTest extends AbstractMockTesJob {
	private BillService service;

	@Mock
	private BillCompent billCompent;
	
	
	@Override
	public void inti() {
		this.service = new BillServiceImpl();

		try {
			BeanUtils.setProperty(this.service, "billCompent", billCompent);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// mockitoUp(this.service);

	}

	@Test
	public void testQuery01() {

		BillBeanDTO dto = new BillBeanDTO();
		this.service.query(dto);
	}

	
}
