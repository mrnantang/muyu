package com.test.muyu.tasks;

/**
 * 定时器
 */

import com.test.muyu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDateTime;

@Configuration
@EnableScheduling
public class RankingListTask {
    @Autowired
    UserService userService;

    @Scheduled(cron = "59 59 23 * * ?")
    public void deleteTodayRankingList(){
        userService.deleteTodayRankingList();
    }
}
