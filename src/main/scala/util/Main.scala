package util

trait Main[T, R1, R2] extends App {
  def getFileName: String = getClass.getSimpleName.split("\\$").last

  def getPackage: String

  implicit val file = s"./src/main/resources/$getPackage/$getFileName" + ".txt"
  lazy val seqInt = FileReader.readAndMapToInt
  lazy val seqString = FileReader.readResource

  def part1(seq: Seq[T]): R1

  def part2(seq: Seq[T]): R2
}
