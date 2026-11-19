package Jungol;

/*
	가까운 작은 수 -> 10 중에 index 가 가장 큰 수를 찾아 01로 변경 -> 없으면 0 반환
	가까운 큰 수 -> 01 중에 index 가 가장 큰 수를 찾아 10로 변경 -> 없으면 0번 index 의 1을 10으로 변경
	
	100111
	101011
	101101
	
	
	51
	110011
	
	43
	101011
	
	46
	101110
 */

import java.util.Scanner;

public class Main_2468 {
	
	static long A, small, large;
	static int sIndex, lIndex, zeros, ones;
	static String bi;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		A = sc.nextLong();	
		
		sc.close();
		
		bi = Long.toBinaryString(A);

		// 작은
		sIndex = bi.lastIndexOf("10");	
		
		StringBuilder sb = new StringBuilder();
		
		if(sIndex == -1) {
			small = 0;
		}else {
			
			sb.append(bi.substring(0, sIndex));
			
            sb.append("01");
            
            String rightSide = bi.substring(sIndex + 2);
            ones = 0;
            for (int i = 0; i < rightSide.length(); i++) {
                if (rightSide.charAt(i) == '1') {
                	ones++;
                }
            }
            zeros = rightSide.length() - ones;
            
            for (int i = 0; i < ones; i++) {
            	sb.append('1');
            }
            for (int i = 0; i < zeros; i++) {
            	sb.append('0');
            }
            
            small = Long.parseLong(sb.toString(), 2);
		}
		
		// 큰
		sb = new StringBuilder();
		
		bi = '0' + bi;
		lIndex = bi.lastIndexOf("01");
		
        sb.append(bi.substring(0, lIndex));
        
        sb.append("10");
        
        String rightSide = bi.substring(lIndex + 2);
        ones = 0;
        for (int i = 0; i < rightSide.length(); i++) {
            if (rightSide.charAt(i) == '1') {
            	ones++;
            }
        }
        zeros = rightSide.length() - ones;
        
        for (int i = 0; i < zeros; i++) {
        	sb.append('0');
        }
        for (int i = 0; i < ones; i++) {
        	sb.append('1');
        }
        
        large = Long.parseLong(sb.toString(), 2);		
		
		System.out.println(small + " " + large);

	}
}