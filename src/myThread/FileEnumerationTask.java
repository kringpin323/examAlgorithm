package myThread;

import java.io.File;
import java.util.concurrent.BlockingQueue;

public class FileEnumerationTask implements Runnable{
	public static File DUMMY = new File("");
	private BlockingQueue<File> queue;
	private File startingDirectory;
	
	public FileEnumerationTask(BlockingQueue<File> queue, File startingDirectory){
		this.queue = queue;
		this.startingDirectory = startingDirectory;
	}
	
	public void run(){
		try{
			enumrate(startingDirectory);
			queue.put(DUMMY);
		}
		catch(InterruptedException e){
			
		}
	}
	
	public void enumrate(File directory) throws InterruptedException{
		File[] files = directory.listFiles();
		for(File file : files){
			if(file.isDirectory()) enumrate(file);
			else queue.put(file);
		}
	}
}
