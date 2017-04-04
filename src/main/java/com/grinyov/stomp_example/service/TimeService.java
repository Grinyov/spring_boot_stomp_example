package com.grinyov.stomp_example.service;

import com.grinyov.stomp_example.model.Greeting;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by vgrinyov.
 */
@Component
@Slf4j
public class TimeService {
    private static final DateTimeFormatter TIME_FORMAT = DateTimeFormatter.ofPattern("HH:mm:ss");
    private final Logger logger = LoggerFactory.getLogger(TimeService.class);
    @Autowired
    private SimpMessagingTemplate broker;

    @Autowired
    public TimeService(final SimpMessagingTemplate broker) {
        this.broker = broker;
    }

    @Scheduled(fixedRate = 5000)
    public void run() {
        String time = LocalTime.now().format(TIME_FORMAT);

        logger.info("Time broadcast: {}", time);
        broker.convertAndSend("/topic/greetings", new Greeting("Current time is " + time));
    }
}
