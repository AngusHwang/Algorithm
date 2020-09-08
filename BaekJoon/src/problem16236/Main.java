package problem16236;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N = 0;
	static int[][] map;
	static int[][] tmpMap;
	static int y;
	static int x;
	static int size = 2;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		map = new int[N][N];
		tmpMap = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
				
				if(map[i][j] == 9) {
					y = i;
					x = j;
					map[i][j] = 0;
				}
			}
		}
		
		int time = 0;
		int count = 0;
		
		while(true) {
			/*sc.nextLine();
			System.out.println("\n\n\n\n\n\n\n\n");
			System.out.println("size : " + size);
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					System.out.print(map[i][j] + " ");
				}
				System.out.println();
			}*/
			
			if(new Main().clearTmpMap()) {
				int[] routeInfo = new Main().findRoute();
				if(routeInfo.length != 0) {
					int fishY = routeInfo[0];
					int fishX = routeInfo[1];
					int route = routeInfo[2];
					
					map[fishY][fishX] = 0;
					y = fishY;
					x = fishX;
					count++;
					
					if(count == size) {
						size++;
						count = 0;
					}
					
					time += route;
				} else {
					break;
				}
			} else {
				break;
			}
		}
		
		System.out.println(time);
	}
	
	public int[] findRoute() {
		Queue<Point> qu = new LinkedList<Point>();
		
		int[] dy = {1, -1, 0, 0};
		int[] dx = {0, 0, 1, -1};
		
		qu.add(new Point(y, x));
		tmpMap[y][x] = 3;
		int time = 0;
		
		while(!qu.isEmpty()) {
			time++;
			
			int quSize = qu.size();
			int returnY = N;
			int returnX = N;
			
			for(int k = 0; k < quSize; k++) {
				Point pos = qu.poll();
				
				for(int i = 0; i < 4; i++) {
					int posY = pos.y + dy[i];
					int posX = pos.x + dx[i];
					
					if(posY < N && posX < N && posY >= 0 && posX >= 0) {
						if(tmpMap[posY][posX] == 0) {
							qu.add(new Point(posY, posX));
							tmpMap[posY][posX] = 3;
						} else if(tmpMap[posY][posX] == 2) {
							if(returnY > posY) {
								returnY = posY;
								returnX = posX;
							} else if (returnY == posY) {
								if(returnX > posX) {
									returnY = posY;
									returnX = posX;
								}
							}
						}
					}
				}				
			}
			if(returnY != N) {
				int[] arr = {returnY, returnX, time};
				return arr;
			}
		}
		
		int[] arr = {};
		return arr;
	}
	
	public static class Point{
		int y, x;
		public Point(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
	
	public boolean clearTmpMap() {
		int count = 0;
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(map[i][j] == 0) {
					tmpMap[i][j] = 0;
				} else if(map[i][j] > size) {
					tmpMap[i][j] = 1;
				} else if(map[i][j] == size) {
					tmpMap[i][j] = 0;
				} else if(map[i][j] < size) {
					tmpMap[i][j] = 2;
					count++;
				}
			}
		}
		
		if(count == 0) {
			return false;
		} else {
			return true;
		}
	}
}
