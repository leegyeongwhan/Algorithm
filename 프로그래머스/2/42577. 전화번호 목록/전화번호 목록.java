import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        Map<String,Integer> map = new HashMap<>();
        
        for (String str : phone_book) {
           map.put(str, str.length());
        }

        for (int i = 0; i < phone_book.length; i++) { // 100만번 
           for (int j = 0; j < phone_book[i].length(); j++) { // 최대20
                if(map.containsKey(phone_book[i].substring(0, j))){
                    return false;
                }
            }
        }
        return true;
    }

  
}