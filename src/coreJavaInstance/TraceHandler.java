package coreJavaInstance;

import java.lang.reflect.*;
import java.util.*;

/**
 * 代理类
 * */
public class TraceHandler implements InvocationHandler{
	// 反射
	private Object target;
	
	public TraceHandler(Object t){
		target= t;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		// TODO Auto-generated method stub
		System.out.print(target);
		System.out.print("."+method.getName()+"(");
		if(args != null){
			
			for(int i=0;i<args.length;i++){
				System.out.print(args[i]);
				if(i<args.length-1) System.out.print(", ");
			}
		}
		System.out.println(")");
		// invoke actual method
		return method.invoke(target, args);
	}
	
}
