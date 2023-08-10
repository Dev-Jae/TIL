package com.example.async.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.CompletableFuture;

@Slf4j
@Service    // 서비스를 지정하는 어노테이션, @Component 와 거의 차이가 없지만 비즈니스 로직을 수행하는 서비스 레이어 클래스임을 나타냄
public class AsyncService {
    @Async("async-thread")  // Thread Pool을 활용하는 비동기 메소드 지원 어노테이션
    public CompletableFuture run(){
        /*
            CompletableFuture : @Async 같은 비동기 메소드를 사용할 때, void형태를 사용한다면 문제가 되지 않지만 return이 존재한다면
            CompletableFuture를 사용
         */
        return new AsyncResult(hello()).completable();
    }

    @Async
    public String hello() {
        for(int i = 0; i < 10; i++){
            try {
                Thread.sleep(2000);
                log.info("thread sleep ....");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return "async hello";
    }
}
