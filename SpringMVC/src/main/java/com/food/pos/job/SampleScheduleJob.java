/*
 * Copyright (c) 2012. 資拓宏宇科技. All right reserved.
 */

package com.food.pos.job;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component("sampleScheduleJob")
public class SampleScheduleJob extends AbstractScheduledJobBean<Object> {

	// ================================================
	// == [Enumeration types] Block Start
	// ====
	// ====
	// == [Enumeration types] Block End
	// ================================================
	// == [Static variables] Block Start
	// ====
	private static final Logger LOG = LoggerFactory
			.getLogger(SampleScheduleJob.class);

	// ====
	// == [Static variables] Block End
	// ================================================
	// == [Instance variables] Block Start
	// ====
	// ====
	// == [Instance variables] Block End
	// ================================================
	// == [Static Constructor] Block Start
	// ====
	// ====
	// == [Static Constructor] Block End
	// ================================================
	// == [Constructors] Block Start (含tinit method)
	// ====
	public SampleScheduleJob() {
	}

	// ====
	// == [Constructors] Block End
	// ================================================
	// == [Static Method] Block Start
	// ====
	// ====
	// == [Static Method] Block End
	// ================================================
	// == [Accessor] Block Start
	// ====
	// ====
	// == [Accessor] Block End
	// ================================================
	// == [Overridden Method] Block Start (Ex. toString/equals+hashCode)
	// ====
	@Override
	public final String doWork() {
		final long ms = System.currentTimeMillis();
		LOG.debug("\t\t" + new Date(ms));
		return "Schedulling Job started successfully";
	}
	// ====
	// == [Overridden Method] Block End
	// ================================================
	// == [Method] Block Start
	// ====
	// ####################################################################
	// ## [Method] sub-block :
	// ####################################################################
	// ====
	// == [Method] Block End
	// ================================================
}
