import java.util.Arrays;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
         //알고리즘의 단계
        //1.선택 절차: ‘최선의 선택’을 했을 때 전체 문제에 대한 최적해를 구할 수 있는 경우
        //가장큰 수를 담는다.
        //2.적절성 검사: 전체 문제의 최적해가 ‘부분 문제의 최적해로 구성’될 수 있는 경우
        //3. 해답 검사
        Arrays.sort(lost);
        Arrays.sort(reserve);
        int answer = n - lost.length; // 옷을 안가져온 학생 즉 옷을 줘야할 학생 을뺀다.
        
        for(int i = 0; i < lost.length; i++){
            for(int j = 0; j < reserve.length; j++){
                if(lost[i] == reserve[j]){
                    answer++;
                    lost[i] = -1;
                    reserve[j] = -1;
                    break;
                }
            }
        }
        
         for(int i = 0; i < lost.length; i++){
            for(int j = 0; j < reserve.length; j++){
                if((lost[i]-1 == reserve[j]) || (lost[i]+1 == reserve[j])){
                    answer++;
                    lost[i] = -1;
                    reserve[j] = -1;
                    break;
                }
            }
        }
        
        return answer;
    }
}