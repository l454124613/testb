package testb

import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

/*
 * 输入框相关
 */

object input {
  /*
   * 是否可用
   */
     def isEnabled(by:By) {
    element.find( by).isEnabled()
  }
     
     /*
      * 输入值
      */
      def sendKeys(by:By,key:String) {
    element.find( by).sendKeys(key)
  }
      
      /*
       * 清除值
       */
    
     def clear(by:By) {
    element.find( by).clear()
  } 
}