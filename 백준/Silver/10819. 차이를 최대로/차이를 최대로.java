import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] nums;
    static boolean[] visited;
    static int[] selected;
    static int n;
    static int result = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        nums = new int[n];
        visited = new boolean[n];
        selected = new int[n];

        for(int i=0; i<n; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }
        dfs(0);

        System.out.println(result);
    }

    public static void dfs(int count) {
        if(count==n){
            result = Math.max(fun(), result);
            return;
        }
        for(int i=0; i<n; i++){
            if(!visited[i]){
                visited[i] = true;
                selected[count] = nums[i];
                dfs(count+1);
                visited[i] = false;
            }
        }
    }
    public static int fun(){
        int sum=0;
        for(int i=0; i<n-1; i++){
            sum += Math.abs(selected[i]-selected[i+1]);
        }
        return sum;
    }
}