package problem14501;

import java.util.Scanner;

public class Main {
	static int result = 0;
	static int N = 0;
	static int[] T;
	static int[] P;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		T = new int[N];
		P = new int[N];

		for (int i = 0; i < N; i++) {
			T[i] = sc.nextInt();
			P[i] = sc.nextInt();
		}
		
		for(int i = 0; i < N; i++) {
			new Main().dfs(i, 0);
		}

		System.out.println(result);
	}

	public void dfs(int t, int p) {
		if (T[t] <= N - t) {
			p += P[t];
			
			if(p > result) result = p;
			
			for(int i = t+1; i < N; i++) {
				if(t + T[t] <= i) dfs(i, p);
			}
		}
	}
}
