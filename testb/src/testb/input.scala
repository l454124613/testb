package testb

import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

object input {
    def getText(by:By):String= {
    element.find( by).getText
  }
     def isEnabled(by:By) {
    element.find( by).isEnabled()
  }
      def sendKeys(by:By,key:String) {
    element.find( by).sendKeys(key)
  }
    
     def clear(by:By) {
    element.find( by).clear()
  } 
}