import java.util.*;


/**
 * step1. 특수문자 공백 제거
 * 2. 2중 반복문을 사용해 각 str1 str2 문자를 (0.1), (1,2) ... 이런식으로 인덱스에 해당하는 문자열을 반복해야할것 -> 이를 통해 각 문자열에서 "다중집합" 문자열을 구할 것
 * 3. 교집합, 합집합을 구해야함 두문자열 사이의  -> Set을 써야 할것 같다. 아마 합집합 교집합이니 두개를 써서 그 컬렉션에 있는 size를 구해야 할 듯하다.
 * 4. 마지막 double타입 신경써서 계산할 것
 */
public class Solution {
     public int solution(String str1, String str2) {
           str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();

        List<String> retain = new ArrayList<>();
        List<String> union = new ArrayList<>();

        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();

        for (int i = 0; i < str1.length() - 1; i++) {
            char a = str1.charAt(i);
            char b = str1.charAt(i + 1);

            if (Character.isLetter(a) && Character.isLetter(b)) {
                list1.add(String.valueOf(a) + String.valueOf(b));
            }
        }

        // str2 다중 집합 만들기
        for (int i = 0; i < str2.length() - 1; i++) {
            char a = str2.charAt(i);
            char b = str2.charAt(i + 1);

            // 문자만 가진 경우만 추가
            if (Character.isLetter(a) && Character.isLetter(b)) {
                list2.add(Character.toString(a) + Character.toString(b));
            }
        }

        Collections.sort(list1);
        Collections.sort(list2);

        // 교집합
        for (String s : list1) {
            if (list2.remove(s)) { // 집합1에 집합2가 포함된다면 삭제후, 교집합에 추가 
                retain.add(s);
            }
            union.add(s);
        }

        // 합집합
        // 교집합에서 제외된 것 뺀 나머지 합집합에 추가 
        union.addAll(list2);
        
         
                if(union.isEmpty())
          return 65536;	// 공집합일 경우 1
        return (int) (((double) retain.size() / union.size()) * 65536);
    }
}