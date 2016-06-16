package testb

import org.openqa.selenium.By

object text {
  def getAttribute(by:By,attr:String):String={
    element.find(by).getAttribute(attr)
  }
  
  def getText(by:By):String={
    element.find(by).getText
  }
  
}