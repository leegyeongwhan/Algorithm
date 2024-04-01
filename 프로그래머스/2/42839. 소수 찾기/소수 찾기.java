import java.util.*;

class Solution {
        static int answer = 0;
    static boolean[] visited = new boolean[7];
    Set<Integer> set = new HashSet<>();

    public int solution(String numbers) {
        int answer = 0;


        dfs("", 0, numbers);

        for (Integer num : set) {
            if (prime(num)) {
                answer++;
            }
        }
        return answer;
    }

    private boolean prime(int num) {
           if (num == 1 ||  num == 0) {
            return false;
        }


        for (int i = 2; i <= (int) Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    private void dfs(String start, int depth, String numbers) {
        if (depth > numbers.length()) {
            return;
        }

        for (int i = 0; i < numbers.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                set.add(Integer.valueOf(start + numbers.charAt(i)));
                dfs(start + numbers.charAt(i), depth + 1, numbers);
                visited[i] = false;
            }
        }
    }
}