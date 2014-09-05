package myThread;

public class myThreadPrint implements Runnable{
	int value;
	
	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public myThreadPrint(int value){
		this.value = value;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			try{
				while(!Thread.currentThread().isInterrupted()){
					System.out.println("running"+ value++);
					Thread.sleep(10);
					if(value >= 100)
						Thread.currentThread().interrupt();
				}
				break;
			}
			catch(Exception ex){
				// donothing
				ex.printStackTrace();
			}
		}
	}
	
	
}
