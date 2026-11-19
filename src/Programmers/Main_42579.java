package Programmers;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Main_42579 {

	class Solution {
	    public int[] solution(String[] genres, int[] plays) {
	        Map<String, Integer> genreMap = new HashMap<>();
	        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt((int[] i) -> -i[0])
	                                                                .thenComparingInt(i -> -i[1])
	                                                                .thenComparingInt(i -> i[2]));

	        // 장르별 총 재생 횟수 계산
	        for (int i = 0; i < plays.length; i++) {
	            String genre = genres[i];
	            genreMap.put(genre, genreMap.getOrDefault(genre, 0) + plays[i]);
	        }

	        // [장르 총합, 곡 재생수, 고유번호] PQ에 삽입
	        for (int i = 0; i < plays.length; i++) {
	            int genreTotal = genreMap.get(genres[i]);
	            pq.add(new int[] {genreTotal, plays[i], i});
	        }

	        List<Integer> answer = new ArrayList<>();
	        while (!pq.isEmpty()) {
	            int genreTotal = pq.peek()[0];

	            // 한 장르에서 최대 2곡까지 수록
	            for (int i = 0; i < 2; i++) {
	                if (pq.isEmpty() || pq.peek()[0] != genreTotal) break;
	                answer.add(pq.poll()[2]);
	            }

	            // 해당 장르의 나머지 곡은 모두 제거
	            while (!pq.isEmpty() && pq.peek()[0] == genreTotal) {
	                pq.poll();
	            }
	        }

	        int[] result = new int[answer.size()];
	        for (int i = 0; i < answer.size(); i++) {
	            result[i] = answer.get(i);
	        }

	        return result;
	    }
	}
}
