class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        int pLength = p.length();
        
        for(int i = 0; i <= t.length() - pLength; i++){
            String str = t.substring(i, i + pLength);
            long num1 =   Long.valueOf(p);
            long num2 =   Long.valueOf(str);
         //   System.out.println(num2);
            if(num1 >= num2){
                answer++;
            }
        }
        return answer;
    }
}