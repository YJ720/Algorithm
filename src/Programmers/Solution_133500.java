package Programmers;

import java.util.ArrayList;
import java.util.List;

class Solution_133500 {
    List<List<Integer>> graph = new ArrayList<>();
    int[][] memo;

    public int solution(int n, int[][] lighthouse) {
        // memo[i][0]: i번 등대 껐을 때
        // memo[i][1]:          켰을 때
        memo = new int[n + 1][2];
        
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        
        // 양방향 간선
        for (int[] edge : lighthouse) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        
        dfs(1, 0);
        
        // 루트 노드를 켰을 때와 껐을 때 중 더 작은 값
        return Math.min(memo[1][0], memo[1][1]);
    }
    
    private void dfs(int node, int parent) {
        // 초기 상태
        memo[node][0] = 0; 
        memo[node][1] = 1; 
        
        for (int child : graph.get(node)) {
            // 부모 노드로 역주행 방지
            if (child == parent) continue; 
            
            dfs(child, node);
            
            // 현재 노드를 끄는 경우 -> 자식 노드는 무조건 켜야 함
            memo[node][0] += memo[child][1];
            
            // 현재 노드를 켜는 경우 -> 자식 노드는 켜든 끄든 상관없으니 더 작은 값 선택
            memo[node][1] += Math.min(memo[child][0], memo[child][1]);
        }
    }
}




// 배열 -> 시간 초과

//boolean[][] graph;
//int[][] memo;
//int totalNodes;
//
//public int solution(int n, int[][] lighthouse) {
//  // memo[i][0]: i번 등대 껐을 때
//  // memo[i][1]:         켰을 때
//  memo = new int[n + 1][2];
//  
//  graph = new boolean[n + 1][n + 1];
//  totalNodes = n;
//  
//  // 양방향 간선 입력
//  for (int[] edge : lighthouse) {
//      graph[edge[0]][edge[1]] = true;
//      graph[edge[1]][edge[0]] = true;
//  }
//  
//  dfs(1, 0);
//  
//  // 루트 노드를 켰을 때와 껐을 때 중 더 작은 값
//  return Math.min(memo[1][0], memo[1][1]);
//}
//
//private void dfs(int node, int parent) {
//  memo[node][0] = 0; 
//  memo[node][1] = 1; 
//  
//  for (int child = 1; child <= totalNodes; child++) {
//      // 연결되지 않은 노드면 스킵
//      if (!graph[node][child]) continue; 
//      
//      // 부모 노드로 역주행 방지
//      if (child == parent) continue; 
//      
//      dfs(child, node);
//      
//      // 현재 노드를 끄는 경우 -> 자식 노드는 무조건 켜야 함
//      memo[node][0] += memo[child][1];
//      
//      // 현재 노드를 켜는 경우 -> 자식 노드는 켜든 끄든 상관없으니 더 작은 값 선택
//      memo[node][1] += Math.min(memo[child][0], memo[child][1]);
//  }
//}