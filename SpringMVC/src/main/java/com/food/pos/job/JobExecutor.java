/*
 * Copyright (c) 2012. 資拓宏宇科技. All right reserved.
 */

package com.food.pos.job;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobInterruptedException;
import org.springframework.batch.core.StartLimitExceededException;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.job.AbstractJob;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.stereotype.Component;

@Component
public class JobExecutor extends AbstractJob {

    private static final Logger LOG = LoggerFactory.getLogger(JobExecutor.class);

    private final List<Step> steps = new ArrayList<Step>();

    /**
     * Default constructor for job with null name
     */
    public JobExecutor() {
        this(null);
    }

    /**
     * @param name
     */
    public JobExecutor(final String name) {
        super(name);
    }

    /**
     * Public setter for the steps in this job. Overrides any calls to
     * {@link #addStep(Step)}.
     * 
     * @param steps
     *            the steps to execute
     */
    public final void setSteps(final List<Step> steps) {
        this.steps.clear();
        this.steps.addAll(steps);
    }

    /**
     * Convenience method for clients to inspect the steps for this job.
     * 
     * @return the step names for this job
     */
    @Override
    public final Collection<String> getStepNames() {
        final List<String> names = new ArrayList<String>();
        for (final Step step : this.steps) {
            names.add(step.getName());
        }
        return names;
    }

    /**
     * Convenience method for adding a single step to the job.
     * 
     * @param step
     *            a {@link Step} to add
     */
    public final void addStep(final Step step) {
        this.steps.add(step);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.springframework.batch.core.job.AbstractJob#getStep(java.lang.String)
     */
    @Override
    public final Step getStep(final String stepName) {
        for (final Step step : this.steps) {
            if (step.getName().equals(stepName)) {
                return step;
            }
        }
        return null;
    }

    /**
     * Handler of steps sequentially as provided, checking each one for success
     * before moving to the next. Returns the last {@link StepExecution}
     * successfully processed if it exists, and null if none were processed.
     * 
     * @param execution
     *            the current {@link JobExecution}
     * 
     * @see AbstractJob#handleStep(Step, JobExecution)
     */
    @Override
    protected final void doExecute(final JobExecution execution) throws JobInterruptedException, JobRestartException, StartLimitExceededException {
        StepExecution stepExecution = null;
        for (final Step step : this.steps) {
            stepExecution = this.handleStep(step, execution);
            LOG.debug("JobExecutor.doExecute.StepExecution(){}", stepExecution);

            if (stepExecution == null || stepExecution.getStatus() != BatchStatus.COMPLETED) {
                //
                // Terminate the job if a step fails
                //
                break;
            }
        }

        //
        // Update the job status to be the same as the last step
        //
        if (stepExecution != null) {
            LOG.debug("Upgrading JobExecution status(){}", stepExecution);
            execution.upgradeStatus(stepExecution.getStatus());
            execution.setExitStatus(stepExecution.getExitStatus());
        }
    }

}
