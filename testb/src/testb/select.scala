package testb

import org.openqa.selenium.WebDriver
import org.openqa.selenium.By
import org.openqa.selenium.support.ui.Select

object select {
    def isEnabled(by:By) {
    element.find( by).isEnabled()
  }
    def chioce(by:By,index:Int){
    var  select:Select = new Select(element.find( by))
    select.selectByIndex(index)
    }
}