package part2_2.ch6;

public class GoldCustomer extends Customer{

    double salesRatio;

    public GoldCustomer(int customerId, String customerName) {
        super(customerId, customerName);

        customerGrade = "GOLD";
        bonusRatio = 0.02;
        salesRatio = 0.1;
    }

    @Override
    public int calcPrice(int price) {
        bonusPoint += price * bonusRatio;
        price -= (int)(price * salesRatio);

        return price;
    }
}
