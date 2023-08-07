package part2_2.ch4;


public class CustomerTest {
    public static void main(String[] args) {
        Customer customerLee = new Customer(10010, "이순신");
//        customerLee.setCustomerName("이순신");
//        customerLee.setCustomerId(10010);
        customerLee.bonusPoint = 1000;
        int price = customerLee.calcPrice(1000);
        System.out.println(customerLee.showCustomerInfo() + " / " + price);

        VIPCustomer customerKim = new VIPCustomer(10020, "김유신");
//        customerKim.setCustomerName("김유신");
//        customerKim.setCustomerId(10020);
        customerKim.bonusPoint = 10000;
        price = customerKim.calcPrice(1000);
        System.out.println(customerKim.showCustomerInfo() +  " / " + price);


        // 가상 메서드 : 인스턴스의 메서드를 호출함
        Customer vc = new VIPCustomer(12345, "nobody");

        System.out.println(vc.calcPrice(1000));

    }
}
