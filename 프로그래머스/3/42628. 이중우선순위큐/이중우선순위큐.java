import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
             int[] answer = new int[2];
        PriorityQueue<Integer> minQ = new PriorityQueue<>(); // (우선순위가 낮은 숫자 순)
        PriorityQueue<Integer> maxQ = new PriorityQueue<>(Collections.reverseOrder()); //높은큐

        for (String operation : operations) {
         
            if (operation.equals("D 1") && !maxQ.isEmpty()) {
                int var = maxQ.poll();
                minQ.remove(var);
            } else if (operation.equals("D -1") && !minQ.isEmpty()) {
                int var =  minQ.poll();
                maxQ.remove(var);
            } else if(operation.charAt(0) == 'I'){
                String[] arr = operation.split(" ");
             //    System.out.println(operation);

                minQ.offer(Integer.valueOf(arr[1]));
                maxQ.offer(Integer.valueOf(arr[1]));
            }
        }
          
  
        if (!maxQ.isEmpty()) {
            answer[0] = maxQ.poll();
        }
        if (!minQ.isEmpty()) {
            answer[1] = minQ.poll();
        }

        return answer;
    }
}