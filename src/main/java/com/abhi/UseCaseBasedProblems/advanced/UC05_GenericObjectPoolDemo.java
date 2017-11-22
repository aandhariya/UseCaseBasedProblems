package com.abhi.UseCaseBasedProblems.advanced;

import java.util.concurrent.LinkedBlockingQueue;

public class UC05_GenericObjectPoolDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CustomObjectPool cPool = new CustomObjectPool(5);
		
		CustomObject c1 = (CustomObject) cPool.get();
		CustomObject c2 = (CustomObject) cPool.get();
		CustomObject c3 = (CustomObject) cPool.get();
		CustomObject c4 = (CustomObject) cPool.get();
		
		
		cPool.release(c3);
		cPool.release(c2);
		
		// This program will fail when someone will release the same object twice. It will insert one more object to queue.
		// Need to restrict that 
		
	}

}

interface Pool<T>{
	public T get();
	public void release(T t);
	public void shutdown();
}

interface CreateObject<T>
{
	public T create();
}

abstract class ObjectPool<T> implements Pool<T>, CreateObject<T>
{

	private int size;
	private LinkedBlockingQueue<T> objectQueue;
	boolean isShutDown = false;
	
	
	public ObjectPool(int size)
	{
		this.size = size;
		objectQueue = new LinkedBlockingQueue<>(size);
		for(int i=0;i<size;i++)
		{
			objectQueue.offer((T)this.create());
		}
	}
	
	@Override
	public T get() {
		if(!isShutDown)
		{
			if(!objectQueue.isEmpty())
			{
				try {
					T t = objectQueue.take();
					System.out.println("taken out object :: " + t);
					return t;
					
				} catch (InterruptedException e) {
					e.printStackTrace();
					throw new RuntimeException("Thread interrupted while getting object from pool");
				}
			}
			throw new RuntimeException("Pool is Empty");
		}
		throw new RuntimeException("Pool has already been shutdown");
		
	}

	@Override
	public void release(T t) {
		try {
			objectQueue.put(t);
			System.out.println("Released Object :: " + t);
		} catch (InterruptedException e) {
			e.printStackTrace();
			throw new RuntimeException("Thread interrupted while releasing object to pool");
		}
	}

	@Override
	public void shutdown() {
		isShutDown = true;
		objectQueue.clear();
		objectQueue = null;
	}
	
}

class CustomObjectPool extends ObjectPool
{

	private int count=0;
	public CustomObjectPool(int size)
	{
		super(size);
	}
	
	@Override
	public CustomObject create() {
		return new CustomObject(count++);
	}

}

class CustomObject
{
	private int id;
	
	public CustomObject() {
	}
	
	public CustomObject(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "CustomObject [id=" + id + "]";
	}
	
	

	
}



