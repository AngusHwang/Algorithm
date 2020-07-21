package problem13458;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int a[] = new int[N];
		
		for(int i = 0; i < N; i++) {
			a[i] = sc.nextInt();
		}
		
		int b = sc.nextInt();
		int c = sc.nextInt();
		
		long count = 0;
		
		for(int i = 0; i < N; i++) {
			
			if(a[i] > 0) {
				a[i] = a[i] - b;
				count++;
			} else {
				continue;
			}
			
			if(a[i] > 0) {
				int num = a[i] / c;
				
				if(a[i] > num*c) {
					num++;
				}
				
				count += num;
			}
		}
		
		System.out.println(count);
		
	}
}