package com.abhi.UseCaseBasedProblems.basic;

public class UC05_Fibonacci {

		public static void main(String[] args) {

			System.out.println("---------------------");
			System.out.println("Recursive");
			System.out.println("---------------------");
			fibonacciRecursive(8);	
			
			System.out.println("\n\n---------------------");
			System.out.println("Iterative");
			System.out.println("---------------------");
			fibonacciIterative(8);
			
			System.out.println("\n\n---------------------");
			System.out.println("Dynamic");
			System.out.println("---------------------");
			fibonacciDynamic(8);
		}
		
		public static String fibonacciRecursive(int n)
		{
			StringBuilder sb = new StringBuilder();
			for(int i=0;i<=n;i++)
			{
				sb.append(fibonacciRecursiveInner(i) + " ");
				System.out.print(fibonacciRecursiveInner(i) + " ");
			}
			return sb.toString().trim();
		}
		
		public static int fibonacciRecursiveInner(int n)
		{
			if(n<=1)
			{
				return n;
			}
			else if(n>1)
			{
				return fibonacciRecursiveInner(n-1) + fibonacciRecursiveInner(n-2);
			}
			else
			{
				return -1;
			}
				
		}
		
		public static String fibonacciIterative(int n)
		{
			StringBuilder sb = new StringBuilder();
			for(int i=0;i<=n && i<2;i++)
			{
				sb.append(i + " ");
				System.out.print(i + " ");
			}
			
			if(n>1)
			{
				int n1 = 0;
				int n2 = 1;
				int temp =0;
				for(int i=2;i<=n;i++)
				{
					temp = n2;
					n2 = n1 + n2;
					n1=temp;
					System.out.print(n2 + " ");
					sb.append(n2 + " ");
				}
			}
			return sb.toString().trim();
		}
		
		public static String fibonacciDynamic(int n)
		{
			StringBuilder sb = new StringBuilder();
			int[] tempArr = new int[n+1];
			
			for(int i=0;i<=n && i<2;i++)
			{
				tempArr[i]=i;
				System.out.print(tempArr[i] + " ");
				sb.append(tempArr[i] + " ");
				
			}
			
			for(int i=2;i<=n;i++)
			{
				tempArr[i] = tempArr[i-1] + tempArr[i-2];
				System.out.print(tempArr[i] + " ");
				sb.append(tempArr[i] + " ");
			}
			return sb.toString().trim();
		}

	}



