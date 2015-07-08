package com.food.pos.job;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

public abstract class AbstractTasklet implements Tasklet {

    @Override
    public final RepeatStatus execute(final StepContribution paramStepContribution, final ChunkContext paramChunkContext) throws Exception {
        this.doWork();
        paramStepContribution.setExitStatus(ExitStatus.COMPLETED);
        paramChunkContext.setComplete();
        return RepeatStatus.FINISHED;
    }

    /**
     * ProcessWork
     * 
     * @throws Exception
     */
    protected final void processWork() {
        this.doWork();
    }

    /**
     * DoWork
     * 
     * @param dto
     * @param user
     * @return
     */
    protected abstract void doWork();

}
