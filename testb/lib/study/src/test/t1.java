package test;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

public class t1 {
	//static ChromeDriverService service;
public static void main(String[] args) throws IOException, InterruptedException {
	System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");// 配置驱动
//	service = new ChromeDriverService.Builder()
//			.usingDriverExecutable(new File("driver/chromedriver.exe")).usingAnyFreePort()
//			.build();
//	service.start();// 开启谷歌服务
	
	ExecutorService threadPool = Executors.newCachedThreadPool(); // 并发测试线程�?
	for(int i=0;i<5;i++){
		int t=i;
		System.out.println(i);
	threadPool.execute(new Runnable() {
		public void run() {
			WebDriver w=new ChromeDriver(); 
			

			w.get("http://www.baidu.com");	
			w.manage().window().maximize();
		String a=	w.findElement(By.id("su")).getAttribute("value");
		
			w.close();
			System.out.println(a);
		}
	});
	
	}

	threadPool.shutdown();	
	final boolean done = threadPool.awaitTermination(1, TimeUnit.MINUTES);
	System.out.println(done);
	
	}
	
	
}

