package part2_1.ch16;

public class EmployeeTest {
    public static void main(String[] args) {
        Employee employeePark = new Employee();
        employeePark.setEmployeeName("박효신");

        System.out.println(Employee.getSerialNum());

        Employee employeeKim = new Employee();
        employeeKim.setEmployeeName("김지은");

        System.out.println(employeePark.getEmployeeName() + "님의 사번은 " + employeePark.getEmployeeId() + " 입니다.");
        System.out.println(employeeKim.getEmployeeName() + "님의 사번은 " + employeeKim.getEmployeeId() + " 입니다.");
    }
}
