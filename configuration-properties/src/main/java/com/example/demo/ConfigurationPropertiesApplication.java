package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class ConfigurationPropertiesApplication {

	@Value("${book.name}")
    private String bookName;
	@Value("${book.author}")
    private String bookAuthor;

    public static void main(String[] args) {
        SpringApplication.run(ConfigurationPropertiesApplication.class, args);
    }

    @RequestMapping("/getBookInfo")
    String getBookInfo() {
        return toString();
    }

    @Override
    public String toString() {
        return "ConfigurationPropertiesApplication{" +
                "bookName='" + bookName + '\'' +
                ", bookAuthor='" + bookAuthor + '\'' +
                '}';
    }
}
