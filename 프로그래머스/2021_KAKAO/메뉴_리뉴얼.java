import java.util.*;

class Solution {
      static Map<String,Integer> map = new HashMap();
    static List<String> list = new ArrayList();

    public String[] solution(String[] orders, int[] course) {
        //1. 순서가 상관없다면 조합을 만들 때 정렬한다.
        for(int i = 0; i < orders.length; i++){
            char[] arr = orders[i].toCharArray();
            Arrays.sort(arr);
            orders[i] = String.valueOf(arr);
        }

        //2. course 만큼 돌면서 course의 요소의 길이만큼  orders의 조합을 확인한다.
        for(int courseLen : course){
            for(String order : orders) {
                combi("", order, courseLen);
            }  
                if(!map.isEmpty()){
                    List<Integer> countList = new ArrayList<>(map.values());
                    int max =   Collections.max(countList);
                    if (max > 1)
                        for (String key : map.keySet()){
                            if (map.get(key) == max)
                                list.add(key);
                        }
                    map.clear();
                }
        }

        Collections.sort(list);
        String[] answer = new String[list.size()];
        for (int i = 0; i < answer.length; i++){
            answer[i] = list.get(i);
        }
        return answer;
    }

    //재귀
    public  void  combi(String order, String other, int courseLen){
        // 탈출 조건
        if(courseLen == 0){
            map.put(order, map.getOrDefault(order, 0) + 1);
            return;
        }
        // 수행 동작
        for(int i = 0; i < other.length(); i++){
            combi(order + other.charAt(i), other.substring(i+1), courseLen-1);
        }
    }
}
