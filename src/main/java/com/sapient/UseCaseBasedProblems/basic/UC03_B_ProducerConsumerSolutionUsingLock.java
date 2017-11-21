package com.sapient.UseCaseBasedProblems.basic;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class UC03_B_ProducerConsumerSolutionUsingLock {

public static void main(String[] args) throws InterruptedException {
		
		
		final Queue sharedQ = new LinkedList < Integer >();
		Lock lock = new ReentrantLock();
		Condition c = lock.newCondition();
		Thread[] producerThread = new Thread[10];
		Thread[] consumerThread = new Thread[10];
		
		
		for(int i=0 ;i<10;i++)
		{
			consumerThread[i] = new Thread(new Consumerl(sharedQ, 40, lock, c), "CONSUMER :: " + i);
			producerThread[i] = new Thread(new Producerl(sharedQ, 40, lock, c), "PRODUCER :: " + i);
			
			producerThread[i].start();
			consumerThread[i].start();
		}
		
		
		
	}

}

class Producerl implements Runnable
{
    private final Queue sharedQ;
    private int maxSize;
    private Lock l;
    private Condition c;
    
    public Producerl(Queue sharedQ, int maxSize, Lock l, Condition c)
    {
        this.sharedQ = sharedQ;
        this.maxSize = maxSize;
        this.l = l;
        this.c = c;
        
    }
     
    @Override
    public void run(){
         
        while(true)
        {
            l.lock();
            try{
            	 while(sharedQ.size()==maxSize)
                 {
                     try
                     {
                         System.out.println("Queue is full");
                         c.await();
                     }
                     catch(InterruptedException e)
                     {
                         e.printStackTrace();
                     }
                      
                 }
                 Random random = new Random(); 
                 int number = random.nextInt(100);
                 System.out.println(Thread.currentThread().getName() + " Producing value " + number);
                 sharedQ.add(number);
                 c.signalAll();
            }
            finally {
            	l.unlock();
            }
             
        }
    }
}
class Consumerl implements Runnable
{
    private final Queue sharedQ;
    private int maxSize;
    private Lock l;
    private Condition c;
    
    
    public Consumerl(Queue sharedQ, int maxSize, Lock l, Condition c)
    {
        this.sharedQ = sharedQ;
        this.maxSize = maxSize;
        this.l = l;
        this.c = c;
    }
     
    @Override
    public void run(){
        while(true)
        {
        	l.lock();
        	
            try {
                while(sharedQ.isEmpty())
                {
                    try {
                        System.out.println("Que is Empty");
                        c.await();
                    }
                    catch(InterruptedException e)
                    {
                        e.printStackTrace(); 
                    }
                }
                 
                int number = (int) sharedQ.poll();
                System.out.println(Thread.currentThread().getName() + " removing Element " + number);
                c.signalAll();
                 
            }
            finally {
            	l.unlock();
            }
        }
    }
     
}
