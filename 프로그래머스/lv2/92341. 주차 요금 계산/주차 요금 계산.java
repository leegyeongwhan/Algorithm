import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
class Solution {
    public int[] solution(int[] fees, String[] records) {
          int[] answer = {};
        int baseTime = fees[0];
        int basePrice = fees[1];
        int unitTime = fees[2];
        int unitPrice = fees[3];

        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime time1 = LocalTime.parse("23:59", formatter1);
        long finalTime = (long) time1.getHour() * 60 + time1.getMinute(); // 분 단위로 변환


        Map<String, String> timeMap = new LinkedHashMap<>();
        Map<String, Long> feesMap = new LinkedHashMap<>();
        /**
         * 1. 일단 넣는다
         * 2. IN인지 OUT인지
         */
        for (int i = 0; i < records.length; i++) {
            feesMap.put(records[i].split(" ")[1], 0L);
        }

        for (int i = 0; i < records.length; i++) {
            String[] split = records[i].split(" ");
            if (!timeMap.containsKey(split[1])) {
                timeMap.put(split[1], split[0]);
            } else {
                String removeTime = timeMap.remove(split[1]); // outTime에서 in타입을뺀다
                feesMap.replace(split[1], feesMap.get(split[1]) + calTime(split[0]) - calTime(removeTime));
            }
        }


        for (Map.Entry<String, String> entry : timeMap.entrySet()) {
            feesMap.replace(entry.getKey(), feesMap.get(entry.getKey()) + finalTime - calTime(entry.getValue()));

        }

        List<Map.Entry<String, Long>> list = new ArrayList(feesMap.entrySet());
        list.sort(Comparator.comparingLong(o -> Long.parseLong(o.getKey())));


        answer = new int[list.size()];

        for (int i = 0; i < answer.length; i++) {
            if (list.get(i).getValue() > baseTime) {
                answer[i] = basePrice + (int) Math.ceil((list.get(i).getValue() - baseTime) / (double) unitTime) * unitPrice;
            } else {
                answer[i] = basePrice;
            }
        }

        return answer;
    }
    static long calTime(String stringTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime time = LocalTime.parse(stringTime, formatter);
        return (long) time.getHour() * 60 + time.getMinute();
    }


}
