package testb

import org.openqa.selenium.WebDriver

object driver {
  var driver:WebDriver=null
  def get_it():WebDriver={
    driver
  }
}