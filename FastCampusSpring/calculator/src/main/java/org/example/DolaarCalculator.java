package org.example;

public class DolaarCalculator implements ICalculator{
    private int price = 1;
    private MarketApi marketApi;

    public DolaarCalculator(MarketApi marketApi){
        this.marketApi = marketApi;
    }

    public void init(){
        // naver
        // kakao
        this.price = marketApi.connect();
    }

    @Override
    public int sum(int x, int y) {
        x *= price;
        y *= price;
        return x + y;
    }

    @Override
    public int minus(int x, int y) {
        x *= price;
        y *= price;
        return x - y;
    }
}
