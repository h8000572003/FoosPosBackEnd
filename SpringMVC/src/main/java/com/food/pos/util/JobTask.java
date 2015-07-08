/*
 * Copyright (c) 2012.資拓宏宇科技. All right reserved.
 */
package com.food.pos.util;

import java.net.UnknownHostException;
import java.util.UUID;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;

public class JobTask implements org.quartz.Job {
    //================================================
    //== [Enumeration types] Block Start
    //====
    //====
    //== [Enumeration types] Block End 
    //================================================
    //== [Static variables] Block Start
    //====
    private static final Logger LOG = LoggerFactory.getLogger(JobTask.class);

    //====
    //== [Static variables] Block End 
    //================================================
    //== [Instance variables] Block Start
    //====
    private Job schedullingJob;

    private JobLauncher jobLauncher;

    //====
    //== [Instance variables] Block End 
    //================================================
    //== [Static Constructor] Block Start
    //====
    //====
    //== [Static Constructor] Block End 
    //================================================
    //== [Constructors] Block Start (含init method)
    //====
    //====
    //== [Constructors] Block End 
    //================================================
    //== [Static Method] Block Start
    //====
    //====
    //== [Static Method] Block End
    //================================================
    //== [Accessor] Block Start
    //====
    public final Job getSchedullingJob() {
        return this.schedullingJob;
    }

    public final void setSchedullingJob(final Job schedullingJob) {
        this.schedullingJob = schedullingJob;
    }

    public final JobLauncher getJobLauncher() {
        return this.jobLauncher;
    }

    public final void setJobLauncher(final JobLauncher jobLauncher) {
        this.jobLauncher = jobLauncher;
    }

    //====
    //== [Accessor] Block End
    //================================================
    //== [Overridden Method] Block Start (Ex. toString/equals+hashCode)
    //====

    @Override
    public final void execute(final JobExecutionContext context) throws JobExecutionException {
        final JobParametersBuilder jobParameterBulider = new JobParametersBuilder();
        final JobLauncher jobLauncher = (JobLauncher) context.getJobDetail().getJobDataMap().get("JobLauncher");
        final Job clazz = (Job) context.getJobDetail().getJobDataMap().get("JobClass");

        try {
            final JobExecution execution = jobLauncher.run(clazz, this.getNext(jobParameterBulider));
            LOG.debug("JobExecution{" + execution.getExitStatus() + "}");
        } catch (Exception e) {
        	LOG.error("JobTask.execute() error", e);
        }

    }

    /**
     * Execute scheduled Job
     * @throws UnknownHostException 
     */
    public final void executeScheduledJob() throws JobExecutionException, UnknownHostException {
        final JobParametersBuilder jobParameterBulider = new JobParametersBuilder();
        final Job clazz = this.getSchedullingJob();        

        try {
            final JobExecution execution = this.jobLauncher.run(clazz, this.getNext(jobParameterBulider));
            LOG.debug("JobExecution{" + execution.getExitStatus() + "}");
        } catch (Exception e) {
        	LOG.error("JobTask.executeScheduledJob() error", e);
        }

    }

    //====
    //== [Overridden Method] Block End
    //================================================
    //== [Method] Block Start
    //====
    /**
     * Run multiJobs
     */
    public final JobParameters getNext(final JobParametersBuilder jobParameterBulider) {
        return jobParameterBulider.addString("run.id",  UUID.randomUUID().toString()).toJobParameters();

    }
    //====
    //== [Method] Block End
    //================================================
}
