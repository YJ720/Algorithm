package BOJ;

import java.util.Scanner;

public class CoTe13458 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[] A = new int[N];
		
		for (int i = 0; i < N; i++) {
			A[i] = sc.nextInt();
		}
		
		int B = sc.nextInt();
		int C = sc.nextInt();
		
		long answer = 0;
		
		
		for(int i = 0; i < N; i++) {
			A[i] -= B;
			answer++;
			
			if(A[i] > 0) {
				answer += A[i] / C;
				
				if(A[i] % C != 0) {
					answer++;
				}
			}
		}
		System.out.println(answer);
	}	
}
