package problem14499;

import java.util.Scanner;

public class Main {
	static int [] row = {0, 0, 0};
	// À­¸é row[1]
	static int [] col = {0, 0, 0, 0};
	// À­¸é col[1], ¾Æ·§¸é col[3]
	static int r;
	static int c;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int [][] map = new int[N][M];
		r = sc.nextInt();
		c = sc.nextInt();
		int k = sc.nextInt();
		int [] order = new int[k];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		for(int i = 0; i < k; i++) {
			order[i] = sc.nextInt();
		}
		
		
		for(int i = 0; i < k; i++) {
			int tmp = 0;
			int yn = 1;
			
			if(order[i] == 1) {
				if(c == M-1) {yn = 0; continue;}
				c++;
				
				tmp = row[2];
				row[2] = row[1];
				row[1] = row[0];
				row[0] = col[3];
				col[3] = tmp;
				
				col[1] = row[1];
			} else if(order[i] == 2) {
				if(c == 0) {yn = 0; continue;}
				c--;
				
				tmp = row[0];
				row[0] = row[1];
				row[1] = row[2];
				row[2] = col[3];
				col[3] = tmp;
				
				col[1] = row[1];
			} else if(order[i] == 3) {
				if(r == 0) {yn = 0; continue;}
				r--;
				
				tmp = col[0];
				col[0] = col[1];
				col[1] = col[2];
				col[2] = col[3];
				col[3] = tmp;
				
				row[1] = col[1];
			} else if(order[i] == 4) {
				if(r == N-1) {yn = 0; continue;}
				r++;
				
				tmp = col[3];
				col[3] = col[2];
				col[2] = col[1];
				col[1] = col[0];
				col[0] = tmp;
				
				row[1] = col[1];
			}
			
			if(yn != 0) {
				if(map[r][c] == 0) {
					map[r][c] = col[3];
					System.out.println(row[1]);
				} else {
					col[3] = map[r][c];
					map[r][c] = 0;
					System.out.println(row[1]);
				}
			}
		}
		
	}
}
