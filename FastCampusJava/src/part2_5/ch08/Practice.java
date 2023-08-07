package part2_5.ch08;

import java.awt.*;
import java.util.*;

public class Practice {

    static int[] arr;
    static int answer;

    public static void main(String[] args) {
        arr = new int[]{1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 21};

        binarySearch(1);

    }

    public static void binarySearch(int goal){
        int first = 0;
        int last = arr.length - 1;

        while(first <= last){
            // 중간값 구하기
            int mid = (first + last) / 2;

            // 찾으려는 값이 중간값보다 클 경우 : 중간 값에 1을 더하여 오른쪽 절반 탐색
            if(arr[mid] < goal){
                System.out.println("처음 값 : " + first + " / 마지막 값 : " + last);
                System.out.println("중간 값 : " + mid);
                first = mid + 1;
            } else if (arr[mid] > goal){ // 찾으려는 값이 중간값 보다 작을 경우 : 중간 값에 1을 빼 왼쪽 절반 탐색
                System.out.println("처음 값 : " + first + " / 마지막 값 : " + last);
                System.out.println("중간 값 : " + mid);
                last = mid - 1;
            } else { // 해당 경우가 아닐 경우 중간값을 최종값으로 반환
                answer = mid;
                System.out.println("최종 값 : " + arr[answer] + " / 최종값 인덱스 : " + mid);
                break;
            }
        }
    }
}
