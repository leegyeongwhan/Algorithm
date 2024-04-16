import java.util.Arrays;
import java.util.Collections;

class Solution {
    public int solution(int[] people, int limit) {
      int answer = 0;
        Integer[] arr = Arrays.stream(people)
                .boxed()
                .toArray(Integer[]::new);
        Arrays.sort(arr, Collections.reverseOrder());


        int start = 0;
        int last = people.length - 1;

        while (start < last) {
            int sum = arr[start] + arr[last];
            if (limit < sum) {
                start++;
            } else {
                start++;
                last--;
            }
            answer++;
        }

        if (start == last) {
            answer++;
        }
        return answer;
    }
}