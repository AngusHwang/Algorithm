package problem1002;

import java.util.Scanner;

public class Main {
   public static void main(String[] args) {
         new Main().userSolution();
      }
   public void userSolution() {
      Scanner sc = new Scanner(System.in);
      int n = sc.nextInt();
      
      double arr[][] = new double[n][6];
      
      for(int i = 0; i < n; i++) {
         for(int j = 0; j < 6; j++) {
            arr[i][j] = sc.nextDouble();
         }
      }
      
      for(int i = 0; i < n; i++) {
         double d = Math.pow((arr[i][0] - arr[i][3]), 2) + Math.pow((arr[i][1] - arr[i][4]), 2);
         double d1 = Math.sqrt(d);
         
         if(arr[i][2] == arr[i][5] && arr[i][0] == arr[i][3] && arr[i][1] == arr[i][4]) { // �ϳ��� ��
            System.out.println(-1);
         } else if(d1 > arr[i][2] + arr[i][5]) { // ���� ����
            System.out.println(0);
         } else if((arr[i][2] > arr[i][5] && arr[i][2] > (d1 + arr[i][5])) || (arr[i][2] < arr[i][5] && arr[i][5] >(d1 + arr[i][2]))) { // �� ���� �ٸ� ���� ���ο� �ְ� ������ ����
        	System.out.println(0);
         } else if(d1 == arr[i][2] + arr[i][5]) { // ����
            System.out.println(1);
         } else if(d1 == arr[i][2] - arr[i][5] || d1 == arr[i][5] - arr[i][2]) { // ����
            System.out.println(1);
         } else {
            System.out.println(2);
         }
      }
   }
}