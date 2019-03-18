package bin;

import java.util.Arrays;
import java.util.Scanner;

public class Homework2 {
	
	public static int[][] matrices;
	
	public static void main(String[] args) {
		//find the best path
		/* take some sort of input of size of arrays that need to be multiplied
		 * If operation cannot be done stop and tell user
		 *  (code?)
		 *  uhhh dsplay the dynamic and greedy runtimes*/
		
		System.out.println("Input the total number of matrices");
		//scanning in the total number of rows as it is the total number of matrices i'll be dealing with
		Scanner scanInt = new Scanner(System.in);
		int amtMatrices = scanInt.nextInt();
		
		matrices = new int[amtMatrices][2];
		
		//Take in the matrices next
		
		for (int i = 0; i < amtMatrices; i++) {
			System.out.println("Please input matrix " + (i+1) + "'s size of x" );
			int xSize = scanInt.nextInt();
			matrices[i][0] = xSize;
			System.out.println("Please input matrix " + (i+1) + "'s size of y" );
			int ySize = scanInt.nextInt();
			matrices[i][1] = ySize;
		}
		scanInt.close();
		/*if (FindGreedyPath() == 00) {
			System.out.print("You cannot multiple all these matrices together");
		}
		else  {
			System.out.print("The time it takes greedy is " + FindGreedyPath());
		}*/
		
		if (FindDynamicPath() == 0) {
			System.out.print("You cannot multiple all these matrices together");
		}
		else {
			System.out.print("The time it takes dynamic is " + FindDynamicPath());
		}
		
		
		
		/*
		 for (int i = 0; i < matrices.length; i++) 
			  
	            for (int j = 0; j < matrices[i].length; j++) 
	                System.out.print(matrices[i][j] + " "); */
	}
	
	 static int FindDynamicPath() {
		 int path = 0;
		 
		 if (matrices.length == 1)
			 return 0;
		 
		 for (int i = 0; i < matrices.length; i++) {
			 if (matrices.length > i+1 && matrices[i][0] == matrices[i+1][1]) {
				 if (path == 0) {					 
					 path = 1;
					 path *= matrices[i][0] * matrices[i+1][1];
				 }
				 else {
					 path *= matrices[i][0] * matrices[i+1][1];
				 }
			 }				 
		 }
		 
		 return path;
	 }
	 
	 static int FindGreedyPath() {
		 int path = 0;
		 
		 if (matrices.length == 1)
			 return 0;
		 
		 return path;
	 }

}
