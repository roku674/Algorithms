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
		 *  uhhh dsplay the dynamic and greedy runtimes
		
		______GGGGGGGGGGGG____GGGGGGGGGGGG
		_____GGG_____________GGG__________
		____GGG_____________GGG___________
		___GGG_____________GGG____________
		___GGG_____________GGG____________
		___GGG_____GGGGGGG_GGG_____GGGGGGG
		____GGG________GGG__GGG________GGG
		_____GGG_______GGG___GGG_______GGG
		______GGG______GGG____GGG______GGG
		_______GGGGGGGGGGG_____GGGGGGGGGGG */

		
		
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
		
		/* this is just for seeing whats in the set */
		System.out.print("{ ");
		for (int i = 0; i < matrices.length; i++)  {
			System.out.print("[");
            for (int j = 0; j < matrices[i].length; j++) {
                System.out.print(matrices[i][j]);
                if (j != matrices[i].length -1) System.out.print(",");               
            }
            System.out.print("]");
            
            if (i == 0) {
            	System.out.print(" , ");
            }
		}
		System.out.print(" }");
		System.out.println();
		/*
		int temp = FindGreedyPath();
		if (temp == 0) {
			System.out.println("You cannot multiply all these matrices together");
		}
		else  {
			System.out.println("The time it takes my greedy dog is (n^3) " + temp);
		}*/
		System.out.println(""); 
		int temp = FindDynamicPath(matrices, 1, matrices.length-1);
		
		if (temp == 0) {
			System.out.println("You cannot multiple all these matrices together");
		}
		else {
			System.out.println("The time it takes dynamic is " + temp);
		} 		
		
		System.out.println();
	}
	
	 static int FindDynamicPath(int matrices[][], int m, int n) {
		 
		 if (matrices.length <= 1)
			 return 0;
		 
		 int path = Integer.MAX_VALUE;
		 		  
	        for (int k=m; k<n; k++) 
	        { 
	            int count = FindDynamicPath(matrices, m, k) + 
	            			FindDynamicPath(matrices, k+1, n) + 
	                        matrices[m-1][0]*matrices[k][0]*matrices[n][0]; 
	  
	            if (count < path)  {
	            	path = count; 
	            }	               
	        } 
		 
		 return path ;
	 }
	 
	static double FindGreedyPath() {
		 double path = 0;
		 
		 if (matrices.length == 1)
			 return 0;	 

		 for (int i = 0; i < matrices.length; i++) {
			 for (int j = 1; i < matrices.length; i++) {
				 int temp = 0;
				 if(i+j <= matrices.length && 
						 matrices[i][1] == matrices[i+j][0] && 
						 temp < matrices[i][1] * matrices[i+j][0]  ) {
					 
					 temp = matrices[i][1] * matrices[i+j][0];
					 path += matrices[i][1] * matrices[i+j][0];
					 
				 }
				 if(i-j >= 0 && 
						 matrices[i][1] == matrices[i-j][0] &&
						 temp < matrices[i][1] * matrices[i-j][0]) {
					 
					 temp = matrices[i][1] * matrices[i-j][0];
					 path += matrices[i][1] * matrices[i-j][0];
					 
				 }				 
			 }
		 }
		 return path;	 		 
	 }

}
