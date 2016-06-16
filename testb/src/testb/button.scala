package testb

import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

object button {
  def click(by:By) {
    element.find( by).click()
  }
  
   def isEnabled(by:By) {
    element.find( by).isEnabled()
  }
    def getText(by:By):String= {
    element.find( by).getText
  }
  
  
}