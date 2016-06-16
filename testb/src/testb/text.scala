package testb

import org.openqa.selenium.By


/*
 * 获得文本内容
 */
class text(by:By) {
   var ele=element.find(by)

  /*
   * 获得属性值
   */
  def getAttribute(attr:String):String={
ele.getAttribute(attr)
  }
  
  /*
   * 获得值
   */
  def getText():String={
    ele.getText
  }
  
}