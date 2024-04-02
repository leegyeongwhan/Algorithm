import java.util.*;


class Solution {
    public int solution(int[] priorities, int location) {
    int answer = 0;
        Queue<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < priorities.length; i++) {
            // 0 ,  //[2, 1, 3, 2]
            queue.add(new int[]{i, priorities[i]});
        }

        while (!queue.isEmpty()) {
                        boolean flag = false;

            int[] poll = queue.poll();
            Iterator<int[]> iterator = queue.iterator();
            while (iterator.hasNext()) {
                int[] next = iterator.next();
                if (next[1] > poll[1]) {
                    queue.add(poll);
                    flag = true;
                                        break;
                }
            }

            if (!flag) {
                answer++;
                if (poll[0] == location) break;
            }
        }

        return answer;
        }
    }