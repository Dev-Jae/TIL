package practice;

import java.util.Arrays;

public class numList {
    public static void main(String[] args) {
        int[] num_list = {5, 2, 1, 7, 5};
        int n = 3;

        solution1(num_list, n);
    }

    public static int[] solution1(int[] num_list, int n) {
        int[] answer = {};
        answer = new int[n];

        for(int i = 0; i < n; i++){
            answer[i] = num_list[i];
        }

        return answer;
    }

    public static int[] solution2(int[] num_list, int n) {
        return Arrays.copyOfRange(num_list, 0, n);
    }
}
