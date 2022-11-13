class keypad {
    public String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();

        int lStart = 10;
        int rStart = 12;

        for (int i = 0; i < numbers.length; i++) {
            int num = numbers[i];

            if(num == 1 || num == 4 || num == 7){
                lStart = num;
                sb.append("L");
            } else if (num == 3 || num == 6 || num == 9) {
                rStart = num;
                sb.append("R");
            } else {
                if (num == 0) {
                    num = 11; // 0은 11로
                }

                int lDis = (Math.abs(num - lStart) / 3) + (Math.abs(num - lStart) % 3); // 왼쪽거리
                int rDis = (Math.abs(num - rStart) / 3) + (Math.abs(num - rStart) % 3); // 오른쪽거리

                if (lDis == rDis) {
                    if ("left".equals(hand)) {
                        lStart = num;
                        sb.append("L");
                    } else {
                        rStart = num;
                        sb.append("R");
                    }
                } else if (lDis > rDis) {
                    rStart = num;
                    sb.append("R");
                } else {
                    lStart = num;
                    sb.append("L");
                }
            }
        }
        return sb.toString();
    }
}