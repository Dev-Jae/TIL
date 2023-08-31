package part2_2.ch10;

/**
 * packageName : part2_2.ch10
 * fileName : CarTest
 * description :
 * ==========================================================
 * DATE                 AUTHOR                  NOTE
 * ==========================================================
 * 2023/08/31            jae                   최초생성
 */
public class CarTest {
    public static void main(String[] args) {
        Car aiCar = new AICar();
        aiCar.run();

        System.out.println("====================");
        Car mCar = new ManualCar();
        mCar.run();
    }
}
