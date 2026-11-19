package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2630 {
	static int[][] inputs;
	static int white;
	static int blue;
	
	public static void main(String[] args) throws  IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		inputs = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				inputs[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dvPower(0, 0, N);
		System.out.println(white);
		System.out.println(blue);
	}
	
	public static void dvPower(int row, int col, int size) {
		if(colorCheck(row, col, size)) {
			if(inputs[row][col] == 0) {
				white++;
			}else {
				blue++;
			}
			return;
		}
		
		int nextSize = size>>1;
		dvPower(row, col, nextSize);
		dvPower(row+nextSize, col, nextSize);
		dvPower(row, col+nextSize, nextSize);
		dvPower(row+nextSize, col+nextSize, nextSize);		
	}
	
	public static boolean colorCheck(int row, int col, int size) {
		int color = inputs[row][col];
		
		for (int i = row; i < row+size; i++) {
			for (int j = col; j < col+size; j++) {
				if(color != inputs[i][j])	return false;
			}
		}
		return true;
	}
}
