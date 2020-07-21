package problem1316;

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
		int count = 0;
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextLine();
		}
		
		
		for(int i = 0; i < n; i++) {
			char word[] = new char[arr[i].length()];
			
			word[0] = arr[i].charAt(0);
			
			for(int j = 0; j < arr[i].length()-1; j++) {
				word[j+1] = arr[i].charAt(j+1); 
				
				if(arr[i].charAt(j) == arr[i].charAt(j+1)) {
					word[j + 1] = arr[i].charAt(j+1);
					word[j] = 0;
				}
			}
			
			for(int j = 0; j < word.length-1; j++) {
				boolean check = true;
				
				for(int k = j+1; k < word.length; k++) {
					if(word[j] == word[k] && word[j] != 0) {
						count++;
						check = false;
						break;
					}
				}
				
				if(!check) {
					break;
				}
			}
			
		}
		
		System.out.println(n - count);
		
	}

}
