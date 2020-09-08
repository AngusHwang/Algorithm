package problem2206_MemoryOut;

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
			}
		}
		
		System.out.println(bfs());
	}
	
	public static int bfs() {
		Queue<Pos> qu = new LinkedList<Pos>();
		int count = 1;
		qu.add(new Pos(0, 0, 0));
		visit[0][0] = 1;
		
		while(!qu.isEmpty()) {
			int size = qu.size();
			count++;
			
			if(visit[N - 1][M - 1] > 0) {
				return count;
			}
			for(int i = 0; i < size; i++) {
				Pos position = qu.poll();
				
				for(int j = 0; j < 4; j++) {
					int Y = position.y + dy[j];
					int X = position.x + dx[j];
					
					if(Y < 0 || Y >= N || X < 0 || X >= M) continue;
					if(!(visit[Y][X] == 0 || visit[Y][X] > position.b)) continue;
					
					if(map[Y][X] == 0) {
						visit[Y][X] = position.b+1;
						qu.add(new Pos(Y, X, position.b));
					} else if(map[Y][X] == 1 && position.b == 0) {
						visit[Y][X] = position.b+2;
						qu.add(new Pos(Y, X, position.b+1));
					}
				}
			}
		}
		
		return -1;
	}
	
}