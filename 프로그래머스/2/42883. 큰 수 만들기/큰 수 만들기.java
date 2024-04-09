class Solution {
    public String solution(String number, int k) {
        //탐욕 선택 속성
        //최적 부분 구조
        String answer = "";
        //알고리즘의 단계
        //1.선택 절차: ‘최선의 선택’을 했을 때 전체 문제에 대한 최적해를 구할 수 있는 경우
        //가장큰 수를 담는다.
        //2.적절성 검사: 전체 문제의 최적해가 ‘부분 문제의 최적해로 구성’될 수 있는 경우
        //3. 해답 검사
        int index = 0;
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < number.length() - k; i++){
            char max = '0';
        //     String str = "";
            for(int j = index; j <= k + i; j++){      
              //  str += number.charAt(j);
                if(max < number.charAt(j)){
                    max = number.charAt(j);
                    index = j + 1;
                }

            }
         //     System.out.println(str);
              sb.append(max);
        }
         return sb.toString();
    }
}