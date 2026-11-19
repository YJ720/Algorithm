package Jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_2247 {	

	static class Interval implements Comparable<Interval>{
		int start;
		int end;
		
		public Interval(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}
		
		public int compareTo(Interval o) {
			if (this.start == o.start) {
				return this.end - o.end;
			}
			return this.start - o.start;
		}
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Interval> list = new PriorityQueue<>(N);
		
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			list.add(new Interval(Integer.parseInt(st.nextToken()), 
					Integer.parseInt(st.nextToken())));
		}
		
		Interval interval = list.poll();
		
		int start = interval.start;
        int end = interval.end;
        
        int maxOccupied = end - start; // 머문 시간 최댓값
        int maxEmpty = 0;                            // 비어있는 시간 최댓값
        
        // 큐가 빌 때까지(모든 학생을 확인할 때까지) 반복
        while (!list.isEmpty()) {
            Interval next = list.poll(); // 알아서 정렬된 순서대로 나옵니다.
            
            // 1. 시간이 겹치거나 이어지는 경우 (병합)
            if (next.start <= end) {
                // 종료 시간을 둘 중 더 늦은 시간으로 연장
                end = Math.max(end, next.end);
                // 머문 시간 최댓값 갱신
                maxOccupied = Math.max(maxOccupied, end - start);
            } 
            // 2. 시간이 겹치지 않고 끊어지는 경우 (비어있는 시간 발생)
            else {
                // 가장 길게 비어있던 시간 갱신
                maxEmpty = Math.max(maxEmpty, next.start - end);
                
                // 새로운 구간으로 기준점 갱신
                start = next.start;
                end = next.end;
                
                // 새로 시작된 구간의 머문 시간도 갱신 후보에 포함
                maxOccupied = Math.max(maxOccupied, end - start);
            }
        }
        System.out.println(maxOccupied + " " + maxEmpty);
	}
}
