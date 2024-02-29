import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
         int sum = 0; // 고를 귤의 개수
            int cnt = 0; // 최솟값 카운트
        int[] arr = new int[10000001];
    //    int[] arr = new int[100];
         Arrays.sort(tangerine);
        for (int i = 0; i < tangerine.length; i++) {
            arr[tangerine[i]]++;
        }
        
      Integer[] wrapperArray = Arrays.stream(arr).boxed().toArray(Integer[]::new);
     Arrays.sort(wrapperArray, (a, b) -> Integer.compare(b, a));
     for(int i = 0; i< wrapperArray.length; i++){
             if (sum + wrapperArray[i] >= k) {
        //       System.out.println( sum + wrapperArray[i]);
                cnt++;
                break;
            } else {
                sum += wrapperArray[i];
            //  System.out.println("sum = " + sum);

                cnt++;
            }
     }
   //     System.out.println(  Arrays.toString(wrapperArray));

        return cnt;
    }
}