import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
  Map<String, Integer> map = new HashMap<>();
    List<Integer> list = new ArrayList<>();

    public int[] solution(String msg) {
        int number = 1;

        for (int i = 0; i < 'Z' - 'A' + 1; i++) {
            char now = (char) ('A' + i);
            map.put(String.valueOf(now), number++);
        }
        System.out.println("abet = " + map);

        int index = 0;
        while (index < msg.length()) {
            StringBuilder str = new StringBuilder();
            while (index < msg.length()) {
                String value = String.valueOf(msg.charAt(index));
                if (!map.containsKey(str.toString() + value)) {
                    break;
                }
                str.append(value);
                index++;
            }
            list.add(map.get(str.toString()));

            if (index < msg.length()) {
                map.put(str.toString() + msg.charAt(index), map.size() + 1);
            }
        }

        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
}
}