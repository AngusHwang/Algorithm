package problem2206;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static class Pos {
		int y;
		int x;
		int b; // º® ºÎ½Å È½¼ö
		public Pos(int y, int x, int b) {
			this.y = y;
			this.x = x;
			this.b = b;
		}
	}
	
	static int[][] map, visit;
	static int[] dy = new int[] {1, -1, 0, 0};
	static int[] dx = new int[] {0, 0, 1, -1};
	static int N, M;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);
		
		map = new int[N][M];
		visit = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			str = br.readLine().split("");
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(str[j]);
				visit[i][j] = Integer.MAX_VALUE;
			}
		}
		
		System.out.println(bfs());
	}
	
	public static int bfs() {
		Queue<Pos> qu = new LinkedList<Pos>();
		int count = 0;
		qu.add(new Pos(0, 0, 0));
		visit[0][0] = 0;
		
		while(!qu.isEmpty()) {
			int size = qu.size();
			count++;
			
			if(visit[N - 1][M - 1] != Integer.MAX_VALUE) {
				return count;
			}
			for(int i = 0; i < size; i++) {
				Pos position = qu.poll();
				
				for(int j = 0; j < 4; j++) {
					int Y = position.y + dy[j];
					int X = position.x + dx[j];
					
					if(Y >= 0 && Y < N && X >= 0 && X < M) {
						if(visit[Y][X] > position.b) {
							if(map[Y][X] == 0) {
								visit[Y][X] = position.b;
								qu.add(new Pos(Y, X, position.b));
							} else {
								if(position.b == 0) {
									visit[Y][X] = position.b+1;
									qu.add(new Pos(Y, X, position.b+1));
								}
							}
						}
					}
				}
			}
		}
		
		return -1;
	}
	
}