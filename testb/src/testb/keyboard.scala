package testb

import org.openqa.selenium.Keys
import org.openqa.selenium.interactions.Actions


/*
 * 键盘相关
 */
object keyboard {
    val  action:Actions = new Actions(driver.get_it());
/*
 * Actions 中的 sendKeys(keysToSend) 对于修饰键 (Modifier Keys) 的调用并不会释放，也就是说当调用 actions.sendKeys(Keys.ALT); actions.sendKeys(Keys.CONTROL); action.sendKeys(Keys.SHIFT); 的时候，相当于调用 actions.keyDown(keysToSend)，而如果在现实的应用中想要模拟按下并且释放这些修饰键，应该再调用 action.sendKeys(keys.NULL) 来完成这个动作。
 */
  def sendkeys(key:String){
    action.sendKeys(key)
    
  }
}