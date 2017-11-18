package com.sapient.UseCaseBasedProblems.basic;

import static org.junit.Assert.*;

import org.junit.Test;

public class UC05_FibonacciTest {

	@Test
	public void fibonacciRecursiveTest() {
		assertEquals("0 1 1 2 3 5 8 13 21", UC05_Fibonacci.fibonacciRecursive(8));
		assertEquals("0", UC05_Fibonacci.fibonacciRecursive(0));
		assertEquals("0 1", UC05_Fibonacci.fibonacciRecursive(1));
	}
	
	@Test
	public void fibonacciIterativeTest() {
		assertEquals("0 1 1 2 3 5 8 13 21", UC05_Fibonacci.fibonacciIterative(8));
		assertEquals("0", UC05_Fibonacci.fibonacciIterative(0));
		assertEquals("0 1", UC05_Fibonacci.fibonacciIterative(1));
	}
	
	@Test
	public void fibonacciDynamicTest() {
		assertEquals("0 1 1 2 3 5 8 13 21", UC05_Fibonacci.fibonacciDynamic(8));
		assertEquals("0", UC05_Fibonacci.fibonacciDynamic(0));
		assertEquals("0 1", UC05_Fibonacci.fibonacciDynamic(1));
	}

}
