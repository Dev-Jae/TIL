package part2_5.ch06;

public class ThreedPrinterTest {
    public static void main(String[] args) {

        Powder powder = new Powder();
        ThreeDPrinter3 printer = new ThreeDPrinter3();

        printer.setMaterial(powder);

        Powder p = (Powder)printer.getMaterial();
    }
}
