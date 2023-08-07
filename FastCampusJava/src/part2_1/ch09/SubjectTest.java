package part2_1.ch09;

public class SubjectTest {
    public static void main(String[] args) {

        Student studentChu = new Student(100, "Chu");
        studentChu.setKoreaSubject("국아", 100);
        studentChu.setMathSubject("수학", 88);

        Student studentPark = new Student(100, "Park");
        studentPark.setKoreaSubject("국아", 98);
        studentPark.setMathSubject("수학", 92);

        studentChu.showScoreInfo();
        studentPark.showScoreInfo();

    }
}
