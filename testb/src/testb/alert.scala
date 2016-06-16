package testb

object alert {
private var alert = driver.get_it().switchTo().alert();
def accept{
  alert.accept()
}

def dismiss{
  alert.dismiss()
}


def getText:String={
  alert.getText
}





}