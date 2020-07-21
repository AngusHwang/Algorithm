package problem8958;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		new Main().userSolution();
	}
	
	public void userSolution() {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		sc.nextLine();
		
		String arr[] = new String[n];
		
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextLine();
		}
		


		
		for(int i = 0; i < n; i++) {
			int sumscore[] = new int[arr[i].length()]; // 문제개수
			int score = 0;
			int sum = 0;
			
			for(int j = 0; j < arr[i].length(); j++) {
				if(arr[i].charAt(j) == 'O') {
					score++;
					sumscore[j] = score;
				} else if(arr[i].charAt(j) == 'X') {
					score = 0;
					sumscore[j] = score;
				}
			}
			
			for(int j = 0; j < sumscore.length; j++) {
				sum += sumscore[j];
			}
			
			System.out.println(sum);
			
		}
	}

}
