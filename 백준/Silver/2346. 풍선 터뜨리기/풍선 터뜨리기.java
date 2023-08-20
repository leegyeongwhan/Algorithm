
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        Deque<Point> deque = new ArrayDeque<>();

        for (int i = 1; i <= N; i++) {
            Point point = new Point(Integer.parseInt(st.nextToken()), i);
            deque.add(point);
        }

        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()) {
            sb.append(deque.getFirst().getIndex()).append(" ");
            Point pop = deque.pop();
            int value = pop.value;
            if (deque.isEmpty()) {
                break;
            }
            if (value > 0) {
                for (int i = 0; i < value - 1; i++) {
                    deque.addLast(deque.pollFirst());
                }
            } else {
                for (int i = 0; i < Math.abs(value); i++) {
                    deque.addFirst(deque.pollLast());
                }
            }
        }
        System.out.println(sb);
    }

    static class Point {
        int value;
        int index;

        public Point(int value, int index) {
            this.value = value;
            this.index = index;
        }

        public int getValue() {
            return value;
        }

        public int getIndex() {
            return index;
        }
    }
}
