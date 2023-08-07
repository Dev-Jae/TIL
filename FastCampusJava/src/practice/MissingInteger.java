package practice;

import java.util.*;

public class MissingInteger {
    public static void main(String[] args) {
        int[] test1 = {1, 3, 6, 4, 1, 2};
        int[] test2 = {1, 2, 3};

        System.out.println(solution(test1));
        System.out.println(solution(test2));

    }

    public static int solution(int[] A) {
        // Implement your solution here
        int result = 1;

        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < A.length; i++){
            if(A[i] > 0) {
                set.add(A[i]);
            }
        }

        for(int i = 1; i <= set.size()+1; i++){
            if(!set.contains(i)){
                result = i;
                break;
            }
        }

        return result;
    }
}
