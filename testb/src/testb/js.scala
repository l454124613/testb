package testb

import org.openqa.selenium.JavascriptExecutor

object js {
  def executeScript(s:String){
    var js:JavascriptExecutor = driver.get_it().asInstanceOf[JavascriptExecutor];
  js.executeScript(s)
  }
}