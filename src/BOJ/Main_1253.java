package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1253 {
	static int N;
	static int[] numbers;
	static int cnt;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		numbers = new int[N];
		cnt = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(numbers);
		
		for (int i = 0; i < N; i++) {
			int f = 0;
            int r = N - 1;
            
            while (f < r) {
                if (f == i) {
                    f++;
                    continue;
                }
                if (r == i) {
                    r--;
                    continue;
                }
                
                int sum = numbers[f] + numbers[r];
                
                if (sum == numbers[i]) {
                    cnt++;
                    break;
                } else if (sum < numbers[i]) {
                    f++;
                } else {
                    r--;
                }
            }
        }
		
		System.out.println(cnt);
	}
}
