package testb

import org.openqa.selenium.By


/*
 * 获得文本内容
 */
object text {
  /*
   * 获得属性值
   */
  def getAttribute(by:By,attr:String):String={
    element.find(by).getAttribute(attr)
  }
  
  /*
   * 获得值
   */
  def getText(by:By):String={
    element.find(by).getText
  }
  
}