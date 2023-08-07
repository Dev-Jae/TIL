package part2_2.ch3;

public class VIPCustomer extends Customer {
    double salesRatio;
    private String agentId;



/*    public VIPCustomer(){
        //super();    // 하위 클래스가 상위 클래스 인스턴스의 참조값을 가지게 됨.
        // 컴파일러가 자동으로 호출(상위클래스를 호출하 코드가 없으면)

        customerGrade = "VIP";
        bonusRatio = 0.05;
        salesRatio = 0.1;

        System.out.println("VIPCustomer() call");
    }*/

    public VIPCustomer(int customerId, String customerName) {
        super(customerId, customerName);

        customerGrade = "VIP";
        bonusRatio = 0.05;
        salesRatio = 0.1;

        System.out.println("VIPCustomer(int, String) call");
    }

    public String getAgentId() {
        return agentId;
    }

    public void setAgentId(String agentId) {
        this.agentId = agentId;
    }
}
