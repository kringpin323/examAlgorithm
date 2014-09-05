package myThread;



public class TransferRunnable implements Runnable{
	Bank bank;
	static final double maxAmount = 10000.0;
	
	int fromAccount;
	int toAccount;
	
	public void setFromAccount(int fromAccount) {
		this.fromAccount = fromAccount;
	}

	public void setToAccount(int toAccount) {
		this.toAccount = toAccount;
	}

	
	
	public TransferRunnable(Bank bank, int fromAccount,int toAccount){
		this.bank = bank;
		this.fromAccount = fromAccount;
		this.toAccount = toAccount;
	}
	
	public void run(){
		try{
			double amount = maxAmount * Math.random();
			bank.transfer(fromAccount, toAccount, amount);
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
}
