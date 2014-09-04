package test;

import org.junit.Test;

import coreJavaInstance.ArrayAlg;

public class testDouble {
	@Test 
	public void testDouble(){
		String abc = "aa";
		Double db = Double.NaN;
		
		System.out.println(db);
		if(db == Double.NaN) // never true
			System.out.println("db == Double.NaN ");
		if(Double.isNaN(db))
			System.out.println("Double.isNaN(db) ");
//		if(abc == Double.NaN){
//		}
		// hello world
		
		
		/**
		 * 这里输出时 0.8999999999999999
		 * */
		System.out.println(2.0- 1.1);
	}
	
	@Test
	public void testString(){
		String greeting = "hello";
		if(greeting == "hello")
			System.out.println("1");
		if(greeting.substring(0,3) == "hel")
			System.out.println("never appear ");
	}
	
	@Test
	public void tstInnerclass(){
		// 貌似这个InnerClass也没什么特别
		
		double[] d = new double[20];
		for(int i=0;i<d.length;i++){
			d[i] = 100 * Math.random();
		}
		ArrayAlg.Pair p = ArrayAlg.minmax(d);
		System.out.println("min= "+p.getFirst());
		System.out.println("max= "+p.getSecond());
	}
	
	
}
