package problem1924_2;

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
		
		int count = 0;
		
		for(int i = 1; i <= month; i ++) {
			if(i == month) {
				count += day;
				break;
			}
			
			if(i == 4 || i == 6 || i == 9 || i == 11) {
					count += 30;
				} else if(i == 2) {
					count += 28;
				} else {
					count += 31;
				}	
		}
		System.out.println(days[count%7]);	
	}
}
