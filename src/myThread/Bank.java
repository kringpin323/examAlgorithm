package myThread;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Bank {
	static final int capacity = 100;
	public double[] accounts;
	private Lock bankLock = new ReentrantLock(true);
	private volatile boolean done;
	final Map<String,Double> accounts2 = new HashMap<>();
	
	private ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
	
	private Lock readLock = rwl.readLock();
	private Lock writeLock = rwl.writeLock();
	
	// Thread-Local Variables
	public static final ThreadLocal<SimpleDateFormat> dateFormat = 
			new ThreadLocal<SimpleDateFormat>(){
		protected SimpleDateFormat initialValue(){
			return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		}
	};
	
	public static final SimpleDateFormat dataFormatNotLocal = 
			new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	public boolean isDone(){return done;}
	public void setDone(){done = true;}
	
	
	private Condition sufficientFunds;
	
	public Bank(){
		sufficientFunds = bankLock.newCondition();
		accounts = new double[capacity];
		for(int i=0;i<accounts.length-1;i++){
			accounts[i] = 10000;// 初始化
		}
	}
	
	public int size(){
		return capacity;
	}
	
	public synchronized void testmethod1(){
//		bankLock.lock();
		
		try{
			System.out.println("testmethod1：告诉你很神奇因为和你想的不一样");
			System.out.println(Thread.currentThread()+" 锁没释放@@@@1");
			Thread.currentThread().sleep(1000000000);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		finally{
//			bankLock.unlock();
		}
	}
	
	public synchronized void testmethod2(){
//		bankLock.lock();
		
		try{
			System.out.println("testmethod2：告诉你很神奇2因为和你想的不一样");
			System.out.println(Thread.currentThread()+" 锁没释放@@@@2");
			Thread.currentThread().sleep(1000000000);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		finally{
//			bankLock.unlock();
		}
	}
	
	public void transfer(int from, int to, double amount){
//		bankLock.lock();
		// 添加写锁
		writeLock.lock();
		try{
			while(accounts[from]<amount){
				System.out.println("你的账户没钱了！");
				sufficientFunds.await();// 当条件成立的时候，等待而且让出锁
			}
			
			System.out.println(Thread.currentThread()+" 锁没释放");
			// 这时候会一直持有锁
			Thread.currentThread().sleep(1000000000);
			
			accounts[from] -= amount;
			System.out.printf(" %10.2f from %d to %d",amount,from ,to);
			accounts[to] += amount;
			System.out.printf("Total Balance : %10.2f%n ",getTotalBalance());
			sufficientFunds.signalAll();
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		finally{
			writeLock.unlock();
		}
	}
	
	// 由于是get method ，只需要读锁
	public double getTotalBalance(){
		readLock.lock();
		try{
			double total=0;
			for(double num:accounts){
				total += num;
			}
			return total;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		finally{
			readLock.unlock();
		}
		return 0;
	}
}
