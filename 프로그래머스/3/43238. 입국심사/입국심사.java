import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times);
        
        long low = 0;
        long high = times[times.length-1] * (long)n; //모든 사람이 가장 느리게 심사받음
        
        while(low <= high) {
            long mid = (low + high) / 2;
            long sum = 0;
            for (int i = 0; i < times.length; i++){
                 sum += mid / times[i];
            }
               
            if (sum < n) //시간안에 사람이 다 못받는다.
                low = mid + 1;
            else {
                high = mid - 1;
                answer = mid;
            }
        }  
        
        return answer;
    }
}