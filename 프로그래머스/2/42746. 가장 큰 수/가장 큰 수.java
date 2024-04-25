import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String[] arr = Arrays.stream(numbers)
                             .mapToObj(String::valueOf)
                             .toArray(String[]::new);
        
        Arrays.sort(arr, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
       // System.out.println(Arrays.toString(arr));
        
        if(arr[0].equals("0")) {
            return "0";
        }
        
        StringBuffer sb = new StringBuffer();
        
        for(String str : arr){
            sb.append(str);
        }
        
        return sb.toString();
    }
    
}