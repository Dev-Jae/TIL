package com.example.async.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@Configuration
public class ApiConfig {

    @Bean("async-thread")
    public Executor asyncThread(){
        /* Thread Pool에 대해 다시 한번 보기
           MaxPoolSize : 동시 시작하는 최대 Thread의 수
           CorePoolSize : 기본 실행 대기하는 Thread의 수
           QueueCapacity : MaxPoolSize 초과 요청에서 Thread 생성 요청시, 해당 요청을 Queue에 저장하는데
           이때 최대 수용 가능한 Queue의 수, Queue에 저장되었다가 Thread에 자리가 생기면 하나씩 빠져나가 동작
           ThreadNamePrefix : 생성되는 Thread 접두사 지정
         */
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        threadPoolTaskExecutor.setMaxPoolSize(100);
        threadPoolTaskExecutor.setCorePoolSize(10);
        threadPoolTaskExecutor.setQueueCapacity(10);
        threadPoolTaskExecutor.setThreadNamePrefix("Async-");
        return threadPoolTaskExecutor;
    }
}
