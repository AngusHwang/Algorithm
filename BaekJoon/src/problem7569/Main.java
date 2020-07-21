package problem7569;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int map[][][] = new int [101][101][101];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int sizeX = sc.nextInt();
		int sizeY = sc.nextInt();
		int sizeZ = sc.nextInt();
		
		for(int i = 0; i < sizeZ; i++) {
			for(int j = 0; j < sizeY; j++) {
				for(int k = 0; k < sizeX; k++) {
					map[i][j][k] = sc.nextInt();					
				}
			}
		}
		
		
		new Main().bfs(sizeZ, sizeY, sizeX);
		
		int day = 0;
		boolean check = false;
		
		for(int i = 0; i < sizeZ; i++) {
			for(int j = 0; j < sizeY; j++) {
				for(int k = 0; k < sizeX; k++) {
					if(map[i][j][k] > day) {
						day = map[i][j][k];
					} else if(map[i][j][k] == 0) {
						day = 0;
						check = true;
						break;
					}
				}
				if(check) {
					break;
				}
			}
			if(check) {
				break;
			}
		}
		
		System.out.println(day - 1);
		sc.close();
		
	}
	
	
	public void bfs(int sizeZ, int sizeY, int sizeX) {
		
		Queue<Point> qu = new LinkedList<Point>();
		int dx[] = {1, -1, 0, 0, 0, 0};
		int dy[] = {0, 0, 1, -1, 0, 0};
		int dz[] = {0, 0, 0, 0, 1, -1};
		int num = 1;
		
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map[0].length; j++) {
				for(int k = 0; k < map[0][0].length; k++)
				if(map[i][j][k] == 1) {
					qu.add(new Point(i, j, k));
				}
			}
		}
		
		
		while(!qu.isEmpty()) {
			
			int quSize = qu.size();
			num++;
			
			for(int i = 0; i < quSize; i++) {
				Point point = qu.poll();
				
				for(int j = 0; j < 6; j++) {
					int a = point.z + dz[j];
					int b = point.y + dy[j];
					int c = point.x + dx[j];
					
					if(a >= 0 && b >= 0 && c >= 0 && a < sizeZ && b < sizeY && c < sizeX) {
						if(map[a][b][c] == 0) {
							map[a][b][c] = num;
							qu.add(new Point(a, b, c));
						}
					}
				}
				
			}
		}
	}
	
	
	public class Point {
		int x, y, z;
		
		public Point(int z, int y, int x) {
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}
	

}
