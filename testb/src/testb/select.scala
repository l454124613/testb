package testb

import org.openqa.selenium.WebDriver
import org.openqa.selenium.By
import org.openqa.selenium.support.ui.Select

/*
 * 下拉框相关
 */
object select {
  /*是否可用
   * 
   */
    def isEnabled(by:By) {
    element.find( by).isEnabled()
  }
    /*
     * 选择
     */
    def chioce(by:By,index:Int){
    var  select:Select = new Select(element.find( by))
    select.selectByIndex(index)
    }
}