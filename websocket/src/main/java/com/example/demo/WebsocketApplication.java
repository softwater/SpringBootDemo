package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;

@SpringBootApplication
public class WebsocketApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebsocketApplication.class, args);
    }

    @MessageMapping("/welcome")
    @SendTo("/topic/getResponse")
    public WebSiteResponse say(WebSiteMessage message) throws InterruptedException {
        Thread.sleep(3000);
        System.out.println(message);
        return new WebSiteResponse("Hello " + message.getName());
    }
}
