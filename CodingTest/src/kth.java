import java.util.*;

public class kth {
    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int i = 0; i < commands.length; i++){
            // 배열 복사
            int[] temp = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);

            // 배열 정렬
            Arrays.sort(temp);
            answer[i] = temp[commands[i][2] - 1]; // 정렬한 배열 담기
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

        int[] sol = solution(array, commands);

        System.out.println("answer : " + Arrays.toString(sol));
    }
}
