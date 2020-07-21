package problem1152;

import java.util.Scanner;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		new Main().userSolution();
		}
	public void userSolution() {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		String arr[] = str.split(" ");
		
		int count = 0;
		
		for(int i = 0; i < arr.length; i++) {
			if(!(arr[i].equals("")) && !(arr[i].equals(" "))) {
				count++;
			}
		}
		
		System.out.println(count);
		
	}
}
