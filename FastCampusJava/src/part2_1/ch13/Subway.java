package part2_1.ch13;

public class Subway {
    int SubwayLine;
    int passengerCount;
    int money;

    public Subway(int SubwayLine){
        this.SubwayLine = SubwayLine;
    }

    public void take(int money){
        this.money += money;
        passengerCount++;
    }

    public void showSubwayInfo(){
        System.out.println(SubwayLine + "호선 지하철의 숭객 수는 " + passengerCount + "명 이고, 수입은 " + money + "원 입니다.");
    }
}
