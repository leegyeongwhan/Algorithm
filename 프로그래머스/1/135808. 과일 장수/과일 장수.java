import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        Arrays.sort(score); // 뒤에서부터 m 개씩 끊어서 계산 길이에서 -m을 빼주면 그 상자의 최솟값
        for(int i = score.length - m;  i >= 0 ; i -= m){
            answer += score[i] * m;
        }
        return answer;
    }
}