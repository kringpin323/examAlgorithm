package myThread;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * 这个类实现不完整，暂时不要使用
 * 2014-09-09
 * */
public class MatchCounter implements Callable<Integer>{
	private File directory;
	private String keyword;
	private int count;
	
	public MatchCounter(File directory, String keyword){
		this.directory = directory;
		this.keyword = keyword;
	}
	
	public Integer call(){
		count =0 ;
		try{
			File[] files = directory.listFiles();
			List<Future<Integer>> results = new ArrayList<>();
			
			for (File file : files)
				if (file.isDirectory())
				{
					MatchCounter counter = new MatchCounter(file,keyword);
					FutureTask<Integer> task = new
							FutureTask<>(counter);
					results.add(task);
					Thread t = new Thread(task);
					t.start();
				}
				else{
//					if (search(file)) count++;
				}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return count;
	}
}
