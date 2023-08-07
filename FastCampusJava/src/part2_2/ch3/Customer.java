package part2_2.ch3;

public class Customer {

    // 중요 정보는 private 으로
    protected int customerId;
    protected String customerName;
    protected String customerGrade;
    int bonusPoint;
    double bonusRatio;

    // 생성자
/*    public Customer(){
        customerGrade = "SILVER";
        bonusRatio = 0.01;

        System.out.println("Customer() call");
    }*/

    public Customer(int customerId, String customerName){
        this.customerId = customerId;
        this.customerName = customerName;

        customerGrade = "SILVER";
        bonusRatio = 0.01;

        System.out.println("Customer(int, String) call");
    }

    public int calcPrice(int price){
        bonusPoint += price * bonusRatio;

        return price;
    }

    public String showCustomerInfo(){
        return customerName + "님의 등급은 " + customerGrade + " 이며, 보너스 포인트는 " + bonusPoint + " 입니다";

    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerGrade() {
        return customerGrade;
    }

    public void setCustomerGrade(String customerGrade) {
        this.customerGrade = customerGrade;
    }

}
