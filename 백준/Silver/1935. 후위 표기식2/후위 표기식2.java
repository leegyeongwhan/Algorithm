
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String line = br.readLine();
        double[] arr = new double[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Double.parseDouble(br.readLine());
        }

        Deque<Double> stack = new LinkedList<>();
        for (int i = 0; i < line.length(); i++) {
            if ('A' <= line.charAt(i) && 'Z' >= line.charAt(i)) {
                stack.push(arr[line.charAt(i) - 'A']);
            } else {
                double a = stack.pop();
                double b = stack.pop();

                if (line.charAt(i) == '*') {
                    stack.push(a * b);
                } else if (line.charAt(i) == '+') {
                    stack.push(a + b);
                } else if (line.charAt(i) == '-') {
                    stack.push(b - a);
                } else if (line.charAt(i) == '/') {
                    stack.push(b / a);
                }
            }
        }
        System.out.printf("%.2f", stack.pop());
    }
}
