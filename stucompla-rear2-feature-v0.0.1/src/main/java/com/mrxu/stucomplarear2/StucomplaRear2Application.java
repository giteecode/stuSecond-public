package com.mrxu.stucomplarear2;

import com.mrxu.stucomplarear2.utils.IdWorker;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@Slf4j
@SpringBootApplication
@MapperScan("com.mrxu.stucomplarear2.mapper")
public class StucomplaRear2Application {

    public static void main(String[] args) {
        SpringApplication.run(StucomplaRear2Application.class, args);
    }

    @Bean
    public IdWorker createIdWorker(){
        return new IdWorker(0,1);
    }

}
