package part2_2.ch9;/**
 * packageName : part2_2.ch9
 * fileName : Deskop
 * description :
 * ==========================================================
 * DATE                 AUTHOR                  NOTE
 * ==========================================================
 * 2023/08/31            jae                   최초생성
 */
public class DeskTop extends Computer {
    @Override
    public void display() {
        System.out.println("DeskTop display");
    }

    @Override
    public void typing() {
        System.out.println("DeskTop typing");
    }

    @Override
    public void turnOff() { // 재정의
        System.out.println("DeskTop turnOff");
    }
}
