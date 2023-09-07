package part2_2.ch14;

import part2_2.ch14.CompleteCalc;

/**
 * packageName : part2_2.ch11
 * fileName : CalculatorTest
 * description :
 * ==========================================================
 * DATE                 AUTHOR                  NOTE
 * ==========================================================
 * 2023/09/04            jae                   최초생성
 */
public class CalculatorTest {

    /**
     *   인터페이스
     *   인터페이스를 구현한 클래스는 인터페이스 형으로 선언한 변수로 형 변환 할 수 있음
     *   Calc calc = new CompleteCalc();
     *   상속에서의 형 변환과 동일한 의미
     *   클래스 상속과 달리 구현 코드가 없으므로 여러 인터페이스를 구현할 수 있음
     *   형 변환되는 경우 인터페이스에 선언된 메서드만을 사용가능함
     *
     *   인터페이스가 하는 일
     *   클래스나 프로그램이 제공하는 기능을 명시적으로 선언
     *   일종의 클라이언트 코드와의 약속이며 클래스나 프로그램이 제공하는 명세(specification)
     *   어떤 객체가 하나의 인터페이스 타입이라는 것은 그 인터페이스가 제공하는 모든 메서드를 구현했다는 의미임
     *   인터페이스를 구현한 다양한 객체를 사용함 - 다형성
     *   ex) JDBC 인터페이스
     *
     */

    public static void main(String[] args) {
        int num1 = 10;
        int num2 = 2;

        CompleteCalc calc = new CompleteCalc();
        System.out.println(calc.add(num1, num2));
        System.out.println(calc.substract(num1, num2));
        System.out.println(calc.times(num1, num2));
        System.out.println(calc.divide(num1, num2));

        calc.showInfo();    // 타입을 Calc 인터페이스로 선언할 경우 사용 할 수 없음
        calc.description();

        int[] arr = {1, 2, 3, 4, 5};
        System.out.println(Calc.total(arr));
    }
}
