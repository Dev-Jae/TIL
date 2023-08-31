package part2_2.ch10;

/**
 * packageName : part2_2.ch10
 * fileName : Car
 * description :
 * ==========================================================
 * DATE                 AUTHOR                  NOTE
 * ==========================================================
 * 2023/08/31            jae                   최초생성
 */
public abstract class Car {

    public abstract void drive();
    public abstract void stop();
    public abstract void wiper();

    public void startCar(){
        System.out.println("시동을 켭니다.");
    }

    public void turnOff(){
        System.out.println("시동을 끕니다.");
    }

    public void washCar(){

    }

    final public void run(){
        startCar();
        drive();
        wiper();
        stop();
        turnOff();
        washCar();
    }


}
