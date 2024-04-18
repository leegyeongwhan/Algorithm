import java.util.*;

class Solution {
      static final int[] firstStudent = {1, 2, 3, 4, 5};
      static final int[] secondStudent = {2, 1, 2, 3, 2, 4, 2, 5};
      static final int[] thirdStudent = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

    public int[]  solution(int[] answers) {
        int[] students = new int[3];
        for(int i = 0; i < answers.length; i++){
            
            if(firstStudent[i%5] == answers[i]){
                students[0]++;
            }
            
            if(secondStudent[i%8] == answers[i]){
                students[1]++;
            }
            
            if(thirdStudent[i%10] == answers[i]){
                students[2]++;
            }
        }
        
       int max = Math.max(students[0] , Math.max(students[1], students[2])); //최댓값구하기.
       List<Integer> list = new ArrayList<>();
        for(int i = 0; i < students.length; i++){
           if(students[i] == max){
               list.add(i+1);
           }
       }
        
       int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
           answer[i] = list.get(i);
       }
        return answer;
    }

}