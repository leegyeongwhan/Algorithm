import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int cnt = 0;
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(int i = 0; i < scoville.length; i++){
                    q.offer(scoville[i]);
        }
        
        
        while(q.size() > 1 && q.peek() < K) {
          //      System.out.println(q);
                int tmp = q.poll() + (2 * q.poll());
                q.offer(tmp);
                cnt++;
        }
      
       if(q.peek() < K){
           return -1;
       }
        
        return cnt;
    }
}