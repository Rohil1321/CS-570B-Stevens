// Romil Vimalbhai Shah
// 20008692
// CS 570 B
// Homework 2 Due on 20th Feb 2022

public class Complexity {
    // Implement a number of methods for a class Complexity
	
	// Method 1: Method that has time complexity O(n^2).
	public static void method1(int n)
	{
		
		System.out.println("Method 1 :- \n");
		
		int cn = 0;
		
		for (int i = 0; i < n; i++)
		{
			for (int j = 0; j < n; j++)
			{
				System.out.println("Operation " + cn);
				cn = cn + 1;
			}
			
		}
		
		System.out.println("\nSo, Complexity of O(n^2) ==> " + cn + "\n\n");
		
	}

	// Method 2: Method that has time complexity O(n^3).
	public static void method2(int n)
	{
		
		System.out.println("Method 2 :- \n");
		
		int cn = 0;
		
		for (int i = 0; i < n; i++)
		{
			for (int j = 0; j < n; j++)
			{
				for (int k = 0; k < n; k++)
				{
					System.out.println("Operation " + cn);
					cn = cn + 1;
				}
			}
		}
		
		System.out.println("\nSo, Complexity of O(n^3) ==> " + cn + "\n\n");
		
	}

	// Method 3: Method that has time complexity O(log n)
	public static void method3(int n)
	{
		
		System.out.println("Method 3 :- \n");
		
		int cn = 0;
		
		for (int i = n; i >1; i /= 2) 
		{
			System.out.println("Operation " + cn);
			cn = cn + 1;
		}
		
		System.out.println("\nSo, Complexity of O(log n) ==> " + cn + "\n\n");
		
	}

	// Method 4: Method that has time complexity O(n log n)
	public static void method4(int n) 
	{
		
		System.out.println("Method 4 :- \n");
		
		int cn = 0;
		
		for (int i = 0; i < n; i++) 
		{
			for (int j = 1; j < n; j *= 2) 
			{
				System.out.println("Operation " + cn);
				cn = cn + 1;
			}
		}
		
		System.out.println("\nSo, Complexity of O(n log n) ==> " + cn + "\n\n");
		
	}

	// Method 5: Method that has time complexity O(log log n)
	public static void method5(int n) 
	{
		
		System.out.println("Method 5 :- \n");
		
		int cn = 0;
		
		for (int i = 2; i < n; i = (int) Math.pow(i, 2))
		{
			System.out.println("Operation " + cn);
			cn = cn + 1;
		}
		
		System.out.println("\nSo, Complexity of O(log log n) ==> " + cn + "\n\n");
		
	}

	// Method 6: Method that has time complexity O(2^n)

	static int kc = 1;
	
	public static int method6(int n) 
	{
		if (n<=1)
		{
			kc++;
			
			System.out.println("Operation " + kc);
			return n;
		}

		kc++;
		 
		System.out.println("Operation " + kc);
		 
		return method6(n -1) + method6(n-1);
	}

	public static void main(String args[]) 
	{
		method1(7);
		
		method2(4);
		
		method3(512);
		
		method4(32);
		
		method5(1024);
		
		System.out.println("Method 6 :- \n");
		method6(7);
		System.out.println("\nSo, Complexity of O(2^n) ==> " + kc);
	}
}