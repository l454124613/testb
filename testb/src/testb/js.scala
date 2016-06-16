package testb

import org.openqa.selenium.JavascriptExecutor


/*
 * js相关
 */
object js {
  /*
   * 运行js
   */
  def executeScript(s:String){
    var js:JavascriptExecutor = driver.get_it().asInstanceOf[JavascriptExecutor];
  js.executeScript(s)
  }
}