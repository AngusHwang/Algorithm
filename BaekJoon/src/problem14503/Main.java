package problem14503;

import java.util.Scanner;

public class Main {
	
	static int area[][];
	static Position pos;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		area = new int[N][M];
		
		int r = sc.nextInt();
		int c = sc.nextInt();
		int d = sc.nextInt();
		
		new Main().setPos(r, c, d);

		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				area[i][j] = sc.nextInt();
			}
		}
		
		new Main().run();
		
		int count = 0;
		
		for(int i = 0 ; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(area[i][j] == 2) {
					count++;
				}
			}
		}
		
		System.out.println(count);
		
	}
	
	
	public void setPos(int r, int c, int d) {
		pos = new Position(r, c, d);
	}
	
	public void clean() {
		area[pos.r][pos.c] = 2;
	}
	
	public void turn() {
		if(pos.d == 0) pos.d = 3;
		else if(pos.d == 1) pos.d = 0;
		else if(pos.d == 2) pos.d = 1;
		else if(pos.d == 3) pos.d = 2;
	}
	
	public void forward() {
		if(pos.d == 0) pos.r = pos.r - 1;
		else if(pos.d == 1) pos.c = pos.c + 1;
		else if(pos.d == 2) pos.r = pos.r + 1;
		else if(pos.d == 3) pos.c = pos.c - 1;
	}
	
	public void back() {
		if(pos.d == 0) pos.r = pos.r + 1;
		else if(pos.d == 1) pos.c = pos.c - 1;
		else if(pos.d == 2) pos.r = pos.r - 1;
		else if(pos.d == 3) pos.c = pos.c + 1;
	}
	
	public boolean backScan() {
		if(pos.d == 0 && area[pos.r + 1][pos.c] != 1) return true;
		else if(pos.d == 1 && area[pos.r][pos.c - 1] != 1) return true;
		else if(pos.d == 2 && area[pos.r - 1][pos.c] != 1) return true;
		else if(pos.d == 3 && area[pos.r][pos.c + 1] != 1) return true;
		return false;
	}
	
	public boolean search() {
		if(pos.d == 0) {
			if(area[pos.r][pos.c - 1] == 0) {
				return true;
			}
		} else if(pos.d == 1) {
			if(area[pos.r - 1][pos.c] == 0) {
				return true;
			}
		} else if(pos.d == 2) {
			if(area[pos.r][pos.c + 1] == 0) {
				return true;
			}
		} else if(pos.d == 3) {
			if(area[pos.r + 1][ pos.c] == 0) {
				return true;
			}
		}
		return false;
		
	}
	
	public void run() {
		do {
			clean();
			if(search()) {
				turn();
				forward();
			} else if(area[pos.r + 1][pos.c] != 0 && area[pos.r - 1][pos.c] != 0 && area[pos.r][pos.c + 1] != 0 && area[pos.r][pos.c - 1] != 0 && backScan()) {
				back();
			} else {
				turn();
			}
			
		} while(area[pos.r + 1][pos.c] == 0 || area[pos.r - 1][pos.c] == 0 || area[pos.r][pos.c + 1] == 0 || area[pos.r][pos.c - 1] == 0 || backScan());
	}
	
	
	public class Position {
		int r, c ,d;	
		public Position(int r, int c, int d) {
			this.r = r;
			this.c = c;
			this.d = d;
		}		
	}
	
}