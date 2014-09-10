package test;

import java.util.Date;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

import myThread.Bank;
import myThread.TransferRunnable;
import myThread.myThreadPrint;

import org.junit.Test;

public class testThread {
	@Test
	public void tstMTP(){
		Thread my = new Thread(new myThreadPrint(1));
		Thread my2 = new Thread(new myThreadPrint(50));
		System.out.println(my.getState());
		my.start();
		my2.start();
		my.setPriority(Thread.MAX_PRIORITY);
		my2.setPriority(Thread.MIN_PRIORITY);
		System.out.println(my.getState());
		int value = 0;

		while(true){
			try{
				//				System.out.println("doing");
				//				if( >= 100){
				//					System.out.println("main value: "+value);
				//					my.interrupt();
				//				}
				my2.yield();

				my2.join(100);
				System.out.println("my is interrrpted");
				System.out.println("my2 state() : "+my2.getState());
				break;
				//				if(my.isInterrupted()){
				//					System.out.println("my is Interrupted");
				//					break;
				//				}
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}
		while(true){
			try{
				Thread.sleep(100000000);
			}catch(Exception ex){
				ex.printStackTrace();
			}

		}
	}

	//	public static void main(String[] args) {
	//		Thread my = new Thread(new myThreadPrint(123));
	//		my.start();
	//		System.out.println("hello");
	//		while(true){
	//			try{
	//				Thread.sleep(1);
	//			}
	//			catch(Exception ex){
	//				ex.printStackTrace();
	//			}
	//			
	//		}
	//	}

	@Test
	public void tstBank(){
		Bank bank = new Bank();

		Thread th23 = new Thread(new TransferRunnable(bank,23,40));
		Thread th50 = new Thread(new TransferRunnable(bank,50,40));

		th23.start();
		th50.start();

		try{
			Thread.sleep(1000);
		}
		catch(Exception ex){
		}

		System.out.printf("23: %10.2f%n",bank.accounts[23]);
		System.out.printf("50: %10.2f%n",bank.accounts[50]);		
		System.out.printf("40: %10.2f%n",bank.accounts[40]);

		while(true){
			try{
				Thread.sleep(1000000000);
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}
	}

	class tstTh1 implements Runnable{
		Bank bank;
		public tstTh1(Bank bank){
			this.bank = bank;
		}
		@Override
		public void run() {
			// TODO Auto-generated method stub
			//			bank.testmethod1();
			Bank.testStaticMethod1();
//			String dateStamp = bank.dateFormat.get().format(new Date());
//			System.out.println("tstTh1: "+dateStamp);
//			String dateStampNotLocal = bank.dataFormatNotLocal.format(new Date());
//			System.out.println("tstTh1: dateStampNotLocal: "+dateStampNotLocal);
		}
	}

	class tstTh2 implements Runnable{
		Bank bank;
		public tstTh2(Bank bank){
			this.bank = bank;
		}
		@Override
		public void run() {
			// TODO Auto-generated method stub
			//			bank.testmethod2();
			Bank.testStaticMethod2();
//			String dateStamp = bank.dateFormat.get().format(new Date());
//			System.out.println("tstTh2: "+dateStamp);
//			String dateStampNotLocal = bank.dataFormatNotLocal.format(new Date());
//			System.out.println("tstTh2: dateStampNotLocal: "+dateStampNotLocal);
		}
	}

	// 从synchronized的原理处验证了我的猜想
	// 使用的是锁，每个method占用都会占据锁
	@Test
	public void tstBankSyc(){
		Bank bank = new Bank();


		Thread thread1 = new Thread(new tstTh1(bank));
		Thread thread2 = new Thread(new tstTh2(bank));

		thread1.start();
		thread2.start();


		while(true){
			try{
				Thread.currentThread().sleep(100000000);
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}
	}

	// 这个test例子写得不完整
	// 无法真正发挥 ThreadLocal 的作用
	@Test 
	public void tstThreadLocal(){
		Bank bank = new Bank();
		Thread thread1 = new Thread(new tstTh1(bank));
		Thread thread2 = new Thread(new tstTh2(bank));
		thread1.start();
		try{
			Thread.currentThread().sleep(1000);
		}
		catch(Exception ex){

		}
		thread2.start();
		while(true){
			try{
				Thread.currentThread().sleep(100000000);
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}
	}

	// 不太明白这个BlockingQueue想表达什么·
	@Test
	public void tstBlockingQueue(){
		Scanner in = new Scanner(System.in);
		System.out.println();
	}

	@Test
	public void tstConcurrent(){
		Set a1 = new ConcurrentSkipListSet<String>();
		Map a2 = new ConcurrentHashMap<String,String>();
		Map a3 = new ConcurrentSkipListMap<String,String>();
	}

	@Test
	public void tstCopyOnWrite(){

	}

	/**
	 * 通过 FutureTask 来执行 异步执行线程并且取出结果
	 * Callable接口类似于Runnable，从名字就可以看出来了，
	 * 但是Runnable不会返回结果，并且无法抛出返回结果的异常，
	 * 而Callable功能更强大一些，被线程执行后，可以返回值，
	 * 这个返回值可以被Future拿到，也就是说，Future可以拿到异步执行任务的返回值
	 * */
	@Test
	public void tstCallable(){
		Callable<Integer> callable = new Callable<Integer>() {
			public Integer call() throws Exception {
				return new Random().nextInt(100);
			}
		};
		FutureTask<Integer> future = new FutureTask<Integer>(callable);
		new Thread(future).start();
		try {
			Thread.sleep(1000);// 可能做一些事情
			// 假设有一个很耗时的返回值需要计算，并且这个返回值不是立刻需要的话，那么就可以使用这个组合，
			// 用另一个线程去计算返回值，而当前线程在使用这个返回值之前可以做其它的操作，等到需要这个返回值时，再通过Future得到，岂不美哉
			// 拿到异步执行任务的返回值
			System.out.println(future.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void tstExecutor(){
		ExecutorService threadPool = Executors.newCachedThreadPool();
		// CompletionService整合了Executor和BlockingQueue的功能
		// 详情请参考 Java 并发编程实践
		CompletionService<Integer> cs = new ExecutorCompletionService<Integer>(threadPool);
		for(int i =1;i<5 ;i++){
			final int taskID = i;
			cs.submit(new Callable<Integer>(){
				public Integer call() throws Exception{
					return taskID;
				}
			});
		}

		// 可能做一些事情
		
		
		for(int i = 1; i < 5; i++) {
			try {
				System.out.println(cs.take().get());
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		}
	}
	
	// 未认真看，有点着急了，Java Concurrent是一块很大的题目，认真点
	// 2014-09-09
	@Test
	public void tstFutureAndExecutor(){
		ExecutorService threadPool = Executors.newSingleThreadExecutor();
		Future<Integer> future = threadPool.submit(new Callable<Integer>() {
			public Integer call() throws Exception {
				return new Random().nextInt(100);
			}
		});
		try {
			Thread.sleep(5000);// 可能做一些事情
			System.out.println(future.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}

	// core java 到这里未止了，接下来请处理Java IO
}
