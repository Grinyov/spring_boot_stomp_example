package com.grinyov.stomp_example.client;

import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.scheduling.concurrent.ConcurrentTaskScheduler;
import org.springframework.web.socket.client.WebSocketClient;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.messaging.WebSocketStompClient;

import java.util.Scanner;

/**
 * Created by vgrinyov.
 */
public class AppClient {
    public static void main(String... argv) {
        WebSocketClient webSocketClient = new StandardWebSocketClient();
        WebSocketStompClient stompClient = new WebSocketStompClient(webSocketClient);
        stompClient.setMessageConverter(new MappingJackson2MessageConverter());
        stompClient.setTaskScheduler(new ConcurrentTaskScheduler());

        String url = "ws://127.0.0.1:8080/hello";
        SessionHandler sessionHandler = new SessionHandler();
        stompClient.connect(url, sessionHandler);

        new Scanner(System.in).nextLine(); //Don't close immediately.
    }
}
