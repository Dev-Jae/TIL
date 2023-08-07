package part2_1.ch13;

public class TakeTransTest {
    public static void main(String[] args) {
        // 2022.11.20 오후에 택시 객체 만들기
        Student studentJ = new Student("James", 5000);
        Student studentT = new Student("Tomas", 10000);

        Bus bus100 = new Bus(100);
        Bus bus500 = new Bus(500);

        studentJ.takeBus(bus100);

        Subway greenSubway = new Subway(2);
        Subway blueSubway = new Subway(1);

        studentT.takeSubway(greenSubway);

        studentJ.showInfo();
        studentT.showInfo();

        bus100.showBusInfo();
        greenSubway.showSubwayInfo();

        bus500.showBusInfo();
    }
}
