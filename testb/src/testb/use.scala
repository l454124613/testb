package testb

import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import org.openqa.selenium.By
import java.util.concurrent.ThreadPoolExecutor
import java.util.Queue
import java.util.LinkedList

/*
 * 并发操作
 */
object use extends App {
 
 override def main(args: Array[String]): Unit = {
   
   var queue=new LinkedList[String]()
  for(i<- 0 until 2){
   queue.add(i.toString() )}


   
  var  threadPool:ExecutorService = Executors.newCachedThreadPool(); // 并发测试线程�?
	while(queue.size()>0){
	
	  var a=threadPool.asInstanceOf[ThreadPoolExecutor].getActiveCount
 if(a<5){
	 queue.poll()
	 threadPool.execute(new Runnable {
		 def run {
	
			
			 
		 }
	 });
 }else{
   Thread.sleep(500)
 }

		
	
	}

	threadPool.shutdown();	

	}
  
}