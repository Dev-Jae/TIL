package part2_8.ch02;

import java.util.Arrays;

public class BinarySearchProblem {
    public static void main(String[] args) {
        /* 2. 정렬된 수에서 하나의 수의 위치 찾기
         * 여러 개의 수가 정렬된 순서로 있을 때 특정한 수를 찾는 방법
         * 단순 반복문을 이용하면 수의 개수에 따라 비교 횟수가 증가하는 O(n)의 수행이 이루어짐
         * 수가 정렬된 상태에서 이진탐색(binary Search)을 활용하면 비교되는 요소의 수가
         * 절반으로 감소될 수 있으므로 O(logN)의 수행으로 원하는 수를 찾을 수 있음
         */

        int[] example = {108, 12, 95, 25, 83, 31, 70, 48, 66, 54};

        Arrays.sort(example);

        BinarySearch(example, 83);

    }

    public static void BinarySearch(int[] numbers, int goal){
        long beforeTime = System.currentTimeMillis();

        int left = 0;
        int right = numbers.length-1;
        int answer = 0;

        while( left <= right ){
            // 중간값 구하기
            int mid = (left + right) / 2;

            if( numbers[mid] < goal ){ // 중간값이 목표값보다 작을 경우 : 중간값에 1을 더하여 오른쪽 탐색
                left = mid+1;
            } else if ( numbers[mid] > goal) { // 중간값이 목표값보다 클 경우 : 중간값에 1을 빼 왼쪽 탐색
                right = mid-1;
            } else { // 수를 찾은 경우
                answer = mid;
                break;
            }
        }

        long afterTime = System.currentTimeMillis();
        long diffTime = (afterTime - beforeTime) / 1000;

        System.out.println(goal + "의 위치는 " + answer + "번째 입니다.");
        System.out.println("걸린 시간(sec) : " + diffTime);
    }
}
