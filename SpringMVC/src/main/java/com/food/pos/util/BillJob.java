package com.food.pos.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.food.pos.job.AbstractTasklet;

@Component
public class BillJob extends AbstractTasklet {

	private static final Logger LOG = LoggerFactory.getLogger(BillJob.class);

	@Override
	protected void doWork() {
		LOG.info("BillJob begin..");
		// TODO Auto-generated method stub
		
		
		LOG.info("BillJob end..");

	}

}
