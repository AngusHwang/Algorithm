package problem2667;

import java.util.Scanner;

public class Main {
	
	static int max = 25;
	static int map[][] = new int[max][max];
	static int check[][] = new int[max][max];
	static int group[] = new int[500];
	
	static int dy[] = {0, 0, 1, -1};	
	static int dx[] = {1, -1, 0, 0};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int size = sc.nextInt();
		sc.nextLine();
		
		
		for(int i = 0; i < size; i++) {
			String str = sc.nextLine();
			for(int j = 0; j < size; j++) {
				map[i][j] = str.charAt(j)-48;
			}
		}

		int num = 1;

		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				if(map[i][j] == 1) {
					num++;
					new Main().dfs(i, j, size, num);
				}
			}
		}

//==================================================================================================
		
		
		num = 0;
		int count = 0;
		
		while(true) {
			num++;
			int sum = 0;
			
			for(int i = 0; i < size; i++) {
				for(int j = 0; j < size; j++) {
					sum += check[i][j];
				}
			}
			
			for(int i = 0; i < size; i++) {
				for(int j = 0; j < size; j++) {
					if(check[i][j] == num) {
						check[i][j] = 0;
						group[num] += 1;
					}
				}
			}
			
			if(sum == 0) {
				break;
			}
		}
		
		
		for(int i = 0; i < group.length; i++) {
			
			int tmp = 0;
			
			if(group[i] != 0) {
				count++;
			}
		}
		
		
		for(int i = 1; i < group.length; i++) {
			int tmp = 0;
			
			for(int j = i; j < group.length; j++) {
				if(group[i] > group[j] && i+1 <= group.length) {
					tmp = group[j];
					group[j] = group[i];
					group[i] = tmp;
				}
				
			}
		}

		group[0] = count;
		
		for(int i = 0; i < group.length; i++) {
			if(group[i] != 0) {
				System.out.println(group[i]);
			}
		}
		
		
	}
	
	
	public void dfs(int a, int b, int n, int c) { // a = 시작 행, b = 시작 열, c = 단지 이름, n = 맵 크기
		
		if(map[a][b] == 1) {
			map[a][b] = 0;
			check[a][b] = c;
		}
		
		
		int x = 0;
		int y = 0;
		
		for(int i = 0; i < 4; i++) {
			y = a + dy[i];
			x = b + dx[i];
			
			if(x >= 0 && y >= 0 && x < n && y < n) {
				
				if(map[y][x] == 1) {
					map[y][x] = 0;
					check[y][x] = c;					
					
				} else {
					continue;
				}
				
				dfs(y, x, n, c);
				
			}
			
			
		}
	}
	
	

}
