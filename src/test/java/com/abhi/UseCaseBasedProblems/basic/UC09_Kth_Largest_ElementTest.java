package com.abhi.UseCaseBasedProblems.basic;

import static org.junit.Assert.*;

import org.junit.Test;

import com.abhi.UseCaseBasedProblems.basic.UC09_Kth_Largest_Element;

public class UC09_Kth_Largest_ElementTest {

	@Test
	public void testLargestAndSecondLargest() {
		int[] inputArr = {3,5,1,6,9,2,4,8};
		int[] expectedArr = {9,8};
		
		UC09_Kth_Largest_Element uc = new UC09_Kth_Largest_Element(inputArr);
		
		assertArrayEquals(expectedArr, uc.largestAndSecondLargest());
	}

	@Test
	public void testKthLargest() {
		int[] inputArr = {3,5,1,6,9,2,4,8};
		
		UC09_Kth_Largest_Element uc = new UC09_Kth_Largest_Element(inputArr);
		
		int expected = 5;
		assertEquals(expected, uc.kthLargest(4));
		
		expected = Integer.MAX_VALUE;
		assertEquals(expected, uc.kthLargest(-1));
		
		expected = 9;
		assertEquals(expected, uc.kthLargest(1));
		
		expected = 8;
		assertEquals(expected, uc.kthLargest(2));
	}

	@Test
	public void testKthLargestStream() {
int[] inputArr = {3,5,1,6,9,2,4,8};
		
		UC09_Kth_Largest_Element uc = new UC09_Kth_Largest_Element(inputArr);
		
		int expected = 5;
		assertEquals(expected, uc.kthLargestStream(4));
		
		expected = 9;
		assertEquals(expected, uc.kthLargestStream(1));
		
		expected = 8;
		assertEquals(expected, uc.kthLargestStream(2));
		
		expected = Integer.MAX_VALUE;
		assertEquals(expected, uc.kthLargestStream(-1));
	}

}
