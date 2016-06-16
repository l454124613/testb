package testb

import org.openqa.selenium.By
import scala.util.control.Breaks
import collection.JavaConversions._

object switch {
  def defaultContent{
    driver.get_it().switchTo().defaultContent()
  }
  
  def frame(by:By){
    driver.get_it().switchTo().frame(element.find(by))
  }
  
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