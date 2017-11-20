package com.sapient.UseCaseBasedProblems.advanced;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class UC01_CustomThreadPoolDemo {
	
	public static void main(String s[])
	{
		CustomThreadPool pool = new CustomThreadPool(10);
		for(int i=0;i<100;i++)
		{
			pool.submit(new Task());
		}
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		pool.shutdown();
	}
	
	
}

class CustomThreadPool
{
	private AtomicBoolean isShutDown = new AtomicBoolean(false);
	private int poolCount;
	private ConcurrentLinkedQueue<Runnable> taskQueue  = new ConcurrentLinkedQueue<>();
	
	public CustomThreadPool(int poolCount) {
		this.poolCount = poolCount;
		
		for(int i=0;i<poolCount;i++)
		{
			Worker worker = new Worker(taskQueue);
			Thread workerThread = new Thread(worker,"Worker " + i);
			workerThread.start();
		}
	}
	
	/**
	 * default constructor creates Threadpool based on the available processors
	 */
	public CustomThreadPool() {
		this(Runtime.getRuntime().availableProcessors()/2);
	}

	
	public void submit(Runnable task)
	{
		taskQueue.add(task);
	}
	
	public void shutdown()
	{
		this.isShutDown.set(true);
		System.out.println("Shutting Down");
	}
	
	
	class Worker implements Runnable
	{
		ConcurrentLinkedQueue<Runnable> taskQueue;
		
		public Worker(ConcurrentLinkedQueue<Runnable> taskQueue) {
			this.taskQueue = taskQueue;
		}

		@Override
		public void run() {
			while(!isShutDown.get())
			{
				while(!taskQueue.isEmpty() && !isShutDown.get())
				{
					Task task =  (Task)taskQueue.poll();
					task.run();
				}
				
			}
		}
		
	}
}

/**
 * Custom Runnable Task
 *
 */
class Task implements Runnable{

	static AtomicInteger a = new AtomicInteger(0);
	@Override
	public void run() {
		System.out.println("Executing Runnable :: " + a.incrementAndGet() + " using Worker Thread :: " + Thread.currentThread().getName());
		
			
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
}


