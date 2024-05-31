package com.coherentsolutions.springaiintro;

import com.coherentsolutions.springaiintro.model.Answer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringaiIntroApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringaiIntroApplication.class, args);
        Answer answer = new Answer("This is a test");
        System.out.println(answer.answer());
        System.out.println(answer);
    }

}
