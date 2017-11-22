package com.abhi.UseCaseBasedProblems.advanced;

public class UC04_ReentrantLockDemo {
	
	public static void main(String s[])
	{
		MyRunnableForLock obj = new MyRunnableForLock(new CustomReentrantLock());
		Thread t1 = new Thread(obj);
		Thread t2 = new Thread(obj);
		Thread t3 = new Thread(obj);
		
		t1.start();
		t2.start();
		t3.start();
	}
	
}

interface customLock{
	public void lock();
	public void unlock();
	public boolean tryLock();
}
class CustomReentrantLock implements customLock{
	private int holdCount = 0;
	private long currentThreadId = 0;

	@Override
	public synchronized void lock() {
		if(holdCount == 0)
		{
			holdCount++;
			currentThreadId = Thread.currentThread().getId();
		}
		else if(holdCount>0 && currentThreadId == Thread.currentThread().getId())
		{
			holdCount++;
		}
		else
		{
			try {
				wait();
				holdCount++;
				currentThreadId = Thread.currentThread().getId();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		
	}

	@Override
	public synchronized void unlock() {
		if(holdCount==0)
			throw new IllegalMonitorStateException();
		
		holdCount--;
		
		if(holdCount==0)
			notifyAll();
		
	}

	@Override
	public synchronized boolean tryLock() {
		if(holdCount==0)
		{
			lock();
			return true;
		}
		return false;
	}
	
}

class MyRunnableForLock implements Runnable{

	CustomReentrantLock lock;
	MyRunnableForLock(CustomReentrantLock lock)
	{
		this.lock = lock;
	}
	@Override
	public void run() {
		
		String threadName = Thread.currentThread().getName();
		
		System.out.println(threadName + " :: Entered run method. Will acquire lock now ");
		
		lock.lock();
		
		System.out.println(threadName + " :: First line after acquiring a lock ");
	
		System.out.println(threadName + " :: second line after acquiring a lock ");
	
		System.out.println(threadName + " :: third line after acquiring a lock ");
		
		lock.unlock();
		
		System.out.println(threadName + " :: released lock ");
		
	}
	
}