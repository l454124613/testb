package testb

import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver

/*
 * 重要，driver相关
 */
object driver {
         System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");//设置驱动的位置
			private var w:WebDriver=new ChromeDriver()
/*
 * 获得driver
 */
  def get_it():WebDriver={
w
  }
			
			/*
			 *连接网站 
			 */
			def connect(url:String){
			  if(url.matches("http")){
			  w.get(url)}else{
			    var a="http://"+url
			    w.get(a)
			  }
			}
}