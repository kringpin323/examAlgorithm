package myThread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Bank {
	static final int capacity = 100;
	public double[] accounts;
	private Lock bankLock = new ReentrantLock(true);
	
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
	
	public void testmethod1(){
		bankLock.lock();
		
		try{
			System.out.println("告诉你很神奇1因为和你想的不一样");
			System.out.println(Thread.currentThread()+" 锁没释放@@@@1");
			Thread.currentThread().sleep(1000000000);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		finally{
			bankLock.unlock();
		}
	}
	
	public void testmethod2(){
		bankLock.lock();
		
		try{
			System.out.println("告诉你很神奇2因为和你想的不一样");
			System.out.println(Thread.currentThread()+" 锁没释放@@@@2");
			Thread.currentThread().sleep(1000000000);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		finally{
			bankLock.unlock();
		}
	}
	
	public void transfer(int from, int to, double amount){
		bankLock.lock();
		
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
			bankLock.unlock();
		}
	}
	
	public double getTotalBalance(){
		double total=0;
		for(double num:accounts){
			total += num;
		}
		return total;
	}
}
