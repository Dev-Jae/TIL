public class knight {
    // 기사단원 공격력(약수) 구하기....출력 크기 초과가 뜸.. : println 때문에 출력 크기 초과 뜸 > 지워도 일부 뜸...
    // 주석 지우면 시간초과가 뜸..
    public static int getPower(int n){
        int power = 0;

        // 약수 구하기
        for(int i = 1; i <= n; i++){
            if((n % i) == 0){
                //System.out.println(i + " ");
                power++;
            }
        }

        return power;
    }

    public static int solution(int number, int limit, int power) {
        int answer = 0;

        for (int i = 1; i <= number; i++){
            int knightPower = getPower(i);

            // 기사단원의 공격력과 제한수치를 비교하여 철의 무게(answer)를 구함
            // 기사단원의 공격력이 제한수치보다 크면 power(제한기사 사용 공격력)를 철의 무게에 더함
            if(knightPower <= limit){
                answer += knightPower;
            } else {
                answer += power;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        //System.out.println("약수 : " + getPower(10));

        System.out.println("철의 무게 : " + solution(10, 3, 2));
    }
}
