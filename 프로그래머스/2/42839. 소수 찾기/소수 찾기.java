import java.util.*;

class Solution {
    static int answer = 0;
    static boolean[] visited;
    static Set<Integer> set = new HashSet<>();
    
    public int solution(String numbers) {
        int answer = 0;
        visited = new boolean[numbers.length()];
        dfs(numbers, "", 0); //dfs를 돌며 나올수 있는 조합의 가짓수를 따져본다. 조합은 set에저장
   
        System.out.println(set);
        
        for (Integer num : set) {
            if(prime(num)){ //set을 돌며 소수인지 체크
                answer++;
            }
        }
        
        return answer;
    }
    
    static void dfs(String numbers, String str, int depth){
        if(depth > numbers.length()){
            return;
        }
        
        for(int i = 0; i < numbers.length(); i++){
             if(!visited[i]) {
                visited[i] = true;
                 set.add(Integer.valueOf(str + numbers.charAt(i)));
                dfs(numbers, str + numbers.charAt(i), depth+1);
                visited[i] = false;
            }
        }
    }
    
    static boolean prime(int num){
        if(num < 2){
            return false;
        }
        
       for(int i = 2; i <= (int) Math.sqrt(num); i++){
           if(num % i == 0){
               return false;
           }
       }
        return true;
    }
}