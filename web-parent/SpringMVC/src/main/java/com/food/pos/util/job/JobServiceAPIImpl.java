/*
 * Copyright (c) 2012. 資拓宏宇科技. All right reserved.
 */

package com.food.pos.util.job;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.matchers.KeyMatcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.core.step.tasklet.TaskletStep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTransactionManager;
import org.springframework.stereotype.Component;

@Component
public class JobServiceAPIImpl implements JobServiceAPI {
	// ================================================
	// == [Enumeration types] Block Start
	// ====
	// ====
	// == [Enumeration types] Block End
	// ================================================
	// == [Static variables] Block Start
	// ====
	private static final Logger LOG = LoggerFactory.getLogger(JobServiceAPIImpl.class);

	private static final String IMMEDIATE_JOB_GROUP = "IMMEDIATE";

	private static final String SCHEDULED_JOB_GROUP = "SCHEDULED";

	private static final boolean YES_CHAR = true;

	// ====
	// == [Static variables] Block End
	// ================================================
	// == [Instance variables] Block Start
	// ====
	@Autowired
	private JobLauncher jobLauncher;

	@Autowired
	private JobRepository jobRepository;

	@Autowired
	private HibernateTransactionManager transactionManager;

	@Autowired
	private JobExecutor jobExecutor;

	// ====
	// == [Instance variables] Block End
	// ================================================
	// == [Static Constructor] Block Start
	// ====
	// ====
	// == [Static Constructor] Block End
	// ================================================
	// == [Constructors] Block Start (�tinit method)
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

	/**
	 * Run one Job immediately
	 */
	@Override
	@SuppressWarnings("unchecked")
	public final <QTO> void addOneJob(final Tasklet... params) {
		final JobKey jobKey = new JobKey(String.valueOf(new JobTask().hashCode()), IMMEDIATE_JOB_GROUP);
		final JobDetail jobDetail = JobBuilder.newJob(JobTask.class).withIdentity(jobKey).build();

		final List<Step> steps = new LinkedList<Step>();
		for (Tasklet tasklet : params) {
			steps.add(this.step(tasklet));
		}

		this.jobExecutor.setSteps(steps);

		final Collection<String> coll = this.jobExecutor.getStepNames();

		LOG.debug("\n#############Step Size(){}", coll.size());

		jobDetail.getJobDataMap().put("JobClass", (Job) this.jobExecutor);
		jobDetail.getJobDataMap().put("JobLauncher", this.jobLauncher);

		final Trigger trigger = TriggerBuilder.newTrigger().withIdentity(String.valueOf(new JobTask().hashCode()), IMMEDIATE_JOB_GROUP).build();
		LOG.debug("AddOne.JobTrigger(){}", trigger);
		try {
			final Scheduler scheduler = new StdSchedulerFactory().getScheduler();

			// Listener attached to jobKey
			scheduler.getListenerManager().addJobListener(new CronJobListener(), KeyMatcher.keyEquals(jobKey));
			scheduler.start();
			scheduler.scheduleJob(jobDetail, trigger);

		} catch (SchedulerException e) {
			LOG.error("JobServiceAPIImpl.addOneJob() error", e);
		}
	}

	/**
	 * Run one Job schedully
	 */
	@Override
	@SuppressWarnings("unchecked")
	public final <QTO> void addOneScheduledJob(final TimerDTO timerDTO, final Tasklet... params) {

		final JobKey jobKey = new JobKey(String.valueOf(new JobTask().hashCode()), IMMEDIATE_JOB_GROUP);

		final JobDetail jobDetail = JobBuilder.newJob(JobTask.class).withIdentity(jobKey).build();

		this.jobExecutor.setRestartable(false);
		for (Tasklet tasklet : params) {
			this.jobExecutor.addStep(this.step(tasklet));
		}
		jobDetail.getJobDataMap().put("JobClass", (Job) this.jobExecutor);
		jobDetail.getJobDataMap().put("JobLauncher", this.jobLauncher);

		try {
			final Trigger trigger = TriggerBuilder.newTrigger().withIdentity(String.valueOf(new JobTask().hashCode()), SCHEDULED_JOB_GROUP)
					.withSchedule(CronScheduleBuilder.cronSchedule(this.getCronExpression(timerDTO))).build();

			LOG.debug("AddOneScheduledJob.Trigger(){}", trigger);

			final Scheduler scheduler = new StdSchedulerFactory().getScheduler();

			// Listener attached to jobKey
			scheduler.getListenerManager().addJobListener(new CronJobListener(), KeyMatcher.keyEquals(jobKey));
			scheduler.start();
			scheduler.scheduleJob(jobDetail, trigger);
		} catch (Exception e) {
			LOG.error("JobServiceAPIImpl.addOneScheduledJob() error", e);
		}
	}

	// ====
	// == [Overridden Method] Block End
	// ================================================
	// == [Method] Block Start
	// ====
	/**
	 * 取得cron expression
	 * 
	 * @param TimerDTO
	 * @return
	 * @throws RisBusinessException
	 */
	private String getCronExpression(final TimerDTO timerDTO) {
		final boolean isMonthLastDay = timerDTO.getIsMonthLastDay();
		final boolean isMonthLastWeek = timerDTO.getIsMonthLastWeek();
		final String week = timerDTO.getWeek();
		final String day = timerDTO.getDay();
		final String month = timerDTO.getMonth();
		final StringBuilder cronExpression = new StringBuilder();
		final String[] expresArr = new String[6];

		// 處理秒
		expresArr[0] = "0 ";

		// 處理分
		final String minute = timerDTO.getMinutes();
		if (StringUtils.isBlank(minute)) {
			expresArr[1] = "* ";
		} else {
			expresArr[1] = minute + " ";
		}

		// 處理時
		final String hour = timerDTO.getHour();
		if (StringUtils.isBlank(hour)) {
			expresArr[2] = "* ";
		} else {
			expresArr[2] = hour + " ";
		}

		// 處理日期&星期
		if (StringUtils.isNotBlank(week) || YES_CHAR == isMonthLastWeek) {
			expresArr[3] = "? ";
			if (YES_CHAR == isMonthLastWeek) {
				expresArr[5] = "L ";
			} else if (StringUtils.isNotBlank(week)) {
				expresArr[5] = week + " ";
			}
		} else if (StringUtils.isNotBlank(day) || YES_CHAR == isMonthLastDay) {
			expresArr[5] = "? ";
			if (YES_CHAR == isMonthLastDay) {
				expresArr[3] = "L ";
			} else if (StringUtils.isNotBlank(day)) {
				expresArr[3] = day + " ";
			}
		} else {
			expresArr[3] = "* ";
			expresArr[5] = "? ";
		}

		// 處理月
		if (StringUtils.isNotBlank(month)) {
			expresArr[4] = month + " ";
		} else {
			expresArr[4] = "* ";
		}

		for (int i = 0; i < expresArr.length; i++) {
			cronExpression.append(expresArr[i]);
		}

		LOG.info("Timer expression(){}", cronExpression.toString());

		return cronExpression.toString();
	}

	/**
	 * Set step to execute each Tasklet
	 * 
	 * @param tasklet
	 * @return Step
	 */
	private Step step(final Tasklet tasklet) {
		TaskletStep step = new TaskletStep(String.valueOf(tasklet.hashCode()));
		step.setJobRepository(jobRepository);
		step.setTransactionManager(transactionManager);
		step.setTasklet(tasklet);
		step.setAllowStartIfComplete(false);
		step.setStartLimit(1);
		return step;
	}
	// ====
	// == [Method] Block End
	// ================================================
}
