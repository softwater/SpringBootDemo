package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class ConfigurationYmlApplication {


    @Value("${book.name}")
    private String bookName;
    @Value("${book.author}")
    private String bookAuthor;

    @Autowired
    private User user;

    public static void main(String[] args) {
        SpringApplication.run(ConfigurationYmlApplication.class, args);
    }


    @RequestMapping("/getBookInfo")
    String getBookInfo() {
        return toString();
    }

    @RequestMapping("/getUserInfo")
    String getUserInfo() {
        return user.toString();
    }

    @Override
    public String toString() {
        return "ConfigurationPropertiesApplication{" +
                "bookName='" + bookName + '\'' +
                ", bookAuthor='" + bookAuthor + '\'' +
                '}';
    }
}
