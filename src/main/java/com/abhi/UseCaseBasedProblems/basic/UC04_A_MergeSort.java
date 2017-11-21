package com.abhi.UseCaseBasedProblems.basic;

public class UC04_A_MergeSort {

	int[] arr;
	
	UC04_A_MergeSort(int[] arr)
	{
		this.arr = arr;
	}

	public int[] getArr() {
		return arr;
	}

	public void setArr(int[] arr) {
		this.arr = arr;
	}
	
	
	/**
	 * Main mergeSort() function which will internally calls
	 * overloaded recursive mergeSort(left,right) function
	 */
	public void sort()
	{
		sort(0,arr.length-1);
	}
	
	/**
	 * Overloaded Recursive mergeSort() function
	 * 
	 * @param left	left index of the input array
	 * @param right	right index of the input array
	 */
	public void sort(int left,int right)
	{
		int middle;  // middle index of the input array
		if(left<right)
		{
			middle = (left+right)/2;
			sort(left,middle);   // to divide the array -  left Half
			sort(middle+1,right); // Right Half
			
			merge(left,middle,right); // to merge sorted left and right halves
		}
	}
	
	/**
	 * merge function which will be internally called from sort() method.
	 * 
	 * @param left 		left index of the input array
	 * @param middle 	middle index of the input array
	 * @param right 	right index of the input array
	 */
	public void merge(int left,int middle,int right)
	{
		int n1,n2;
		int[] leftArray, rightArray;
		n1 = middle-left+1;
		n2 = right-middle;
		
		// Temporary left and right array
		leftArray = new int[n1];
		rightArray = new int[n2];
		
		for(int i=0; i<n1; i++)
		{
			leftArray[i]=arr[left+i];
		}
		for(int j=0;j<n2;j++)
		{
			rightArray[j]=arr[middle+1+j];
		}
		
		int i=0, 
			j=0, 
			k=left;
		
		while(i<leftArray.length && j<rightArray.length)
		{
			if(leftArray[i]<=rightArray[j])
			{
				arr[k] = leftArray[i];
				i++;
			}
			else
			{
				arr[k] = rightArray[j];
				j++;
			}
			k++;
		}
		
		while(i<leftArray.length)
		{
			arr[k] = leftArray[i];
			k++;
			i++;
		}
		while(j<rightArray.length)
		{
			arr[k] = rightArray[j];
			k++;
			j++;
		}
		
	}
	
	
	/**
	 * Function to display Array
	 */
	public void display()
	{
		for(int i=0;i<arr.length;i++)
		{
			System.out.print(" " + arr[i]);
		}
	}
	
	
	public static void main(String[] args) {
		int[] inputArr = {4,1,7,5,3,2,6};
		UC04_A_MergeSort ms = new UC04_A_MergeSort(inputArr);
		
		
		System.out.println("------------------\n Input \n------------------");
		ms.display();
		ms.sort();
		
		System.out.println("\n\n------------------\n After mergeSort() \n------------------");
		ms.display();
	}

	
}
