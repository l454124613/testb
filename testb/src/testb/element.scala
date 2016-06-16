package testb

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

/*
 * 元素相关
 */
object element{
  /**
   * 定位单个元素
   */
  def find(by:By):WebElement= {
   driver.get_it().findElement(by)
  }
  
  def finds(by:By):java.util.List[WebElement]= {
    driver.get_it().findElements(by)
  }
  
  
}