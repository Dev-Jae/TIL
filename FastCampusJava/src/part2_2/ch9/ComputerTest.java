package part2_2.ch9;

/**
 * packageName : part2_2.ch9
 * fileName : ComputerTest
 * description :
 * ==========================================================
 * DATE                 AUTHOR                  NOTE
 * ==========================================================
 * 2023/08/31            jae                   최초생성
 */
public class ComputerTest {
    /**
     *  추상 클래스 (abstract class)
     *  구현 코드 없이 메서드의 선언만 있는 추상 메서드를 포함한 클래스
     *  메서드 선언 : 반환타입, 메서드 이름, 매개변수로 구성
     *  메서드 정의 : 메서드 구현과 동일한 의미 구현부(body)를 가짐({})
     *  추상 클래스는 new 할 수 없음(인스턴스화 할 수 없음)
     *  메서드에 구현 코드가 없으면 abstract로 선언
     *  abstract로 선언된 메서드를 가진 클래스는 abstract로 선언
     *  모든 메서드가 구현 된 클래스라도 abstract로 선언되면 추상 클래스로 상인스턴스화 할 수 없음
     *  추상 클래스의 추상 메서드는 하위클래스가 상속하여 구현
     */
    public static void main(String[] args) {
        Computer deskTop = new DeskTop();

    }
}
