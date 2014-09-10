package ForCallBack;

/**
 * 理解 callback 回调
 * 
 * */
public class Caller {
	private MyCallInterface callInterface;

	public Caller() {
	}

	public void setCallFunc(MyCallInterface callInterface) {
		this.callInterface = callInterface;
	}

	public void call() {
		callInterface.printName();
	}
}
