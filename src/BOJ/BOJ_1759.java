package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1759 {
	static int L, C;
	static char[] inputs;
	static char[] pass;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		inputs = new char[C];
		pass = new char[L];
		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < C; i++) {
			inputs[i] = st.nextToken().charAt(0);
		}
		
		Arrays.sort(inputs);
		
		combi(0, 0);
	}
	
	static void combi(int depth, int start) {
		if(depth == L) {
			if(isValid()) {
				System.out.println(pass);
			}
			return;
		}
		
		for (int i = start; i < C; i++) {
			pass[depth] = inputs[i];
			combi(depth+1, i+1);
		}
	}
	
	static boolean isValid() {
		int vow = 0;
		int con = 0;
		
		for (char c : pass) {
			if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
				vow++;
			}else {
				con++;
			}
		}
		return vow>=1 && con>=2;
	}
}
