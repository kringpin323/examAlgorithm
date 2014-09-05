package JavaCollection;

import java.util.Enumeration;

public class MyEnumerator implements Enumeration{
	int count;
	int length;
	Object[] dataArray;
	
	public MyEnumerator(int count , int length, Object[] dataArray){
		this.count = count;
		this.length = length;
		this.dataArray = dataArray;
	}

	@Override
	public boolean hasMoreElements() {
		// TODO Auto-generated method stub
		return (count<length);
	}

	@Override
	public Object nextElement() {
		// TODO Auto-generated method stub
		return dataArray[count++];
	}
	
}
