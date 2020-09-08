package problem2606;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int[][] map;
	static int[] state;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		map = new int[n][n];
		state = new int[n];
		state[0] = 1;
		
		int line = sc.nextInt();
		
		
		for(int i = 0; i < line; i++) {
			int a = sc.nextInt() - 1;
			int b = sc.nextInt() - 1;
			
			map[a][b] = 1;
			map[b][a] = 1;
		}
		
		Queue<Integer> qu = new LinkedList<Integer>();
		qu.add(0);
		int count = 0;
		
		while(!qu.isEmpty()) {
			int num = qu.poll();
			
			for(int i = 0; i < n; i++) {
				if(state[i] == 0) {
					if(map[num][i] == 1 || map[i][num] == 1) {
						state[i] = 1;
						count++;
						
						qu.add(i);
					}
				}
			}
		}
		
		System.out.println(count);
	}
}