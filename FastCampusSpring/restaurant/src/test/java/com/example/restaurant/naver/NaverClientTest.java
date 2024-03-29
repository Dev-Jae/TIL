package com.example.restaurant.naver;

import com.example.restaurant.naver.dto.SearchImageReq;
import com.example.restaurant.naver.dto.SearchLocalReq;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class NaverClientTest {

    @Autowired
    private NaverClient naverClient;

    @Test
    public void searchLocalTest(){
        var search = new SearchLocalReq();
        search.setQuery("서울대입구");

        var result = naverClient.searchLocal(search);
        System.out.println(result);
    }

    @Test
    public void searchImageTest(){
        var search = new SearchImageReq();
        search.setQuery("서울대입구");

        var result = naverClient.searchImage(search);
        System.out.println(result);
    }

}
