import java.util.stream.IntStream;

public class test {
    public static void createStreamIntSum() {
        IntStream stream = IntStream.of(10, 20, 30, 40, 50);
        System.out.println(stream.sum());
    }

    public static void main(String[] args) {
        createStreamIntSum();
    }
}
