package problem2583;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int box[][];
	static int count;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int M = sc.nextInt();
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		box = new int[M][N];
		
		
		/*for(int i = 0; i < M; i++) {
			for(int j = 0; j < N; j++) {
				box[i][j] = 1;
			}
		}*/
		
		
		for(int i = 0; i < K; i++) {
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			
			int ny1 = M - (y1+1);
			int nx1 = x1;
			int ny2 = M - y2;
			int nx2 = x2-1;
			
			for(int k = ny2; k <= ny1; k++) {
				for(int l = nx1; l <= nx2; l++) {
					box[k][l] = 1;
				}
			}
			
		}
		
		ArrayList<Integer>sList = new ArrayList<Integer>();
		
		for(int i = 0; i < box.length; i++) {
			for(int j = 0; j < box[i].length; j++) {
				
				if(box[i][j] == 0) {
					sList.add(new Main().bfs(i, j));					
				}
			}
		}
		
		System.out.println(count);
		
		
		for(int i = 0; i < sList.size(); i++) {
			for(int j = 0; j < sList.size(); j++) {
				int tmp;
				int num1 = sList.get(i);
				int num2 = sList.get(j);
				
				if(num1 <= num2) {
					tmp = num1;
					sList.set(i, num2);
					sList.set(j, num1);
				}
				
			}
		}
		
		
		for(Integer s : sList) {
			System.out.print(s + " ");
		}
		
	}
	
	
	
	public int bfs(int startY, int startX) {
		Queue<Point> qu = new LinkedList<Point>();
		int dy[] = {1, -1, 0, 0};
		int dx[] = {0, 0, 1, -1};		
		
		box[startY][startX] = 1;
		qu.add(new Point(startY, startX));
		
		int surface = 1;
		
		while(!qu.isEmpty()) {
			
			Point point = qu.poll();
			
			for(int i = 0; i < 4; i++) {
				int y = point.y + dy[i];
				int x = point.x + dx[i];
				
				if(y >= 0 && x >= 0 && y < box.length && x < box[0].length) {
					if(box[y][x] == 0) {
						box[y][x] = 1;
						qu.add(new Point(y, x));
						
						surface++;
					}
				}
				
			}
		}
		count++;
		return surface;
	}
	
	
	
	
	
	public class Point {
		int y, x;
		
		public Point(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

}
