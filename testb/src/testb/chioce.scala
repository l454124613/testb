package testb

import org.openqa.selenium.By

/*
 * 选择相关
 */
object chioce {
  /*
   * 点击
   */
  def click(by:By) {
    element.find( by).click()
  }
  /*
   * 是否可用
   */
   def isEnabled(by:By) {
    element.find( by).isEnabled()
  }
   /*
    * 是否已选
    */
    def isSelected(by:By) {
    element.find( by).isSelected()
  }
}