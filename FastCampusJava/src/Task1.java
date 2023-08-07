import java.awt.*;

public class Task1 {
    public static void main(String[] args) {

    }

    // N의 길이 1~200
    // K의 길이 1~26(알파벳)
    // N = 5, K=2 "abbba"
    // N = 8, K=3 "ppsccspp"
    // N = 3, K=2 "opo"
    public static String solution(int N, int K){
        String result = null;
        // 문자열 길이 : N
        // 서로 다른 K 개의 문자(중복제외 3)
        // 알파벳 a = 97
        // 숫자로 팰린드롬 구현 > 숫자를 알파벳으로 변환
        if( N > 200){
            return result;
        }

        if( K > 26){
            return result;
        }






        return result;
    }

    // 팰린드롬 체크
    public static boolean isPalind(String str){
        int start = 0;
        int end = str.length()-1;

        while(start <= end){
            if(str.charAt(start) != str.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
