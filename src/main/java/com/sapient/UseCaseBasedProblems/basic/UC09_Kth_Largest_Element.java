package com.sapient.UseCaseBasedProblems.basic;

import java.util.Arrays;

public class UC09_Kth_Largest_Element {
	
	int[] inputArr;
	
	public UC09_Kth_Largest_Element(int[] inputArr) {
		super();
		this.inputArr = inputArr;
	}

	public int[] getInputArr() {
		return inputArr;
	}

	public void setInputArr(int[] inputArr) {
		this.inputArr = inputArr;
	}

	public int[] largestAndSecondLargest()
	{
		int[] output = new int[2];
		output[0] = 0;	// output[0] for largest
		output[1] = 0;  // output[1] for second largest
		for(int i=0;i<inputArr.length;i++)
		{
			if(output[0]<inputArr[i])
			{
				output[1]=output[0];
				output[0]=inputArr[i];
			}
			else if(output[1]<inputArr[i])
			{
				output[1]=inputArr[i];
			}
		}
		return output;
	}
	
	public int kthLargest(int k)
	{
		if(k<0 || k>(inputArr.length+1))
			return Integer.MAX_VALUE;
		int kthLargest = 0;
		Arrays.sort(inputArr);
		
		return inputArr[inputArr.length - k];
	}
	
	public int kthLargestStream(int k)
	{
		if(k<0 || k>(inputArr.length+1))
			return Integer.MAX_VALUE;
		return Arrays.stream(inputArr).sorted().limit(inputArr.length-k+1).max().getAsInt();
	}
	
	public static void main(String[] args) {
		int[] inputArr = {1,5,31,21,65,32,52,62,90};
		
		//1,5,21,31,32,52,62,65,90
		
		UC09_Kth_Largest_Element e = new UC09_Kth_Largest_Element(inputArr);
		int[] output = e.largestAndSecondLargest();
		
		for(int n:output)
		{
			System.out.println(n);
		}
		
		System.out.println("5th Largest Element :: " + e.kthLargest(2));
		System.out.println("5th Largest Element :: " + e.kthLargestStream(2));
		
	}
	
	

	
}
