package testb

import org.openqa.selenium.By
/*
 * 上传相关
 */
class upload(by:By) {
     var ele=element.find(by)

  /*
   * 上传操作
   */
  def send(file:String){
    ele.sendKeys(file)
  }
}