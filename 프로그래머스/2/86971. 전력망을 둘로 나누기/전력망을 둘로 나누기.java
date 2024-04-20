import java.util.*;

class Solution {
    static  boolean[][] map;
    public int solution(int n, int[][] wires) {
        int answer = n;
        map = new boolean[n+1][n+1];
        
        for(int i = 0; i < wires.length; i++){ // 그래프 만들기
            map[wires[i][0]][wires[i][1]] = true;
            map[wires[i][1]][wires[i][0]] = true;
        }
        
        int a = 0;
        int b = 0;
        for(int i = 0; i < wires.length; i++){ // 그래프 만들기
            a = wires[i][0];
            b = wires[i][1];
            
            map[a][b] = false;  // 선 뽑기
            map[b][a] = false;
            
            answer = Math.min(answer,bfs(n,a));//선 탐색
            
            map[a][b] = true;  // 다시 연결
            map[b][a] = true;
        }
        
        return answer;
    }
    
        public static int bfs(int n, int start){
            boolean[] visited = new boolean[n+1];
            int cnt =1;
        
            Queue<Integer> q = new LinkedList<>();
            q.offer(start);
            
           while(!q.isEmpty()){
            int value= q.poll();
            visited[value] = true;
            
            for(int i=1; i<=n; i++){
                if(visited[i]){
                    continue;
                } 
                if(map[value][i]) {
                    q.offer(i);
                    cnt++;
                }
              }
            }
          return (int)Math.abs(n-2*cnt);
        }
}