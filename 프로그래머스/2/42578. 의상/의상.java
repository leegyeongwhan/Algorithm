import java.util.HashMap;
import java.util.Map;
class Solution {
        public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> map = new HashMap<>();
            
        for(int i = 0; i < clothes.length; i++){
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0) +1);
        }
            
        //    System.out.println(map);
   
        //조합 구하기, 안입는 경우도 구한다. ex) 모자 수+1 , 선글라스 수+1 , + 안입는 수(1)
	    for(Integer value : map.values()) {
			answer *= (value + 1);
		}
        answer += -1; 
        return answer;    
}
}