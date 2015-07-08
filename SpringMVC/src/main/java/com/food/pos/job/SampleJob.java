/*
 * Copyright (c) 2012. 資拓宏宇科技. All right reserved.
 */

package com.food.pos.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.food.pos.dto.SampleDTO;

@Component
public class SampleJob extends AbstractTasklet {

    // ================================================
    // == [Enumeration types] Block Start
    // ====
    // ====
    // == [Enumeration types] Block End
    // ================================================
    // == [Static variables] Block Start
    // ====
    private static final Logger LOG = LoggerFactory.getLogger(SampleJob.class);
    // ====
    // == [Static variables] Block End
    // ================================================
    // == [Instance variables] Block Start
    // ====
    private SampleDTO sampleDto;

    // ====
    // == [Instance variables] Block End
    // ================================================
    // == [Static Constructor] Block Start
    // ====
    // ====
    // == [Static Constructor] Block End
    // ================================================
    // == [Constructors] Block Start (含init method)
    // ====
    public SampleJob() {
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
    public final SampleDTO getDto() {
        return this.sampleDto;
    }

    public final void setDto(final SampleDTO dto) {
        this.sampleDto = dto;
    }

    // ====
    // == [Accessor] Block End
    // ================================================
    // == [Overridden Method] Block Start (Ex. toString/equals+hashCode)
    // ====
    @Override
    protected final void doWork() {
        LOG.info("\n#############Batch Test Real Time Batch !! sampleDto ID(){}", this.sampleDto.getId());
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
