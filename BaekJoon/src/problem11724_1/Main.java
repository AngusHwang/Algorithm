package problem11724_1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static int line[][];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		line = new int[n][n];
		
		for(int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			line[a-1][b-1] = 1;
			line[b-1][a-1] = 1;
		}
		
		int count = 0;
		
		for(int i = 0; i < n; i++) {
			int sum = 0;
			for(int j = 0; j < n; j++) {
				sum += line[i][j];
			}
			if(sum == 0) {
				count++;
			}
		}

		System.out.println(new Main().bfs()+count);
		
	}
	
	
	
	
	public int bfs() {
		Queue<Integer> qu = new LinkedList<Integer>();
		int num = 1;
		for(int start = 0; start < line.length; start++) {
			qu.add(start);
			boolean check = true;
			while(!qu.isEmpty()) {
				int a = qu.poll();
				
				for(int i = 0; i < line.length; i++) {
					if(line[a][i] == 1) {
						if(check) {
							check = false;
							num++;
						}
						line[a][i] = num;
						qu.add(i);
					}
				}
			}
		}
		
		return num-1;
	}
}
