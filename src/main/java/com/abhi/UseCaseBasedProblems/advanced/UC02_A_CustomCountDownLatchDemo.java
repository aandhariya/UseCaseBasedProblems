package com.abhi.UseCaseBasedProblems.advanced;

import java.util.concurrent.atomic.AtomicInteger;

public class UC02_A_CustomCountDownLatchDemo {

	public static void main(String[] args) {
		
		CustomCountDownLatch c = new CustomCountDownLatch(4);

		Thread t1 = new Thread(new MyRunnable(c));
		Thread t2 = new Thread(new MyRunnable(c));
		Thread t3 = new Thread(new MyRunnable(c));
		Thread t4 = new Thread(new MyRunnable(c));
	
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		
		
		
		
		try {
			c.await();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Count Down Reaches to zero");
	}

}

class MyRunnable implements Runnable
{
	CustomCountDownLatch c;
	private static AtomicInteger a = new AtomicInteger(0);
	
	public MyRunnable(CustomCountDownLatch c) {
		this.c = c;
	}
	
	@Override
	public void run() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Running " + a.incrementAndGet());
		c.countDown();
	}
	
}


class CustomCountDownLatch
{
	private static volatile int count=0;
	
	public CustomCountDownLatch(int count) {
		if(count<0) 
			throw new IllegalArgumentException("count should be greater than 0");
		this.count = count;
	}
	
	public synchronized void await() throws InterruptedException, IllegalArgumentException
	{
		if(count>0)
			this.wait();
	}
	
	public synchronized void countDown()
	{
		count--;
		if(count==0)
			this.notifyAll();
	}
}
