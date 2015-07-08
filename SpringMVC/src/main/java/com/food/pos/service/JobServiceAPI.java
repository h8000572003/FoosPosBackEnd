

package com.food.pos.service;

import org.springframework.batch.core.step.tasklet.Tasklet;

import com.food.pos.util.TimerDTO;



/**
 * job服務介面
 * @author 1109001
 *
 */
public interface JobServiceAPI {
    //================================================
    //== [Enumeration types] Block Start
    //====
    //====
    //== [Enumeration types] Block End 
    //================================================
    //== [Static variables] Block Start
    //====
    //====
    //== [Static variables] Block End 
    //================================================
    //== [Instance variables] Block Start
    //====
    //####################################################################
    //## [Instance variables] sub-block : 
    //####################################################################
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
    //====
    //== [Accessor] Block End
    //================================================
    //== [Overridden Method] Block Start (Ex. toString/equals+hashCode)
    //====
    //====
    //== [Overridden Method] Block End
    //================================================
    //== [Method] Block Start
    //====
    //####################################################################
    //## [Method] sub-block : 
    //####################################################################
    //====
    //== [Method] Block End
    //================================================        


    /**
     * (即時)一般的一次性 JOB
     * @param queryDTO
     * @param executant
     * @param jobClass
     * @param reportTitle
     */
    <QTO> void addOneJob(Tasklet ...params);

    /**
     * (排程)一般的一次性 JOB
     * @param queryDTO
     * @param executant
     * @param jobClass
     * @param reportTitle
     */
    <QTO> void addOneScheduledJob(TimerDTO timer, Tasklet ...params);
}

