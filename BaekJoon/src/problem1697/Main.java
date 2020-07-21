package problem1697;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int map[] = new int[100001];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int x = sc.nextInt();
		int y = sc.nextInt();
		
		new Main().bfs(x);
		/*
		for(int i = 0; i < map.length; i++) {
			System.out.print(map[i]);
			
		}
		*/
		
		System.out.println(map[y] - 1);
		
	}
	
	
	public void bfs(int x) {
		Queue<Integer> qu = new LinkedList<Integer>();
		
		qu.add(x);
		map[x] = 1;
		int num = 1;
		
		while(!qu.isEmpty()) {
			num++;
			int count = qu.size();
			
			for(int k = 0; k < count; k++) {
				int now = qu.poll();
				
				for(int i = 0; i < 3; i++) {
					int[] direction = {now + 1, now - 1, 2*now};
					
					if(direction[i] >= 0 && direction[i] < 100001) {
						if(map[direction[i]] == 0) {
							
							qu.add(direction[i]);
							map[direction[i]] = num;
							
						}
					}
					
				}
				
			}
			
			
			
			/*
			Scanner sc = new Scanner(System.in);
			sc.nextLine();
			for(int i = 0; i < map.length; i++) {
				System.out.print(map[i] + " ");
				
			}
			*/
			
			
			
		}
	}

}
