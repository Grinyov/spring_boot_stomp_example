package com.grinyov.stomp_example.controller;

import com.grinyov.stomp_example.model.Greeting;
import com.grinyov.stomp_example.model.HelloMessage;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

/**
 * Created by vgrinyov.
 */
@Controller
@Slf4j
public class GreetingController {

    private final Logger logger = LoggerFactory.getLogger(GreetingController.class);
    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage message) throws Exception {
        logger.info("Received hello: {}", message.getName());
        return new Greeting("Hello, " + message.getName() + "!");
    }
}
