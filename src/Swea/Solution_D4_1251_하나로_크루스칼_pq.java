package Swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

//크루스칼   224ms
/*
 * 비용 : 환경부담금(E) * 거리(L^2)
 * 거리에 대한 힌트는 없지만 행렬에서 거리는 맨하턴 거리 사용하기 
 *     L = |r1 -r2| + |c1-c2|
 * 
 * 
 */
public class Solution_D4_1251_하나로_크루스칼_pq {
	static class Edge implements Comparable<Edge> {
		int from, to;
		double cost;
		public Edge(int st, int ed) {
			super();
			this.from = st;
			this.to = ed;
			this.cost = distance(st, ed);
		}
		@Override
		public int compareTo(Edge o) {
			return Double.compare(cost, o.cost);
		}
		public double distance(int idx1, int idx2) {
			return (Math.pow(Math.abs(ArrX[idx1] - ArrX[idx2]), 2) + Math.pow(Math.abs(ArrY[idx1] - ArrY[idx2]), 2))
					* E;
		}
	}

	public static int N;
	public static int[] ArrX;
	public static int[] ArrY;
	public static int[] p;
	public static double E;

	public static void makeSet() {
		for (int i = 0; i < N; i++) {
			p[i] = i;
		}
	}

	static int find(int v) {
		if (v == p[v]) {
			return v;
		}
		return p[v] = find(p[v]);

	}

	public static boolean union(int a, int b) {
		int aroot = find(a);
		int broot = find(b);

		if (aroot == broot)
			return false;
		p[aroot] = broot;
		return true;
	}

	static Queue<Edge> pq = new PriorityQueue<>();

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(in.readLine());
			ArrX = new int[N];
			ArrY = new int[N];
			p = new int[N];
			pq.clear();

			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			for (int i = 0; i < N; i++) {
				ArrX[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(in.readLine(), " ");
			for (int i = 0; i < N; i++) {
				ArrY[i] = Integer.parseInt(st.nextToken());
			}
			E = Double.parseDouble(in.readLine());

			for (int i = 0; i < N - 1; i++) {
				for (int j = i + 1; j < N; j++) {
					pq.add(new Edge(i, j));
				}
			}

			makeSet();

			double sumCost = 0;
			long selectCnt = 0;
			while (true) {
				Edge tmp = pq.poll();
				if (union(tmp.from, tmp.to)) {
					sumCost += tmp.cost;
					if (++selectCnt >= N - 1)
						break;
				}
			}
			System.out.println("#" + tc + " " + Math.round(sumCost));

		} // tc
	}// main
}
