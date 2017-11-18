package com.sapient.UseCaseBasedProblems.basic;

import org.junit.Assert;
import org.junit.Test;

import junit.framework.TestSuite;


public class UC04_A_MergeSortTest extends TestSuite {

	@Test
	public void AverageCases() {
		int[] inputArr = {4,1,7,5,3,2,6};
		UC04_A_MergeSort ms = new UC04_A_MergeSort(inputArr);
		ms.sort();
		
		int[] expectedOutput1 = {1, 2, 3, 4, 5, 6, 7};
		Assert.assertArrayEquals(expectedOutput1, ms.getArr());
	
		ms.setArr(new int[]{12,45,23,56,12,56,67,87,99,123,-1});
		ms.sort();
		int[] expectedOutput2 = {-1,12,12,23,45,56,56,67,87,99,123};
		Assert.assertArrayEquals(expectedOutput2, ms.getArr());
	}
	
	@Test
	public void bestCase(){
		int[] inputArr = {1,2,3,4,5,6,7};
		UC04_A_MergeSort ms = new UC04_A_MergeSort(inputArr);
		ms.sort();
		
		int[] expectedOutput1 = {1, 2, 3, 4, 5, 6, 7};
		Assert.assertArrayEquals(expectedOutput1, ms.getArr());
	
		ms.setArr(new int[]{-6,-5,-4,-3,-2,-1,0,1,2,3,4,5,6});
		ms.sort();
		int[] expectedOutput2 = {-6,-5,-4,-3,-2,-1,0,1,2,3,4,5,6};
		Assert.assertArrayEquals(expectedOutput2, ms.getArr());
	}

	@Test
	public void worstCase(){
		int[] inputArr = {7,6,5,4,3,2,1};
		UC04_A_MergeSort ms = new UC04_A_MergeSort(inputArr);
		ms.sort();
		
		int[] expectedOutput1 = {1, 2, 3, 4, 5, 6, 7};
		Assert.assertArrayEquals(expectedOutput1, ms.getArr());
	
		ms.setArr(new int[]{6,5,4,3,2,1,0,-1,-2,-3,-4,-5,-6});
		ms.sort();
		int[] expectedOutput2 = {-6,-5,-4,-3,-2,-1,0,1,2,3,4,5,6};
		Assert.assertArrayEquals(expectedOutput2, ms.getArr());
	}
	
	@Test 
	public void sameElementCase(){
		int[] inputArr = {0,0,0,0,0,0};
		UC04_A_MergeSort ms = new UC04_A_MergeSort(inputArr);
		ms.sort();
		
		int[] expectedOutput1 = {0,0,0,0,0,0};
		Assert.assertArrayEquals(expectedOutput1, ms.getArr());
	}
}
