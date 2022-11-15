import java.util.*;

public class sequence {
    public int solution(int[] elements) {
        int answer = 0;

        int[] nElements = new int[elements.length * 2]; // 연속된 수열 만들기 위해서

        for (int i = 0; i < elements.length; i++){
            nElements[i] = nElements[i + elements.length] = elements[i];
        }

        Set<Integer> set = new HashSet<>(); // 값 중 중복된 값 제외하기 위해 set

        for(int i = 1; i <= elements.length; i++){
            for (int j = 0; j < elements.length; j++){
                //set.add(Arrays.stream(Arrays.copyOfRange(nElements, j, j+i)).sum());    // Arrays.stream.sum() : 배열에 저장된 데이터 총 합계를 구하는 메소드
                set.add(Arrays.stream(nElements, j, j+i).sum());
            }
        }
        answer = set.size();

        return answer;
    }
}
