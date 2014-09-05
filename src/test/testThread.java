package test;

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
		
		Thread th23 = new Thread(new TransferRunnable(23,bank));
		Thread th50 = new Thread(new TransferRunnable(50,bank));
		
		th23.start();
		th50.start();
		
		while(true){
			try{
				Thread.sleep(1000000000);
			}catch(Exception ex){
				ex.printStackTrace();
			}
			
		}
	}
}
