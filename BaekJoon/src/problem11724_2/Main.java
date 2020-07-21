package problem11724_2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static ArrayList<ArrayList<Integer>> al = new ArrayList<>();
	static Queue<Integer> qu = new LinkedList<Integer>();
	static int[] arr;
	static int n, m;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		arr = new int[n+1];
		
		for(int i = 0; i < n+1; i++) {
			al.add(new ArrayList<Integer>());
		}
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			al.get(a).add(b);
			al.get(b).add(a);
		}
		
		
		int color = 1;
		
		for(int i = 1; i < n+1; i++) {
			if(arr[i] == 0) {
				qu.clear();
				bfs(i, color);
				color++;
			}
		}
		
		bw.write(color - 1 + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	
	public static void bfs(int start, int color) {
		
		qu.add(start);
		arr[start] = color;
		while(!qu.isEmpty()) {
			int num = qu.poll();
			for(int a : al.get(num)) {
				if(arr[a] == 0) {
					qu.add(a);
					arr[a] = color;
				}
			}
		}
	}
	
}
