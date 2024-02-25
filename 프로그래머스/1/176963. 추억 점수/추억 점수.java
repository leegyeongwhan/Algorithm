import java.util.HashMap;
import java.util.Map;
class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
           int[] answer = new int[photo.length];
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < name.length; i++) {
            map.put(name[i], yearning[i]);
        }

      for (int i = 0; i < photo.length; i++) {
            int cnt = 0;
            for (int j = 0; j < photo[i].length; j++) {
                   System.out.println(cnt);
                if (map.containsKey(photo[i][j])) {
                    System.out.println(photo[i][j]);
                    cnt += map.get(photo[i][j]);
                }
            }
            answer[i] = cnt;
        }
        return answer;
    }
}