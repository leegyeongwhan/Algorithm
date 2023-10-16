import java.util.Arrays;

class Solution {
     public int solution(int[][] triangle) {
       int[][] dp = new int[triangle.length][triangle.length];

        dp[0][0] = triangle[0][0];
        int maxNum = 0;
        for (int i = 1; i < triangle.length; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                // i= 2 0  = 1
                if (j == 0) {
                    dp[i][j] = dp[i - 1][0] + triangle[i][0];
                } else if (j == triangle[i].length - 1) {
                    dp[i][j] = dp[i - 1][j - 1] + triangle[i][triangle[i].length - 1];
                } else {
                    //i =2 j = 1
                    //1 0, 1 1
                    //2 0, 2 1 , 2 1 , 2 2
                    int max = Math.max(dp[i - 1][j - 1], dp[i - 1][j]);
                    dp[i][j] = triangle[i][j] + max;
                }
                maxNum = Math.max(maxNum, dp[i][j]);
            }
        }
        return maxNum;
    }
}