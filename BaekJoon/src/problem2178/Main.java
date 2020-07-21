package problem2178;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static int map[][] = new int[100][100];
	static int check[][] = new int[100][100];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int sizeY = sc.nextInt();
		int sizeX = sc.nextInt();
		sc.nextLine();
		
		
		for(int i = 0; i < sizeY; i++) {
			String str = sc.nextLine();
			for(int j = 0; j < sizeX; j++) {
				map[i][j] = str.charAt(j)-48;
			}
		}
		
		new Main().bfs(sizeY, sizeX);
		
		sc.close();
		
		System.out.println(map[sizeY-1][sizeX-1] - 1);
		
	}
	
	public void bfs(int sizeY, int sizeX) {
		Queue <Point> qu = new LinkedList<Point>();
		int y = 0;
		int x = 0;
		int num = 2;
		
		qu.add(new Point(y, x));
		int[] dx = {1, -1, 0, 0};
		int[] dy = {0, 0, 1, -1};
		
		map[0][0] = num;
		
		while(!qu.isEmpty()) {
			
			num++;
			int count = qu.size();
			for(int k = 0; k < count; k++) {
				Point now = qu.poll();
				int a = now.y;
				int b = now.x;
				
				for(int i = 0; i < 4; i++) {
					a = now.y + dy[i];
					b = now.x + dx[i];
					
					if(a >= 0 && b >= 0 && a < sizeY && b < sizeX) {
						if(map[a][b] == 1) {
							qu.add(new Point(a, b));
							map[a][b] = num;
						}
					}
				}
			}
		}
		
	}
	
	public static class Point{
		int y, x;
		public Point(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
	
}
