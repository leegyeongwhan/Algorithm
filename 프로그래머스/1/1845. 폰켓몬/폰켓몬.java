import java.util.*;

class Solution {
    public int solution(int[] nums) {
          int answer = 0;
        //중복을 제거하고
        int[] ints = Arrays.stream(nums).distinct().toArray();
        if (nums.length/2 > ints.length) {
            return ints.length;
        } else if (nums.length/2 < ints.length) {
            return nums.length/2;
        }else if (nums.length/2 == ints.length) {
            return nums.length/2;
        }
        return answer;
    }
}