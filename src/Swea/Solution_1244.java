package Swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Solution_1244 {
    static int max, swp, realMax;
    static boolean duplicate;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            String numStr = st.nextToken();
            swp = Integer.parseInt(st.nextToken());
            
            char[] arr = numStr.toCharArray();
            max = 0;
            visited = new boolean[swp + 1][1000000];
            
            // 진짜 최댓값 계산
            char[] sortedArr = numStr.toCharArray();
            Arrays.sort(sortedArr);
            StringBuilder sb = new StringBuilder(new String(sortedArr));
            realMax = Integer.parseInt(sb.reverse().toString());
            
            // 중복 숫자 여부
            duplicate = false;
            int[] count = new int[10];
            for (char c : arr) {
                if (++count[c - '0'] > 1) {
                    duplicate = true;
                    break;
                }
            }
            
            dfs(arr, 0);
            
            System.out.println("#" + t + " " + max);
        }
    }

    static void dfs(char[] arr, int depth) {
        int cur = Integer.parseInt(new String(arr));
        
        if (visited[depth][cur]) return;
        visited[depth][cur] = true;
        
        // 최댓값 도달 시 조기 종료 및 홀짝 판별
        if (cur == realMax) {
            int remain = swp - depth;
            // 남은 횟수가 짝수이거나, 중복 숫자가 있다면 현재 값 유지
            if (remain % 2 == 0 || duplicate) {
                max = Math.max(max, cur);
            } else {
                // 남은 횟수가 홀수이고 중복 숫자가 없으면 맨 오른쪽 두 자리만 교환
                swap(arr, arr.length - 1, arr.length - 2);
                max = Math.max(max, Integer.parseInt(new String(arr)));
                swap(arr, arr.length - 1, arr.length - 2); // 원상복구
            }
            return;
        }
        
        if (depth == swp) {
            max = Math.max(max, cur);
            return;
        }
        
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                swap(arr, i, j);
                dfs(arr, depth + 1);
                swap(arr, i, j);
            }
        }
    }

    static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
