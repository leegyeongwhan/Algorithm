class Solution {
    public long solution(int n) {
        long answer = 0;
    
        int[] arr =  new int[n+2];
        arr[0] = 1;
        arr[1] = 1;
        arr[2] = 2;
           
        for(int i = 3; i <= n; i++){
            arr[i] = (arr[i - 1] + arr[i - 2]) % 1234567; 
        }
        
        
        return arr[n];
    }
}