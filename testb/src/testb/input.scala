package testb

import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

/*
 * 输入框相关
 */

class input(by:By) {
    var ele=element.find(by)

  
  /*
   * 是否可用
   */
     def isEnabled() {
    ele.isEnabled()
  }
     
     /*
      * 输入值
      */
      def sendKeys(key:String) {
    ele.sendKeys(key)
  }
      
      /*
       * 清除值
       */
    
     def clear() {
   ele.clear()
  } 
}