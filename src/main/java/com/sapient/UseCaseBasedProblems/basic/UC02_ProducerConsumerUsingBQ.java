package com.sapient.UseCaseBasedProblems.basic;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class UC02_ProducerConsumerUsingBQ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BlockingQueue sharedQ = new ArrayBlockingQueue<>(10);
		
		Producer[] p = new Producer[10];
		Consumer[] c = new Consumer[10];
		
		Thread[] pThread = new Thread[10];
		for(int i=0;i<10;i++)
		{
			pThread[i] = new Thread(new Producer(sharedQ), "Producer " + i);
			pThread[i].start();
		}
		
		
		Thread[] cThread = new Thread[10];
		for(int i=0;i<10;i++)
		{
			cThread[i] = new Thread(new Consumer(sharedQ), "Consumer " + i);
			cThread[i].start();
		}
		
		
	}


}



class Producer implements Runnable{

	BlockingQueue sharedQ;
	
	Producer(BlockingQueue sharedQ)
	{
		this.sharedQ = sharedQ;
	}
	
	@Override
	public void run()
	{
		try {
			for(int i=0;i<100;i++)
			{
				sharedQ.put(i);
				System.out.println(i + " put " + Thread.currentThread().getName());
			}
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}

class Consumer implements Runnable{
	
	BlockingQueue sharedQ;
	
	Consumer(BlockingQueue sharedQ)
	{
		this.sharedQ = sharedQ;
	}
	
	@Override
	public void run()
	{
		try {
			while(true)
			{
				Integer i = (Integer)sharedQ.take();
				System.out.println(i + " taken " + Thread.currentThread().getName());
			}
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}


