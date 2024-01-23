import java.util.ArrayList;
import java.util.List;
class Solution {
    public String solution(int n, int t, int m, int p) {
              String answer = "";
        List<String> arr = new ArrayList<>();
        arr.add("0"); // 0번째는 0
        int num = 1;

        while (arr.size() < t * m) {
            StringBuilder str = new StringBuilder();
            int target = num;

            while (target > 0) {
                if (target % n == 10) {
                    str.append("A");
                } else if (target % n == 11) {
                    str.append("B");
                } else if (target % n == 12) {
                    str.append("C");
                } else if (target % n == 13) {
                    str.append("D");
                } else if (target % n == 14) {
                    str.append("E");
                } else if (target % n == 15) {
                    str.append("F");
                } else {
                    str.append(String.valueOf(target % n));
                }
                target /= n;
            }

            str = new StringBuilder(new StringBuilder(str.toString()).reverse().toString());
            for (int i = 0; i < str.length(); i++) {
                if (arr.size() < t * m) {
                    if (str.charAt(i) >= 'A' && str.charAt(i) <= 'F') {
                        arr.add(String.valueOf(str.charAt(i)));
                    } else {
                        arr.add(String.valueOf(str.charAt(i)));
                    }
                } else {
                    break;
                }
            }
            num++;
        }
          for (int i = p - 1; i < arr.size(); i += m) {
            answer += arr.get(i);
        }

        return answer.toUpperCase();
    }
}