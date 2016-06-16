package testb

import org.openqa.selenium.By
import scala.util.control.Breaks
import collection.JavaConversions._

/*
 * 切换相关，努力融合进代码中
 */
object switch {
/*
 * 获得顶层
 */
  def defaultContent{
    driver.get_it().switchTo().defaultContent()
  }
  /*选择frame
   * 
   */
  def frame(by:By){
    driver.get_it().switchTo().frame(element.find(by))
  }
  /*
   * 切换窗口
   */
  def window(title_name:String){
     var s=driver.get_it().getWindowHandles
 
    val loop = new Breaks;
    loop.breakable{
      for(sa <- s){
        if(
       driver.get_it().switchTo().window(sa).equals(title_name)){
        loop.break()
       }
      }
    }
    
  }
}