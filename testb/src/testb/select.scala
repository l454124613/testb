package testb

import org.openqa.selenium.WebDriver
import org.openqa.selenium.By
import org.openqa.selenium.support.ui.Select

/*
 * 下拉框相关
 */
class select(by:By) {
      var ele=element.find(by)

  /*是否可用
   * 
   */
    def isEnabled() {
  ele.isEnabled()
  }
    /*
     * 选择
     */
    def chioce(index:Int){
    var  select:Select = new Select(ele)
    select.selectByIndex(index)
    }
}