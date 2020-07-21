package problem1260_2;

import java.util.Scanner;

public class Main {
	
	private static int max = 1001;
	private static boolean check[] = new boolean [max];
	private static boolean line[][] = new boolean [max][max];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int v = sc.nextInt();
		
		for(int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			line[a][b] = true;
			line[b][a] = true;
		}
		
		new Main().dfs(v, n);
		
		new Main().reset();
		System.out.println();
		new Main().bfs(v, n);
		
	}
	
	public void reset() {
		
		for(int i = 0; i < max; i++) {
			check[i] = false;
		}
	}
	
	public void dfs(int start, int n) {
		
		check[start] = true;
		System.out.print(start + " ");
		
		for(int i = 1; i <= n; i++) {
			if(!check[i] && line[start][i]) {
				dfs(i, n);
			}
		}
		
	}
	
	static int[] queue = new int[max];
	static int front, rear;
	
	
	public void bfs(int start, int n) {
		front = rear = -1;
		
		push(start);
		check[start] = true;
		
		while(!isEmpty()) {
			int now = pop();
			System.out.print(now + " ");
			for(int i = 1; i <= n; i++) {
				if(!check[i] && line[now][i]) {
					push(i);
					check[i] = true;
				}
			}
		}
		
	}
	
	public int pop() {
		return queue[++front];
	}
	
	public void push(int num) {
		queue[++rear] = num;
	}
	
	public boolean isEmpty() {
		return rear == front;
	}
}
