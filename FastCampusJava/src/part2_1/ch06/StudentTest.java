package part2_1.ch06;

public class StudentTest {
    public static void main(String[] args) {

        Student studentChu = new Student();

        studentChu.showStudentInfo();

        Student studentPark = new Student(20221030, "박효신", 4);
        System.out.println(studentPark.showStudentInfo());
    }
}
