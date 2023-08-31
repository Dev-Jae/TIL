package part2_2.ch9;

/**
 * packageName : part2_2.ch9
 * fileName : Computer
 * description :
 * ==========================================================
 * DATE                 AUTHOR                  NOTE
 * ==========================================================
 * 2023/08/31            jae                   최초생성, 추상클래스
 */
public abstract class Computer {

    public abstract void display();
    public abstract void typing();

    public void turnOn() {
        System.out.println("전원을 킵니다.");
    }

    public void turnOff(){
        System.out.println("전원을 끕니다.");
    }
}
