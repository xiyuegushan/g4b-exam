package com.g4b.g4bexam;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.g4b.g4bexam.mapper")
public class G4bExamApplication {

    public static void main(String[] args) {
        SpringApplication.run(G4bExamApplication.class, args);
    }

}
