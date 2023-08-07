package part2_1.ch08.userinfo;

public class UserInfo {
    public int height;
    public int weight;
    public String gender;
    public String name;
    public int age;

    public UserInfo(){
    }

    public UserInfo(int height, int weight, String gender, String name, int age){
        this.height = height;
        this.weight = weight;
        this.gender = gender;
        this.name = name;
        this.age = age;

    }

    public String showUserInfo(){
        // ex) 키가 180 이고 몸무게가 78 킬로인 남성이 있습니다. 이름은 Tomas 이고 나이는 37세입니다.
        return "키가 " + height + " 이고 몸무게가 " + weight + " 킬로인 " + gender + "이 있습니다. 이름은 " + name + " 이고 나이는 " + age + "세 입니다.";
    }
}
