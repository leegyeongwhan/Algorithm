class Solution {
    public int solution(String name) {
        int answer = 0;
         int index =0;
         int move = name.length() - 1;
         int length = name.length();
        
        //최적의 선택 ex) A -> Z 로 가는 최적의 방법
        for(int i = 0; i < name.length(); i++){
            answer += Math.min(name.charAt(i) - 'A', 'Z'-  name.charAt(i) + 1); //상하
            
            index = i + 1; //다음
            while(index < length && name.charAt(index) == 'A'){
                index++; //A 수 확인
            }
            move = Math.min(move, i * 2 + length - index);
            move = Math.min(move, (length - index) * 2 + i);
        }
        
        return answer + move;
    }
}