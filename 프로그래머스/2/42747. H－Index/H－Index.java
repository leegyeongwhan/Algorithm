import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
       Arrays.sort(citations);
       System.out.println(Arrays.toString(citations));
      
        for(int i = 0; i < citations.length; i++){
          int hindex = citations.length - i;
            if(citations[i] >= hindex){
                answer = hindex;
                return hindex;
            }
        }
        // 6 5 3 1 0
   // System.out.println(tmp);
        System.out.println(Arrays.toString(citations));
        return answer;
    }
}