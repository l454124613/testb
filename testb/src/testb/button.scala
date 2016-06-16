package testb

import org.openqa.selenium.WebDriver
import org.openqa.selenium.By
import org.openqa.selenium.WebElement

/*
 * 按钮相关
 */
class  button(by:By) {
  var ele=element.find(by)
  /*
   * 点击
   */
  def click() {
    ele.click()
  }
  /*
   * 是否可用
   */
   def isEnabled() {
    ele.isEnabled()
  }
   
  
  
  
  
}