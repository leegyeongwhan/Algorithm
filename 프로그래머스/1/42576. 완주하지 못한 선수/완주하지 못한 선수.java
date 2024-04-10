import java.util.HashMap;
import java.util.Map;

class Solution {
      public String solution(String[] participant, String[] completion) {
//             String answer = "";
//         Map<String, Integer> map = new HashMap<>();
//         //차이가 하나니까 participant맵에서 completion맵의 벨류값을 빼주면 남은 사람은 한명
//         for (String people : participant) {
//             if (!map.containsKey(people)) {
//                 map.put(people, 1);
//             }else{
//                 map.put(people, map.get(people)+1);
//             }
//         }

//         for (String people : completion) {
//             if (map.containsKey(people)) {
//                 map.put(people, map.get(people)-1);
//             }
//         }

          
//         for (Map.Entry<String, Integer> elem : map.entrySet()) {
//            if(elem.getValue()==1){
//                 answer = elem.getKey();
//             }
//         }   
          
        String answer = "";
        HashMap<String, Integer> hm = new HashMap<>();
        for (String player : participant) {
            hm.put(player, hm.getOrDefault(player, 0) + 1);
        }
        for (String player : completion){
            hm.put(player, hm.get(player) - 1);
        } 

        for (String key : hm.keySet()) {
            if (hm.get(key) != 0){
                answer = key;
            }
        }
    return answer;
    }
}