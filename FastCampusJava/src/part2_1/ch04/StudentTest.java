package part2_1.ch04;

public class StudentTest {

    public static void main(String[] args) {
        // 인스턴스 생성
        Student studentChu = new Student(); // new > 생성자

        studentChu.studentId = 20121897;
        studentChu.setStudentName("추재영");
        studentChu.address = "서울 관악구";

        studentChu.showStudentInfo();

        // 인스턴스 생성
        Student studentPark = new Student();

        studentPark.studentId = 20221030;
        studentPark.studentName = "박효신";
        studentPark.address = "서울 강남구";

        studentPark.showStudentInfo();
        System.out.println(studentChu);
        System.out.println(studentPark);
    }
}
