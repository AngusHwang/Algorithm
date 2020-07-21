package problem7576;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int map[][] = new int [1001][1001];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int sizeX = sc.nextInt();
		int sizeY = sc.nextInt();
		
		for(int i = 0; i < sizeY; i++) {
			for(int j = 0; j < sizeX; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		
		new Main().bfs(sizeY, sizeX);
		
		int day = 0;
		boolean check = false;
		
		for(int i = 0; i < sizeY; i++) {
			for(int j = 0; j < sizeX; j++) {
				if(map[i][j] > day) {
					day = map[i][j];
				} else if(map[i][j] == 0) {
					day = 0;
					check = true;
					break;
				}
			}
			if(check) {
				break;
			}
		}
		
		System.out.println(day - 1);
		
	}
	
	
	public void bfs(int sizeY, int sizeX) {
		
		Queue<Point> qu = new LinkedList<Point>();
		int dx[] = {1, -1, 0, 0};
		int dy[] = {0, 0, 1, -1};
		int num = 1;
		
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map[0].length; j++) {
				if(map[i][j] == 1) {
					qu.add(new Point(i, j));
				}
			}
		}
		
		
		while(!qu.isEmpty()) {
			
			int quSize = qu.size();
			num++;
			
			for(int i = 0; i < quSize; i++) {
				Point point = qu.poll();
				
				for(int j = 0; j < 4; j++) {
					int a = point.y + dy[j];
					int b = point.x + dx[j];
					
					if(a >= 0 && b >= 0 && a < sizeY && b < sizeX) {
						if(map[a][b] == 0) {
							map[a][b] = num;
							qu.add(new Point(a, b));
						}
					}
				}
			}
			
		}
		
		
		
	}
	
	
	public class Point {
		int x, y;
		
		public Point(int y, int x) {
			this.x = x;
			this.y = y;
		}
	}
	

}
