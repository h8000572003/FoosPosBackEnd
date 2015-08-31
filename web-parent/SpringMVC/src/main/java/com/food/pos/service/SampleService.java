
package com.food.pos.service;

import java.util.List;

import com.food.pos.dto.SampleDTO;

/**
 * SampleService 範例程式
 * 
 * @author Administrator 在 2012/12/6 建立
 */
public interface SampleService {
    /**
     * Find All NdrPerCase
     * 
     * @param ndrPerCase
     * @return
     */
    List<SampleDTO> findAllSample();

    /**
     * UpdateNdrPerCase
     * 
     * @param ndrPerCase
     * @return
     */
    void updateSample(SampleDTO sampleDto);

    /**
     * Save NdrPerCase
     * 
     * @param ndrPerCase
     * @return
     */
    void saveSample(final SampleDTO sampleDto);

    /**
     * DeleteNdrPerCase
     * 
     * @param ndrPerCase
     * @return
     */
    void deleteSample(final SampleDTO sampleDto);

    /**
     * ExecuteJob
     * 
     * @param ndrPerCaseDto
     * @return
     * @throws Exception
     */
    void executeJob(final SampleDTO sampleDto);
}
