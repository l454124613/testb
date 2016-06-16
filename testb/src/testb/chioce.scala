package testb

import org.openqa.selenium.By

/*
 * 选择相关
 */
class chioce(by:By) {
  var ele=element.find(by)
  /*
   * 点击
   */
  def click() {
   ele.click()
  }
  /*
   * 是否可用
   */
   def isEnabled() {
    ele.isEnabled()
  }
   /*
    * 是否已选
    */
    def isSelected() {
    ele.isSelected()
  }
}