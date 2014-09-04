package test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Random;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.Test;



public class testLog {
	@Test
	public void tstLog(){
		int x = 100;
		Handler handlers= new java.util.logging.ConsoleHandler();
//		System.out.println("x= "+x);\
		Logger logger = Logger.getLogger("kingpinLogger");
//		logger.addHandler(handlers);
		logger.log(Level.INFO, "hello world");
		Logger.getGlobal().log(Level.INFO,"I am so sorry! ");
	}
	
	@Test
	public void tstDouble(){
		Random generator = new Random(System.currentTimeMillis()){
			public double nextDouble(){
				double result = super.nextDouble();
				Logger logger = Logger.getLogger("kingpinLogger");
//				logger.log(Level.INFO,"nextDouble: "+result);
				Logger.getGlobal().log(Level.INFO,"nextDouble: ");
				return result;
			}
		};
		
		generator.nextInt();
//		Logger.getGlobal().log(Level.INFO,"nextDouble: ");
		System.out.println(generator.nextDouble());
	}
	
	@Test
	public void tstStack(){
		Thread.dumpStack();
	}
	
	@Test
	public void tstSysErr(){
		// 这是一个失败的尝试
		PrintStream out = new PrintStream(new ByteArrayOutputStream());
		new Throwable().printStackTrace(out);
		String description = out.toString();
		System.out.println(description);
	}
	
	
}
