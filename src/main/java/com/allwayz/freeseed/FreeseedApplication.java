package com.allwayz.freeseed;

import com.allwayz.freeseed.model.entity.LoggerMessage;
import com.allwayz.freeseed.util.logUtil.LoggerQueue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;

import javax.annotation.PostConstruct;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SpringBootApplication
//@EnableScheduling
//@EnableWebSocketMessageBroker
public class FreeseedApplication extends SpringBootServletInitializer {
//    private Logger logger = LoggerFactory.getLogger(FreeseedApplication.class);
//    @Autowired
//    private SimpMessagingTemplate messagingTemplate;

//    int info = 1;
//
//    @Scheduled(fixedRate = 1000)
//    public void outputLogger() {
//        logger.info("测试日志输出" + info++);
//    }
//
//    /**
//     * 推送日志到/topic/pullLogger
//     */
//    @PostConstruct
//    public void pushLogger() {
//        ExecutorService executorService = Executors.newFixedThreadPool(2);
//        Runnable runnable = new Runnable() {
//            @Override
//            public void run() {
//                while (true) {
//                    try {
//                        LoggerMessage log = LoggerQueue.getInstance().poll();
//                        if (log != null) {
//                            if (messagingTemplate != null)
//                                messagingTemplate.convertAndSend("/topic/pullLogger", log);
//                        }
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        };
//        executorService.submit(runnable);
//        executorService.submit(runnable);
//    }

        @Override
        protected SpringApplicationBuilder configure (SpringApplicationBuilder application){
            return application.sources(FreeseedApplication.class);
        }

        public static void main (String[]args){
            SpringApplication.run(FreeseedApplication.class, args);
        }
}
