/*
 * Copyright (c) 2012. 資拓宏宇科技. All right reserved.
 */

package com.food.pos.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersIncrementer;
import org.springframework.batch.core.JobParametersValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * AbstractScheduledJobBean
 * 
 * @author tbs
 */
@Component
public abstract class AbstractScheduledJobBean<QTO> implements Job {

    // ================================================
    // == [Enumeration types] Block Start
    // ====
    // ====
    // == [Enumeration types] Block End
    // ================================================
    // == [Static variables] Block Start
    // ====
    private static final Logger LOG = LoggerFactory.getLogger(AbstractScheduledJobBean.class);

    // ====
    // == [Static variables] Block End
    // ================================================
    // == [Instance variables] Block Start
    // ====
    @Autowired
    private JobParametersIncrementer jobParametersIncrementer;

    @Autowired
    private JobParametersValidator jobParametersValidator;

    // ====
    // == [Instance variables] Block End
    // ================================================
    // == [Static Constructor] Block Start
    // ====
    // ====
    // == [Static Constructor] Block End
    // ================================================
    // == [Constructors] Block Start (嚙緣init method)
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
    public final void execute(final JobExecution execution) {
        final JobParameters params = execution.getJobParameters();
        LOG.debug("AbstractScheduledJobBean.execute(){}", params);
        this.processWork();
    }

    @Override
    public final String getName() {
        return this.getClass().getName();
    }

    @Override
    public final boolean isRestartable() {
        return true;
    }

    @Override
    public final JobParametersIncrementer getJobParametersIncrementer() {
        return this.jobParametersIncrementer;
    }

    @Override
    public final JobParametersValidator getJobParametersValidator() {
        return this.jobParametersValidator;
    }

    // ====
    // == [Overridden Method] Block End
    // ================================================
    // == [Method] Block Start
    // ====

    /**
     * ProcessWork
     * 
     * @throws Exception
     */
    protected final String processWork() {
        return this.doWork();
    }

    /**
     * DoWork
     * 
     * @param dto
     * @param user
     * @return
     */
    public abstract String doWork();
    // ====
    // == [Method] Block End
    // ================================================

}
