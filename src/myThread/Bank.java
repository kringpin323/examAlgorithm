package myThread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Bank {
	static final int capacity = 100;
	double[] accounts;
	private Lock bankLock = new ReentrantLock();
	
	public Bank(){
		accounts = new double[capacity];
		for(int i=0;i<accounts.length-1;i++){
			accounts[i] = 10000;// 初始化
		}
	}
	
	public int size(){
		return capacity;
	}
	
	public void transfer(int from, int to, double amount){
		bankLock.lock();
		
		try{
			System.out.println(Thread.currentThread());
			accounts[from] -= amount;
			System.out.printf(" %10.2f from %d to %d",amount,from ,to);
			accounts[to] += amount;
			System.out.printf("Total Balance : %10.2f%n ",getTotalBalance());
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
