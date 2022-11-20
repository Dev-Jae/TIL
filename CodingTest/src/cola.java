public class cola {
    public static int solution(int a, int b, int n) {
        // a : 콜라를 받기 위한 빈병의 수
        // b : 마트가 주는 콜라 병 수
        // n : 가지고 잇는 빈병의 수
        int answer = 0;

        while(true){
            int have = 0;   // 나누고 난 다음 나음 나머지

            if (n < a) { // 가지고 있는 병의 수가 받기 위한 병의 수보다 작으면 끝
                break;
            }

            answer += (n/a)*b;  // 가지고 있는 병에서 받기 위한 병의 수를 나눈 몫 곱하기 주는 병
            have = n%a; // 교환하고 남은 병

            n = ((n/a)*b) + have;   // 남은 병
            /*
            a = 2, b = 1, n = 20
            answer = (20/2) * 1 = 10
            have = 20%2 = 0
            n = 10 + 0 = 10
            10 > 2
            ......n이 a보다 작아질 때까지 계속 진행
            */
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println("ex 1 : " + solution(2, 1, 20));
        System.out.println("ex 2 : " + solution(3, 1, 20));
    }
}
