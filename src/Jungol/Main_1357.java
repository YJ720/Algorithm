package Jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 메모리 초과
public class Main_1357 {
	static int N;
	static int[] A, B, C, D, AB;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
				A[i] = Integer.parseInt(st.nextToken());
				B[i] = Integer.parseInt(st.nextToken());
				C[i] = Integer.parseInt(st.nextToken());
				D[i] = Integer.parseInt(st.nextToken());
		}
		
		AB = new int[N * N];
		
		// A, B 모든 조합
		int idx = 0;
		for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                AB[idx++] = A[i] + B[j];
            }
        }
		
		Arrays.sort(AB);
        
        long ans = 0;
        
        // C, D 모든 조합에 대해 AB에서 -sum 값 이분 탐색
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int target = -(C[i] +D[j]);
                
                int lower = lowerBound(AB, target);
                
                if (lower < AB.length && AB[lower] == target) {
                    int upper = upperBound(AB, target);
                    ans += (upper - lower);
                }
            }
        }
        
        System.out.println(ans);
	}
	
	// 타겟 이상의 값이 처음 나타나는 위치 반환
	static int lowerBound(int[] arr, int target) {
        int left = 0;
        int right = arr.length;
        
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (arr[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
    
    // 타겟을 초과하는 값이 처음 나타나는 위치 반환
    static int upperBound(int[] arr, int target) {
        int left = 0;
        int right = arr.length;
        
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (arr[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
