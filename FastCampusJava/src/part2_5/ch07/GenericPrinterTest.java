package part2_5.ch07;

public class GenericPrinterTest {
    public static void main(String[] args) {

        Powder powder = new Powder();
        GenericPrinter<Powder> powderPrinter = new GenericPrinter<>();

        powderPrinter.setMaterial(powder);

        Powder p = powderPrinter.getMaterial();
        System.out.println(p.toString());
    }
}
