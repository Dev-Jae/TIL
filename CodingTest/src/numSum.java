public class numSum {
    public static int solution(int[] numbers) {
        int answer = 0;
        int total = 0;
        int sum = 0;

        // 0 부터 9까지의 합
        for(int i = 0; i <= 9; i++){
            total+=i;
        }

        // numbers 원소들의 합
        for(int j = 0; j < numbers.length; j++){
            sum+=numbers[j];
        }

        answer = total - sum;

        return answer;
    }

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 6, 7, 8, 0};

        System.out.println(solution(numbers));
    }
}
