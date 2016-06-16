package testb

import org.openqa.selenium.WebDriver
import org.openqa.selenium.By
/*
 * 按钮相关
 */
object button {
  /*
   * 点击
   */
  def click(by:By) {
    element.find( by).click()
  }
  /*
   * 是否可用
   */
   def isEnabled(by:By) {
    element.find( by).isEnabled()
  }
  
  
  
}