class Solution {
   static boolean[] visited; // 방문 여부
    static int answer;
    public int solution(int k, int[][] dungeons) {
       //최소 피로도 , 소모 피로도 //던전의 길이가 최대 8개라 완탐도 가능해보임
        visited = new boolean[dungeons.length];
        answer = 0;
        dfs (dungeons, 0 , k);
        return answer;
    }

    public  void dfs(int[][] dungeons, int depth, int k){
          for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i] && dungeons[i][0] <= k) {
        //       System.out.println("depth = " + Integer.valueOf(depth) + ", k = " + k + ", i = " + i);
                visited[i] = true;
                dfs(dungeons, depth + 1, k - dungeons[i][1]);  //방문 여부를 통해 모든 던전의 경우의 수를 따져본다
                visited[i] = false;
            }
        }
        answer = Math.max(depth, answer);
        
    }
}