public class numString {
    public static int solution(String s) {
        int answer = 0;

        String[] n = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        String[] c = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        for(int i = 0; i < 10; i++){
            s = s.replace(c[i], n[i]);
        }

        return Integer.parseInt(s);
    }

    public static void main(String[] args) {
        System.out.println("answer : " + solution("twothree4five78"));

    }
}
