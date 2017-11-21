package com.abhi.UseCaseBasedProblems.advanced;

import java.util.concurrent.atomic.AtomicInteger;

public class UC02_B_CustomCyclicBarrierDemo {

	public static void main(String[] args) {
		CustomCyclicBarrier cb = new CustomCyclicBarrier(4, new Runnable() {
			
			@Override
			public void run() {
				System.out.println("----------------");
				
			}
		});
		Thread t1 = new Thread(new MyRunnableForCB(cb));
		Thread t2 = new Thread(new MyRunnableForCB(cb));
		Thread t3 = new Thread(new MyRunnableForCB(cb));
		Thread t4 = new Thread(new MyRunnableForCB(cb));

		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}

}

class MyRunnableForCB implements Runnable
{
	CustomCyclicBarrier cb;
	private static AtomicInteger a = new AtomicInteger(0);
	
	public MyRunnableForCB(CustomCyclicBarrier cb) {
		this.cb = cb;
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
		cb.await();
		System.out.println("Running " + a.incrementAndGet());
		cb.await();
		System.out.println("Running " + a.incrementAndGet());
		cb.await();
	}
	
}

class CustomCyclicBarrier
{
	private static int initialParties = 0;
	private static int awaitingParties = 0;
	private Runnable barrierAction = null;
	
	public CustomCyclicBarrier(int parties, Runnable barrierAction)
	{
		initialParties = parties;
		awaitingParties = parties;
		this.barrierAction = barrierAction;
		
	}
	
	public CustomCyclicBarrier(int parties)
	{
		initialParties = parties;
		awaitingParties = parties;
	}
	
	public synchronized void await() 
	{
		awaitingParties--;
		if(awaitingParties>0)
		{
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else
		{
			this.notifyAll();
			awaitingParties = initialParties;
			
			if(barrierAction != null)
			{
				barrierAction.run();
			}
		}
		
		
		
		
	}
}


