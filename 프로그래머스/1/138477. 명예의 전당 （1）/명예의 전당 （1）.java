import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        List<Integer> list = new ArrayList();
        int index = 0;
        int min = 0 ;
        
        for(int i = 0; i < score.length; i++){
            if(list.size() != k){
               list.add(score[i]);            
            }else if(list.size() == k && list.get(0) < score[i]){
                list.remove(0);
                list.add(score[i]);            
            }
            
            Collections.sort(list);
            min = list.get(0);
            answer[index] = min;
         //   System.out.println(list);
            index++;
        }
        return answer;
    }
}
