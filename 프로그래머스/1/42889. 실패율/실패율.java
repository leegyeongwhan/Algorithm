import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(int N, int[] stages) {
             int totalFailCount = stages.length;
        int[] stageStatus = new int[N + 1];

        for (int stage : stages) {
            if (stage == N + 1) {
                continue;
            }
            stageStatus[stage]++;
        }

        Map<Integer, Double> map = new HashMap<>();
        for (int i = 1; i < N + 1; i++) {
            if (totalFailCount == 0) {
                map.put(i, (double) 0);
            } else {
                totalFailCount -= stageStatus[i];
                map.put(i, (double) stageStatus[i] / totalFailCount);
            }
        }

        List<Map.Entry<Integer, Double>> sortedEntries = map.entrySet().stream()
                .sorted(Map.Entry.<Integer, Double>comparingByValue().reversed()
                        .thenComparing(Map.Entry.<Integer, Double>comparingByKey()))
                .collect(Collectors.toList());

        int[] arr = new int[N];
        for (int i = 0; i < sortedEntries.size(); i++) {
            arr[i] = sortedEntries.get(i).getKey();
        }
        return arr;
     }
}