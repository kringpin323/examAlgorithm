package myThread;



public class TransferRunnable implements Runnable{
	Bank bank;
	static final double maxAmount = 10000.0;
	int fromAccount;
	
	public TransferRunnable(int fromAccount,Bank bank){
		this.bank = bank;
		this.fromAccount = fromAccount;
	}
	
	public void run(){
		try{
			int toAccount = (int)(bank.size()*Math.random());
			double amount = maxAmount * Math.random();
			bank.transfer(fromAccount, toAccount, amount);
			
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
}
