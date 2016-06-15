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


object use extends App {
 var driver :WebDriver=null
 override def main(args: Array[String]): Unit = {
   
   var queue=new LinkedList[String]()
  for(i<- 0 until 2){
   queue.add(i.toString() )}
  // println(queue.poll()+""+queue.size())

   
    System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");//设置驱动的位置
  var  threadPool:ExecutorService = Executors.newCachedThreadPool(); // 并发测试线程�?
	while(queue.size()>0){
	//  Thread.sleep(6000)
	  var a=threadPool.asInstanceOf[ThreadPoolExecutor].getActiveCount
 if(a<5){
	 queue.poll()
	 threadPool.execute(new Runnable {
		 def run {
			 var aa=System.currentTimeMillis();
			 var w:WebDriver=new ChromeDriver()
			 w.get("http://www.baidu.com");	
			 w.manage().window().maximize();
			 var a=	w.findElement(By.id("su")).getAttribute("value");
			 
			 w.close();
			 
			 System.out.println(s"${a}时间是：${System.currentTimeMillis()-aa}线程是${Thread.currentThread().getId}");
			
			 
		 }
	 });
 }else{
   Thread.sleep(500)
 }

		
	
	}

	threadPool.shutdown();	

	}
  
}