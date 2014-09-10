package test;

import org.junit.Test;

import ForCallBack.Caller;
import ForCallBack.Client;
import ForCallBack.MyCallInterface;

/**
 * wiki上的回调定义：
 * 在计算机程序设计中，回调函数，或简称回调，是指通过函数参数传递到其它代码的，某一块可执行代码的引用。
 * 这一设计允许了底层代码调用在高层定义的子程序。
 * */
public class testCallBack {
	
	@Test
	public void tstCallBackSimple(){
		Caller caller = new Caller();
//		caller.setCallFunc(new Client());
		caller.setCallFunc(new MyCallInterface() {
			public void printName() {
				System.out.println("This is the Kingpin client printName method");
			}
		});
		caller.call();
	}
	
	// 没有使用 匿名对象的回调
	@Test
	public void tstCallBac(){
		Caller caller = new Caller();
		caller.setCallFunc(new Client());
		caller.call();
	}
}
