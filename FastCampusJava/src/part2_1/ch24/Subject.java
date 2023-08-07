package part2_1.ch24;

public class Subject {

    private String name;
    private int score;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Subject(){}

    public Subject(String subjectName){
        this.name = subjectName;
    }



}
