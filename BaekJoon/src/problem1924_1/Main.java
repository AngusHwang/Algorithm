package problem1924_1;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		new Main().userSolution();
	}
	
	public void userSolution() {
		Scanner sc = new Scanner(System.in);
		
		int month = sc.nextInt();
		int day = sc.nextInt();
		
		String days[] = new String[7];
		days[1] = "MON";
		days[2] = "TUE";
		days[3] = "WED";
		days[4] = "THU";
		days[5] = "FRI";
		days[6] = "SAT";
		days[0] = "SUN";
		
		String today = "";
		
		int count = 1;

		
		for(int i = 1; i <= month; i ++) {
			if(i == month) {
				if(i == 4 || i == 6 || i == 9 || i == 11) {
					for(int j = 1; j <= day; j++) {
						int rotate = count % 7;
						today = days[rotate];
						count++;
					}
				} else if(i == 2) {
					for(int j = 1; j <= day; j++) {
						int rotate = count % 7;
						today = days[rotate];
						count++;
					}
				} else {
					for(int j = 1; j <= day; j++) {
						int rotate = count % 7;
						today = days[rotate];
						count++;
					}
				}
			} else {
				if(i == 4 || i == 6 || i == 9 || i == 11) {
					for(int j = 1; j <= 30; j++) {
						int rotate = count % 7;
						today = days[rotate];
						count++;
					}
				} else if(i == 2) {
					for(int j = 1; j <= 28; j++) {
						int rotate = count % 7;
						today = days[rotate];
						count++;
					}
				} else {
					for(int j = 1; j <= 31; j++) {
						int rotate = count % 7;
						today = days[rotate];
						count++;
					}
				}
			}
			
		}
		
		System.out.println(today);
		
	}
	

}
