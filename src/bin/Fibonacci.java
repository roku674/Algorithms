package bin;
import java.util.Scanner;

//homework 1.5
class Fibonacci
{ 
	static int fib(int n) 
	{ 
		if (n <= 1) 
			return n; 
		return fib(n-1) + fib(n-2); 
	} 
	
	public static void main (String args[]) 
	{ 
		System.out.println("where f is Fibbonaci, f(x) = ? | type in a number for x");
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		System.out.println("f(" + n + ") = " + fib(n)); 
	}	
} 


