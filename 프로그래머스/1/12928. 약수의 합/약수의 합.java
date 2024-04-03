import java.util.Scanner;

class Solution {
    public int solution(int n) {
        int answer = 0;

        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                answer += i;
            }

        }
        
  //      System.out.println(answer);
   //     System.out.println(sum);
        return answer;

    }

    // public static void main(String[] args) {
    //     Scanner scanner = new Scanner(System.in);
    //     int num = scanner.nextInt();
    //     Divisor s = new Divisor();
    //     s.solutions(num);
    // }

}