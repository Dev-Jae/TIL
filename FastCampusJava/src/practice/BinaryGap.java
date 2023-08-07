package practice;

public class BinaryGap {
    public static void main(String[] args) {

    System.out.println(solution(32));

    }

    public static int solution(int N){
        String binaryString = Integer.toBinaryString(N);
        System.out.println(binaryString);

        String[] arr = binaryString.split("");

        int max = 0;
        int current = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i].equals("0")){
                current++;
            } else {
                max = (max > current) ? max : current;
                current = 0;
            }
        }

        return max;
    }
}
