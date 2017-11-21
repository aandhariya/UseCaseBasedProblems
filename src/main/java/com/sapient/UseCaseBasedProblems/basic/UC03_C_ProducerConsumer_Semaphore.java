package com.sapient.UseCaseBasedProblems.basic;

import java.util.concurrent.Semaphore;
public class UC03_C_ProducerConsumer_Semaphore {

	public static void main(String[] args) {
		ProductQueue pq= new ProductQueue();
		SPproducer p = new SPproducer(pq);
	    SPconsumer c= new SPconsumer (pq);

	}

}


class ProductQueue{
	 // We must start with Producer semaphore
	Semaphore prod= new Semaphore(1);
	 // Start with consumer semaphore unavailable.
	Semaphore cons= new Semaphore(0);

	int id;
	
	public void putProductIntoQueue(int i) {
		try{
			prod.acquire();
			this.id=i;
			System.out.println(Thread.currentThread().getName() + " putting " + id + " in Queue");
			cons.release();
		}
		catch(InterruptedException e){
			e.printStackTrace();
		}
		
		}

	public void getFromProductQueue(int i) {
		try{
			cons.acquire();
			this.id=i;
			System.out.println(Thread.currentThread().getName() + " getting " + id + " from Queue");
			prod.release();
		}
		catch(InterruptedException e){
			e.printStackTrace();
		}
		
	}
	
}

class SPproducer extends Thread{
	
	ProductQueue queue;
	
	SPproducer(ProductQueue q)
	{
		this.queue= q;
		this.setName("Producer Thread");
		this.start();
	}
	
	public void run()
	{
		for(int i=1; i<5;i++)
		{
			queue.putProductIntoQueue(i);
		}
	}
}

class SPconsumer extends Thread{
	
	ProductQueue queue;
	
	SPconsumer(ProductQueue q)
	{
		this.queue= q;
		this.setName("Consumer Thread");
		this.start();
	}
	
	public void run()
	{
		for(int i=1; i<5;i++)
		{
			queue.getFromProductQueue(i);
		}
	}
}
