package problem19236;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int[][][] map = new int[4][4][2]; // [y¡¬«•][x¡¬«•][0 : ≈©±‚ 1 : πÊ«‚]
	static Queue<int[][][]> qu = new LinkedList<int[][][]>();
	static ArrayList<int[][][]>arrList = new ArrayList<int[][][]>();
	static int[] dx = {0, -1, -1, -1, 0, 1, 1, 1};
	static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				map[i][j][0] = sc.nextInt();
				map[i][j][1] = sc.nextInt();
			}
		}
		
		map[0][0][0] = 17;
		qu.add(map);
		new Main().moveFish(map);
		new Main().moveShark();
		
		ArrayList<Integer>fishCountArr = new ArrayList<Integer>();
		for(int n = 0; n < arrList.size(); n++) {
			int[][][] map = arrList.get(n);
			int fishCount = 153;
			for(int i = 0; i < 4; i++) {
				for(int j = 0; j < 4; j++) {
					fishCount = fishCount - map[i][j][0];
				}
			}
			fishCountArr.add(fishCount);
		}
		
		int result = fishCountArr.get(0);
		for(int i = 0; i < fishCountArr.size(); i++) {
			if(result < fishCountArr.get(i)) result = fishCountArr.get(i);
		}
		
		System.out.println(result);
	}
	
	public int[][][] moveFish(int[][][] map) {
		for(int n = 1; n <= 16; n++) {
			boolean check = false;
			for(int i = 0; i < 4; i++) {
				for(int j = 0; j < 4; j++) {
					if(map[i][j][0] == n) {
						int dir = map[i][j][1]-1;
						
						for(int d = 0; d < 8; d++) {
							if(i + dy[dir] >= 0 && i + dy[dir] < 4 && j + dx[dir] >= 0 && j + dx[dir] < 4 && map[i + dy[dir]][j + dx[dir]][0] != 17) {
								int tmp1 = map[i + dy[dir]][j + dx[dir]][0];
								int tmp2 = map[i + dy[dir]][j + dx[dir]][1];
								
								map[i + dy[dir]][j + dx[dir]][0] = map[i][j][0];
								map[i + dy[dir]][j + dx[dir]][1] = dir+1;
								
								map[i][j][0] = tmp1;
								map[i][j][1] = tmp2;
								
								check = true;
								break;
							} else {
								dir = (dir + 1) % 8;
							}
						}
					}
					
					if(check) break;
				}
				if(check) break;
			}
		}
		
		return map;
	}
	
	public void moveShark() {
		while(!qu.isEmpty()) {
			int[][][] map = qu.poll();
			
			boolean check = false;
			
			for(int i = 0; i < 4; i++) {
				for(int j = 0; j < 4; j++) {
					
					if(map[i][j][0] == 17) {
						int dir = map[i][j][1]-1;
						int count = 0;
						for(int k = 1; k < 4; k++) {
							if(i + (dy[dir]*k) >= 0 && i + (dy[dir]*k) < 4 && j + (dx[dir]*k) >= 0 && j + (dx[dir]*k) < 4 && map[i + (dy[dir]*k)][j + (dx[dir]*k)][0] != 0) {
								int[][][] tmpMap = new int[4][4][2];
								for(int l = 0; l < 4; l++) {
									for(int m = 0; m < 4; m++) {
										tmpMap[l][m][0] = map[l][m][0];
										tmpMap[l][m][1] = map[l][m][1];
									}
								}
								
								tmpMap[i + (dy[dir]*k)][j + (dx[dir]*k)][0] = 17;
								tmpMap[i][j][0] = 0;
								tmpMap[i][j][1] = 0;
								
								qu.add(new Main().moveFish(tmpMap));
								count++;
							}
						}
						if(count == 0) arrList.add(map);
						check = true;
					}
					if(check) break;
				}
				if(check) break;
			}
		}
	}
}
