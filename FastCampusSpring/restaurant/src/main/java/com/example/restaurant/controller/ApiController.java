package com.example.restaurant.controller;

import com.example.restaurant.wishlist.dto.WishListDto;
import com.example.restaurant.wishlist.service.WishListService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/food")
@RequiredArgsConstructor
public class ApiController {

    private final WishListService wishListService;

    @GetMapping("/search")
    public WishListDto search(@RequestParam String query){
        log.info("homePageLink : {}", wishListService.search(query).getHomePageLink());
        log.info("imageLink : {}", wishListService.search(query).getImageLink());
        return wishListService.search(query);
    }

    @PostMapping("")
    public WishListDto add(@RequestBody WishListDto wishListDto){
        // 방문추가 했을때 방문횟수가 2씩 증가하는 경우가 있음 해당 부분 확인하고 수정필요
        log.info("wishListDto : {}", wishListDto);
         return wishListService.add(wishListDto);
    }

    @GetMapping("/all")
    public List<WishListDto> findAll(){
        return wishListService.findAll();
    }

    @DeleteMapping("/{index}")
    public void delete(@PathVariable int index){
        // 삭제도 바로 안되는 경우가 있음 해당 부분 확인하고 수정필요
        wishListService.delete(index);
    }

    @PostMapping("/{index}")
    public void addVisit(@PathVariable int index){
        wishListService.addVisit(index);
    }
}
