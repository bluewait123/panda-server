package com.panda.file;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * 启动应用
 * @author w
 * @date 2020-06-23
 */
@RestController
@EnableAsync
@SpringBootApplication
@ComponentScan(value = "com.panda.**")
public class Application {

    @GetMapping("/")
    @ResponseBody
    public String defaultPage(HttpSession session) {
        return session.getId();
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
