package com.jia.push.newpush.task;

import org.apache.log4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by user on 2015/9/8.
 */
@Component
public class NewPushTimer {
    private static Logger logger = Logger.getLogger(NewPushTimer.class);



    @Scheduled(cron = " 10 0 9 * * ? ")
    public void saveNewsInfo4Ipad() {

        logger.info("saveNewsInfo4Ipad end ... ");
    }

}
