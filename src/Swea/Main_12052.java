package Swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_12052 {

	static int N, M;
	static char[][] map;
	static String ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine().trim());

		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			map = new char[N][M];

			for (int i = 0; i < N; i++) {
				String line = br.readLine();
				for (int j = 0; j < M; j++) {
					map[i][j] = line.charAt(j);
				}
			}

			ans = "YES";

			P:
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {

					if (map[i][j] == '#') {

						if (i + 1 >= N || j + 1 >= M) {
							ans = "NO";
							break P;
						}

						if (map[i][j + 1] == '.'
								|| map[i + 1][j] == '.'
								|| map[i + 1][j + 1] == '.') {
							ans = "NO";
							break P;
						}

						map[i][j] = '.';
						map[i][j + 1] = '.';
						map[i + 1][j] = '.';
						map[i + 1][j + 1] = '.';
					}
				}
			}

			System.out.println("#" + t + " " + ans);
		}
	}
}