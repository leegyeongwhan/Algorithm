class Solution
{
    public int solution(int n, int a, int b)
    {
               int answer = 0;

        while (true) {
            a= (a+1) /2;
            b= (b+1) /2;
            if (a == b) {
                answer++;
                return answer;
            }
            answer++;
        }
    }
}