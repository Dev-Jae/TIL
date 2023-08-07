package part2_8.ch01;

public class MinMaxProblem {
    public static void main(String[] args) {
        /* 1. 나열된 수에서 최솟값과 최댓값 구하기
         * 여러 개의 수가 배열에 있을 때 그 중 가장 큰 값과 가장 작은 값을 찾는다.
         * 배열의 몇 번째에 있는지 순서를 찾는다.
         * 반복문을 한번만 사용하여 문제 해결
         * 반복문의 한번 수행으로 두 개의 원하는 값을 모두 찾을 수 있음.
         * : 수행 속도는 나열된 수의 개수에 비례하므로 O(n)이 됨
         */

        int[] number = {10, 55, 23, 2, 79, 101, 16, 82, 30, 45};

        solution(number);

    }

    public static void solution(int[] numbers){
        Long beforeTime = System.currentTimeMillis();

        int min = numbers[0];
        int max = numbers[0];

        int minPos = 0;
        int maxPos = 0;


        for(int i = 1; i < numbers.length; i++){
            if( min > numbers[i]){
                min = numbers[i];
                minPos = i+1;
            }

            if( max < numbers[i]){
                max = numbers[i];
                maxPos = i+1;
            }
        }

        long afterTime = System.currentTimeMillis();
        long diffTime = (afterTime - beforeTime)/1000;

        System.out.println("가장 큰 값은 " + max + " 이고, 위치는 " + maxPos + "번째 입니다.");
        System.out.println("가장 작은 값은 " + min + " 이고, 위치는 " + minPos + "번째 입니다.");
        System.out.println("걸린 시간(sec) : " + diffTime);
    }
}
