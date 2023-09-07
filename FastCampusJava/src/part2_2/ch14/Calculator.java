package part2_2.ch14;


/**
 * packageName : part2_2.ch14
 * fileName : Calculator
 * description :
 * ==========================================================
 * DATE                 AUTHOR                  NOTE
 * ==========================================================
 * 2023/09/04            jae                   최초생성
 */
public abstract class Calculator implements Calc {

    @Override
    public int add(int num1, int num2) {
        return num1 + num2;
    }

    @Override
    public int substract(int num1, int num2) {
        return num1 - num2;
    }

}
