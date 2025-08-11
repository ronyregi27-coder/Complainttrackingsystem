package learningjava;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
	/*	Scanner c = new Scanner(System.in);
		 Class u = new Class();
		 System.out.println(u.veichle);
		 System.out.println(u.colour);
		 System.out.println(u.id);
		 int choice;
		 do
		 {
			 System.out.println("1 for veichle");
			 System.out.println("2 for colur");
			 System.out.println("3 for id");
			 System.out.println("4 to exit");
			 System.out.println("enter your choice");
			 choice= c.nextInt();
			 
			 
		 }while(choice<4);
		 */
		 int[] grades = new int[10];
		 Scanner sc = new Scanner(System.in);
		 
		 for(int i=0;i<10;i++) {
			 int a= sc.nextInt();
			 grades[i]=a;
		 }
			 System.out.println(Arrays.toString(grades));
		 }

	}


