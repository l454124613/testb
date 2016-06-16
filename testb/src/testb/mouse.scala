package testb

import org.openqa.selenium.interactions.Actions
import org.openqa.selenium.By

object mouse {
  val  action:Actions = new Actions(driver.get_it());
  /*
   * 右击
   */
  def contextClick(by:By){
    action.contextClick(element.find(by))
  }
  /*
   * 双击
   */
   def doubleClick(by:By){
    action.doubleClick(element.find(by))
  }
   /*
    * 拖拽
    */
   def dragAndDrop(fromby:By,toby:By){
    action.clickAndHold(element.find(fromby)).moveToElement(element.find(toby)).perform(); 
 action.release();
  }
   /*
    * 按住不放
    */
    def clickAndHold(by:By){
    action.clickAndHold(element.find(by))
  }
    /*
     * 移动
     */
        def moveToElement(by:By){
    action.moveToElement(element.find(by))
  }
        /*
         * 松开鼠标
         */
         def release(){
    action.release()
  }    
  
}