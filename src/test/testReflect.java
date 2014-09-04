package test;
import coreJavaInstance.*;

import java.lang.reflect.*;
import java.util.Arrays;
import java.util.Random;

import org.junit.Test;

public class testReflect {
	@Test
	public void testref(){
		Object[] elements = new Object[1000];
		
		for(int i=0;i<elements.length;i++){
			Integer value = i+1;
			
			InvocationHandler handle = new TraceHandler(value);
			Object proxy = Proxy.newProxyInstance(null, new Class[]{Comparable.class}, handle);
			elements[i] = proxy;
			
		}
		
		// 0 和 指定值（这里是elements.length，不包括）之间的随机值，现在应该是 1 到 elements.length
		Integer key = new Random().nextInt(elements.length) + 1;
		int result = Arrays.binarySearch(elements, key);
		if(result>= 0) System.out.println(elements[result]);
	}
}
