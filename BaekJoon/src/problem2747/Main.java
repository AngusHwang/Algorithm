package problem2747;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		new Main().run();


	}
	
	public void run() {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		fibonacci(num);
	}
	
	public void fibonacci(int num) {

		
		int fibo[] = new int[num+1];
		fibo[0] = 0;
		fibo[1] = 1;
		for(int i = 1; i < fibo.length-1; i++) {
			fibo[i+1] = fibo[i] + fibo[i-1];
		}
		
		int fiboSum = 0;
		
		for(int i = 0; i < fibo.length; i++) {
			fiboSum += fibo[i];
		}
		System.out.println(fibo[num]);
	}

}