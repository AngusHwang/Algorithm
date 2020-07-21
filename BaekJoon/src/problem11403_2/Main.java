package problem11403_2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static int map[][];
	static int check[][];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		map = new int[num][num];
		check = new int[num][num];
		
		for(int i = 0; i < num; i++) {
			for(int j = 0; j < num; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		new Main().bfs();
		
		for(int i = 0; i < num; i++) {
			for(int j = 0; j < num; j++) {
				System.out.print(check[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	
	public void bfs() {
		Queue<Integer> qu = new LinkedList<Integer>();
		for(int start = 0; start < map.length; start++) {
			qu.add(start);
			while(!qu.isEmpty()) {
				int a = qu.poll();
				for(int i = 0; i < map.length; i++) {
					if(map[a][i] == 1 && check[start][i] == 0) {
						qu.add(i);
						check[start][i] = 1;
					}
				}
			}			
		}
	}
}