package year2018

import util.Main

abstract class Main2018[T, R1, R2] extends Main[T, R1, R2] {
  override def getFileName: String = getClass.getSimpleName.split("\\$").last

  override def getPackage = "2018"
}
