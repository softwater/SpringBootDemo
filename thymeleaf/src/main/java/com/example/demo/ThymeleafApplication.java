package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@SpringBootApplication
public class ThymeleafApplication {

    public static void main(String[] args) {
        SpringApplication.run(ThymeleafApplication.class, args);
    }

    @RequestMapping("/home")
    public String home() {
        return "home";
    }

    @RequestMapping("getUserJson")
    @ResponseBody public User getUserJson() {
        User user = new User();
        user.setAge(20);
        user.setName("王麻子");
        return user;
    }

    @RequestMapping("/getUserFromModel") public String getUserFromModel(Model model) {
        User user = new User();
        user.setAge(25);
        user.setName("李四");
        model.addAttribute(user);
        return "user";
    }

    @RequestMapping("/getUserList") public String getUserList(Model model) {
        List<User> userList = new ArrayList<>();
        for (int i = 0; i<10; i++) {
            User user = new User();
            user.setAge(20 + i);
            user.setName("姓名 " + (i + 1));
            userList.add(user);
        }
        model.addAttribute(userList);
        return "user_list";
    }

    @RequestMapping("/getUserInJs") public String getUserInJs(Model model) {
        User user = new User();
        user.setAge(25);
        user.setName("李四");
        model.addAttribute(user);
        return "user_in_js";
    }

    @RequestMapping("/getUserListInJs") public String getUserListInJs(Model model) {
        List<User> userList = new ArrayList<>();
        for (int i = 0; i<10; i++) {
            User user = new User();
            user.setAge(20 + i);
            user.setName("姓名 " + (i + 1));
            userList.add(user);
        }
        model.addAttribute(userList);
        return "user_list_in_js";
    }
}
