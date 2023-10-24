import java.util.LinkedList;
import java.util.List;
class Solution {
    public int solution(int cacheSize, String[] cities) {
           int answer = 0;

        List<String> list = new LinkedList<>();
        //sudo city를 다 돌면서 cash배열에 city가 있으면 hit 없으면 miss
      if (cacheSize == 0) {
            return cities.length * 5;
        }
        for (String city : cities) {
                        city = city.toLowerCase();

            if (!list.contains(city)) { //이때 miss
                answer += 5;
                if (list.size() == cacheSize) {
                    list.remove(cacheSize - 1);
                }
                list.add(0, city);
                continue;
            }
            answer += 1;
            list.remove(city);
            list.add(0, city);
        }
        return answer;
    }
}