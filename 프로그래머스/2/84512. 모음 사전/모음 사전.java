import java.util.*;

class Solution {
    static char[] arr = {'A', 'E', 'I', 'O', 'U'};
    static List<String> list = new ArrayList();

    public int solution(String word) {
        int answer = 0;
        
        dfs("", 0);
        //System.out.println(list);
         for(int i = 0; i < list.size(); i++){
             if(list.get(i).equals(word)) {
               return i;
            }
        }
        return answer;
    }
    
    public void dfs (String str, int depth){
       if(depth > 5) return;
        
        list.add(str);
        
         for(int i = 0; i < 5; i++){
            dfs(str + arr[i], depth+1);
        }
    }
}