package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;
// https://www.acmicpc.net/problem/1158

public class Main_1158 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));		
		StringTokenizer st = new StringTokenizer(in.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
		
        Queue<Integer> q = new ArrayDeque<>();
		
        // q에 1부터 N까지 순서대로 채움
		for (int i = 1; i < N+1; i++) {
			q.add(i);
		}
		
		StringBuilder sb = new StringBuilder();
        sb.append("<");
        
//        /*
//         * q에 원소가 2개 이상이면
//         * 앞에서 K-1번째까지 poll()로 빼서 add()로 맨 뒤로 옮김
//         * 다 옮기면 K번째 원소를 빼서 출력에 추가
//         */
//        while(q.size() > 1) {
//        		for (int i = 0; i < K-1; i++) {
//					q.add(q.poll());
//				}
//        		sb.append(q.poll()).append(", ");
//        }
        
        
        
        // q에 남은 마지막 원소 추가
        sb.append(q.poll()).append(">");
        
        System.out.println(sb.toString());
	}
}