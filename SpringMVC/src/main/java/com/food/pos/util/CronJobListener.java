/*
 * Copyright (c) 2012. 資拓宏宇科技. All right reserved.
 */
package com.food.pos.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobListener;

/**
 * CronJob Listener
 * 
 * @author Admin
 */
public class CronJobListener implements JobListener {

	// ================================================
	// == [Enumeration types] Block Start
	// ====
	// ====
	// == [Enumeration types] Block End
	// ================================================
	// == [Static variables] Block Start
	// ====
	private static final Logger LOG = LoggerFactory.getLogger(CronJobListener.class);
	// ====
	// == [Static variables] Block End
	// ================================================
	// == [Instance variables] Block Start
	// ====
	// ####################################################################
	// ## [Instance variables] sub-block :
	// ####################################################################
	// ====
	// == [Instance variables] Block End
	// ================================================
	// == [Static Constructor] Block Start
	// ====
	public final String ListenerName = "cronJobListener";

	// ====
	// == [Static Constructor] Block End
	// ================================================
	// == [Constructors] Block Start (含init method)
	// ====
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
	public final String getName() {
		return this.ListenerName; // must return a name
	}

	@Override
	public final void jobToBeExecuted(final JobExecutionContext paramJobExecutionContext) {
		LOG.debug("[JobToBeExecuted]paramJobExecutionContext{" + paramJobExecutionContext + "}");
	}

	@Override
	public final void jobExecutionVetoed(final JobExecutionContext paramJobExecutionContext) {
		LOG.debug("[JobExecutionVetoed]JobExecutionContext{" + paramJobExecutionContext + "}");
	}

	/**
	 * JobWasExecuted
	 * 
	 * @see org.quartz.JobListener#jobWasExecuted(org.quartz.JobExecutionContext,
	 *      org.quartz.JobExecutionException)
	 */
	@Override
	public final void jobWasExecuted(final JobExecutionContext paramJobExecutionContext, final JobExecutionException paramJobExecutionException) {
		LOG.debug("[JobWasExecuted]jobWasExecuted{" + paramJobExecutionContext + "}");
		LOG.debug("[JobWasExecuted]JobExecutionException{" + paramJobExecutionException + "}");
	}

	// ====
	// == [Overridden Method] Block End
	// ================================================
	// == [Method] Block Start
	// ====
	// ====
	// == [Method] Block End
	// ================================================

}
