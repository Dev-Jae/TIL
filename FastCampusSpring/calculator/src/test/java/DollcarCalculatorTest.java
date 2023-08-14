import org.example.Calculator;
import org.example.DolaarCalculator;
import org.example.MarketApi;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

// Mockito : Java 오픈소스 테스트 프레임워크, 작성한 프로그램 테스트시 사용
@ExtendWith(MockitoExtension.class) // Mockito의 Mock 객체를 사용하기 위한 어노테이션
public class DollcarCalculatorTest {

    @Mock   // Mock 객체 생성
    public MarketApi marketApi;

    @BeforeEach // 테스트 케이스 시작 전에 먼저 실행하는 어노테이션
    public void init(){
        // when으로 Mock의 행동 설정
        Mockito.lenient().when(marketApi.connect()).thenReturn(3000);
    }

    @Test
    public void testHello(){
        System.out.println("hello");
    }

    @Test
    public void dollarTest(){
        MarketApi marketApi = new MarketApi();
        DolaarCalculator dolaarCalculator = new DolaarCalculator(marketApi);
        dolaarCalculator.init();

        Calculator calculator = new Calculator(dolaarCalculator);
        System.out.println(calculator.sum(10, 10));
        Assertions.assertEquals(22000, calculator.sum(10, 10));
        Assertions.assertEquals(0, calculator.minus(10, 10));
    }
    @Test
    public void mockTest(){
        // Assertions : 단정문, 성공하지 않으면 테스트를 실패처리 하기 위해서 사용
        // assertEquals : 두 객체의 값이 같은지 여부
        DolaarCalculator dolaarCalculator = new DolaarCalculator(marketApi);
        dolaarCalculator.init();

        Calculator calculator = new Calculator(dolaarCalculator);
        System.out.println(calculator.sum(10, 10));
        Assertions.assertEquals(60000, calculator.sum(10, 10));
        Assertions.assertEquals(0, calculator.minus(10, 10));
    }
}
