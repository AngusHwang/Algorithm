package problem1012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
	static int sizeY, sizeX;
	static int map[][];
	static int dy[] = {0, 0, 1, -1};
	static int dx[] = {1, -1, 0, 0};
	
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int cases = Integer.parseInt(st.nextToken());
		for(int n = 0; n < cases; n++) {
			st = new StringTokenizer(bf.readLine());
			sizeX = Integer.parseInt(st.nextToken());
			sizeY = Integer.parseInt(st.nextToken());
			
			map = new int[sizeY][sizeX];
			
			int quat = Integer.parseInt(st.nextToken());
			
			for(int i = 0; i < quat; i++) {
				st = new StringTokenizer(bf.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				map[y][x] = 1;
			}
			
			
			int num = 0;
			
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[i].length; j++) {
					if(map[i][j]==0)continue;
					num++;
					new Main().dfs(i,j);
				}
			}
			System.out.println(num);
			
		}
		bf.close();
	}
	
	
	public void dfs(int y, int x) {
		map[y][x] = 0;		
		for(int i = 0; i < 4; i++) {
			int a = y + dy[i];
			int b = x + dx[i];
			if(a < 0 || b < 0 || a >= sizeY || b >= sizeX || map[a][b] == 0) continue;
			dfs(a,b);
		}	
	}
	
}	