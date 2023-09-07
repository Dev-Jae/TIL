package part2_2.ch14;

/**
 * packageName : part2_2.ch14
 * fileName : CompleteCalc
 * description :
 * ==========================================================
 * DATE                 AUTHOR                  NOTE
 * ==========================================================
 * 2023/09/04            jae                   최초생성
 */
public class CompleteCalc extends Calculator {
    @Override
    public int times(int num1, int num2) {
        return num1 * num2;
    }

    @Override
    public int divide(int num1, int num2) {
        if(num2 == 0){
            return ERROR;
        }

        return num1 / num2;
    }

    public void showInfo(){
        System.out.println("모두 구현했습니다.");
    }

    @Override
    public void description() {
        System.out.println("CompleteCalc overriding");
    }
}
