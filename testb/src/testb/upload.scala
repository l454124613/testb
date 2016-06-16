package testb

import org.openqa.selenium.By
/*
 * 上传相关
 */
object upload {
  /*
   * 上传操作
   */
  def send(by:By,file:String){
    element.find(by).sendKeys(file)
  }
}