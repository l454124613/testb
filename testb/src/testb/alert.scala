package testb
/*
 * 提示框相关
 */
object alert {
private var alert = driver.get_it().switchTo().alert();

/*
 * 同意，确定
 */
def accept{
  alert.accept()
}
/*
 *取消 
 */
def dismiss{
  alert.dismiss()
}

/*
 * 获得提示信息
 */
def getText:String={
  alert.getText
}





}