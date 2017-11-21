package com.abhi.UseCaseBasedProblems.basic;

import java.util.LinkedList;
import java.util.Queue;

public class UC03_A_ProducerConsumerUsingWaitNotify {

public static void main(String[] args) {
		
		Queue sharedQ = new LinkedList();
		Thread[] pThreads = new Thread[10];
		Thread[] cThreads = new Thread[10];
		
		for(int i=0;i<10;i++)
		{
			pThreads[i] = new Thread(new ProducerWN(sharedQ, 10), "Producer " + i);
			cThreads[i] = new Thread(new ConsumerWN(sharedQ, 10), "Consumer " + i);
		}
		for(int i=0;i<10;i++)
		{
			pThreads[i].start();
			cThreads[i].start();
		}
	}


}

class ProducerWN implements Runnable{
	
	Queue sharedQ;
	int maxSize;
	
	public ProducerWN(Queue sharedQ, int maxSize) {
		this.sharedQ = sharedQ;
		this.maxSize = maxSize;
	}
	
	@Override
	public void run(){
		try {
			Thread.sleep(100);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		while(true)
		{
			synchronized(sharedQ)
			{
				while(sharedQ.size() == maxSize)
				{
					try {
						System.out.println("Queue is full");
						sharedQ.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				sharedQ.add(2);
				System.out.println(2 + " added by " + Thread.currentThread().getName());
				sharedQ.notifyAll();
				
			}
		}
		
	}
}

class ConsumerWN implements Runnable{

	Queue sharedQ;
	int maxSize;
	
	public ConsumerWN(Queue sharedQ, int maxSize)
	{
		this.sharedQ = sharedQ;
		this.maxSize = maxSize;
	}
	
	@Override
	public void run() {

		while(true)
		{
			synchronized (sharedQ) {
				while(sharedQ.isEmpty())
				{
					System.out.println("Shared Queue is empty");
					try {
						sharedQ.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.println(sharedQ.poll() + " polled by " + Thread.currentThread().getName());
				sharedQ.notifyAll();
			}
		}
	}
	
}
