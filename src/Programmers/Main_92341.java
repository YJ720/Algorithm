package Programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main_92341 {

	class Solution {
	    public int[] solution(int[] fees, String[] records) {
	        Map<String, Integer> inTime = new HashMap<>();
	        Map<String, Integer> totalTime = new HashMap<>();

	        for (String record : records) {
	            String[] parts = record.split(" ");
	            int time = toMinutes(parts[0]);
	            String carNum = parts[1];
	            String status = parts[2];

	            if (status.equals("IN")) {
	                inTime.put(carNum, time);
	            } else {
	                int inT = inTime.remove(carNum);
	                totalTime.put(carNum, totalTime.getOrDefault(carNum, 0) + (time - inT));
	            }
	        }

	        for (String carNum : inTime.keySet()) {
	            int inT = inTime.get(carNum);
	            totalTime.put(carNum, totalTime.getOrDefault(carNum, 0) + (23 * 60 + 59 - inT));
	        }

	        // 차량번호 오름차순 정렬을 위해 키를 리스트로 뽑아서 정렬
	        List<String> carNums = new ArrayList<>(totalTime.keySet());
	        Collections.sort(carNums);

	        int[] answer = new int[carNums.size()];
	        for (int i = 0; i < carNums.size(); i++) {
	            int time = totalTime.get(carNums.get(i));
	            answer[i] = calcFee(fees, time);
	        }

	        return answer;
	    }

	    private int toMinutes(String time) {
	        String[] hm = time.split(":");
	        return Integer.parseInt(hm[0]) * 60 + Integer.parseInt(hm[1]);
	    }

	    private int calcFee(int[] fees, int time) {
	        int baseTime = fees[0];
	        int baseFee = fees[1];
	        int unitTime = fees[2];
	        int unitFee = fees[3];

	        if (time <= baseTime) {
	            return baseFee;
	        }

	        int overTime = time - baseTime;
	        int units = (int) Math.ceil((double) overTime / unitTime);
	        return baseFee + units * unitFee;
	    }
	}
}
