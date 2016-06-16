package testb

import org.openqa.selenium.By

object upload {
  def send(by:By,file:String){
    element.find(by).sendKeys(file)
  }
}