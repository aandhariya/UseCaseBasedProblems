package com.abhi.UseCaseBasedProblems.basic;

import org.junit.Assert;
import org.junit.Test;

import com.abhi.UseCaseBasedProblems.basic.UC04_B_QuickSort;

public class UC04_B_QuickSortTest {

	@Test
	public void test() {
		int[] inputArr = {4,1,7,5,3,2,6};
		UC04_B_QuickSort ms = new UC04_B_QuickSort(inputArr);
		
		ms.sort();
		int[] expectedOutput1 = {1,2,3,4,5,6,7};
		Assert.assertArrayEquals(expectedOutput1, ms.getInputArr());
	
		ms.setInputArr(new int[]{12,45,23,56,12,56,67,87,99,123,-1});  

		ms.sort();
		int[] expectedOutput2 = {-1,12,12,23,45,56,56,67,87,99,123};
		Assert.assertArrayEquals(expectedOutput2, ms.getInputArr());
	}

}
