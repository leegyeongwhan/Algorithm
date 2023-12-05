import java.util.Arrays;
class Solution {
    public int solution(String dartResult) {
         int[] arr = new int[3];
        int index = 0;

        String str = "";
        for (int i = 0; i < dartResult.length(); i++) {
            char ch = dartResult.charAt(i);
            if ('0' <= ch && ch <= '9') {
                str += String.valueOf(ch);
            } else if (ch == 'S' || ch == 'D' || ch == 'T') {
                arr[index] = Integer.parseInt(str);
                switch (ch) {
                    case 'S':
                        arr[index] = (int) Math.pow(arr[index], 1);
                        break;
                    case 'D':
                        arr[index] = (int) Math.pow(arr[index], 2);
                        break;
                    case 'T':
                        arr[index] = (int) Math.pow(arr[index], 3);
                        break;
                }
                index++;
                str = "";
            } else {
                if (dartResult.charAt(i) == '*') {
                    arr[index - 1] *= 2;
                    if (index - 2 >= 0) {
                        arr[index - 2] *= 2;
                    }
                } else if (dartResult.charAt(i) == '#') {
                    arr[index - 1] *= (-1);
                }
            }
        }
        return Arrays.stream(arr).sum();
    }
}