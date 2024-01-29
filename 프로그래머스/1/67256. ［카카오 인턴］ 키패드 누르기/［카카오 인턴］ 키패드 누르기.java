class Solution {
    public String solution(int[] numbers, String hand) {
       String answer = "";
        int left = 10; // *
        int right = 12; // #


        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7) {
                answer += "L";
                left = numbers[i];
            } else if (numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9) {
                answer += "R";
                right = numbers[i];
            } else {
                int leftLength = getLength(left, numbers[i]);
                int rightLength = getLength(right, numbers[i]);
                if (leftLength > rightLength) {
                    answer += "R";
                    right = numbers[i];
                } else if (leftLength < rightLength) {
                    answer += "L";
                    left = numbers[i];
                } else {
                    if (hand.equals("right")) {
                        answer += "R";
                        right = numbers[i];
                    } else {
                        answer += "L";
                        left = numbers[i];
                    }
                }
            }
        }
        System.out.println("answer = " + answer);
        return answer;
    }

    private int getLength(int hand, int num) {
        hand = (hand == 0) ? 11 : hand;
        num = (num == 0) ? 11 : num;

        int x = (hand - 1) / 3;
        int y = (hand - 1) % 3;
        int numX = num / 3;
        int numY = 1;

        return Math.abs(x - numX) + Math.abs(y - numY);

    }
}