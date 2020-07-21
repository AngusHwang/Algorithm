package problem14502;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static int map[][] = new int [8][8];
	static int check[][] = new int [8][8];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int sizeY = sc.nextInt();
		int sizeX = sc.nextInt();
		
		for(int i = 0; i < sizeY; i++) {
			for(int j = 0; j < sizeX; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		new Main().reset();
		
		int count = 0;
		
		
		for(int i = 0; i < sizeY; i++) {
			for(int j = 0; j < sizeX; j++) {
				int wallCount = 0;
				
				boolean check1 = false;
				if(check[i][j] == 0) {
					check[i][j] = 1;
					check1 = true;
					wallCount++;
				}
				
				for(int k = 0; k < sizeY; k++) {
					for(int l = 0; l < sizeX; l++) {
						boolean check2 = false;
						if(check[k][l] == 0) {
							check[k][l] = 1;
							check2 = true;
							wallCount++;
						}
						
						for(int m = 0; m < sizeY; m++) {
							for(int n = 0; n < sizeX; n++) {
								boolean check3 = false;
								if(check[m][n] == 0) {
									check[m][n] = 1;
									check3 = true;
									wallCount++;
								}
								
								new Main().bfs(sizeY, sizeX);
								
								if(count < new Main().safeCount(sizeY, sizeX) && wallCount == 3) {
									count = new Main().safeCount(sizeY, sizeX);
								}
								
								new Main().resetVirus();
								
								if(check3) {
									check[m][n] = 0;
									wallCount--;
								}
							}
						}
						if(check2) {
							check[k][l] = 0;
							wallCount--;
						}
					}
				}
				if(check1) {
					check[i][j] = 0;
					wallCount--;
				}
			}
		}
		
		System.out.println(count);
	}
	
	
	public void bfs(int sizeY, int sizeX) {
		Queue<Point> qu = new LinkedList<Point>();
		int dy[] = {1, -1, 0, 0};
		int dx[] = {0, 0, 1, -1};
		int num = 2;
		
		for(int i = 0; i < sizeY; i++) {
			for(int j = 0; j < sizeX; j++) {
				if(check[i][j] == 2) {
					qu.add(new Point(i, j));
				}
			}
		}
		
		while(!qu.isEmpty()) {
			num++;
			int size = qu.size();
			
			for(int i = 0; i < size; i++) {
				Point point = qu.poll();
				
				for(int j = 0; j < 4; j++) {
					int a = point.y + dy[j];
					int b = point.x + dx[j];
					
					if(a >= 0 && b >= 0 && a < sizeY && b < sizeX) {
						if(check[a][b] == 0) {
							check[a][b] = num;
							qu.add(new Point(a, b));
						}
					}
					
				}
				
			}
		}
		
	}
	
	
	public int safeCount(int sizeY, int sizeX) {
		int count = 0;
		
		for(int i = 0; i < sizeY; i++) {
			for(int j = 0; j < sizeX; j++) {
				if(check[i][j] == 0) {
					count++;
				}
			}
		}
		
		return count;
	}
	
	public void reset() {
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				check[i][j] = map[i][j];
			}
		}
	}
	
	public void resetVirus() {
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				if(check[i][j] > 2) {
					check[i][j] = 0;
				}
			}
		}
	}
	
	
	public class Point {
		int y, x;
		
		public Point(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
}