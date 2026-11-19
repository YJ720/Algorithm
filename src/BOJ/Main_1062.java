package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1062 {	
	static int N, K;
	static int[] words;
	static int learned = 0;
	static int maxWords = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		// K가 5보다 작으면 접두, 접미사도 못 읽으니 0 출력
		if(K<5) {
			System.out.println(0);
			return;
		}else if(K==26) {		// K가 26이면 모든 글자를 읽을 수 있으니 N 출력
			System.out.println(N);
			return;
		}
		
		
		words = new int[N];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			// 접두, 접미사 각 4글자씩을 제외한 문자로 단어 배열에 비트 마스킹
			for (int j = 4; j < str.length() - 4; j++) {
				words[i] |= (1 << str.charAt(j) - 'a');
			}
		}
		
		// 공통 5개 마스킹
		learned |= (1<<('a' - 'a'));
		learned |= (1<<('n' - 'a'));
		learned |= (1<<('t' - 'a'));
		learned |= (1<<('i' - 'a'));
		learned |= (1<<('c' - 'a'));
		
		dfs(0, 0);
		
		System.out.println(maxWords);
	}
	
	// 백트래킹
	public static void dfs(int st, int cnt) {
		// 기저: K-5개의 조합 완성되면
		if(cnt == K-5) {
			int readCnt = 0;
			for (int i = 0; i < N; i++) {
				// 문자 조합으로 단어를 읽을 수 있는지
				if((words[i] & learned) == words[i]) {
					readCnt++;
				}
			}			
			// 최댓값 갱신
			maxWords = Math.max(maxWords, readCnt);
			return;
		}
		
		for (int i = st; i < 26; i++) {
			// 배우지 않은 문자이면
			if((learned & (1<<i)) == 0) {
				// 마스킹
				learned |= (1<<i);
				dfs(i+1, cnt+1);
				// 해제
				learned &= ~(1<<i);
			}
		}
	}
}
