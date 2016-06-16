package testb

import org.openqa.selenium.By

object chioce {
  def click(by:By) {
    element.find( by).click()
  }
  
   def isEnabled(by:By) {
    element.find( by).isEnabled()
  }
   
    def isSelected(by:By) {
    element.find( by).isSelected()
  }
}