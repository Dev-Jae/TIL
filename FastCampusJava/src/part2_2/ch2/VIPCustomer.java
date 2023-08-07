package part2_2.ch2;

public class VIPCustomer extends Customer{
    double salesRatio;
    private String agentId;

    public VIPCustomer(){
        customerGrade = "VIP";
        bonusRatio = 0.05;
        salesRatio = 0.1;

    }

    public String getAgentId() {
        return agentId;
    }

    public void setAgentId(String agentId) {
        this.agentId = agentId;
    }
}
