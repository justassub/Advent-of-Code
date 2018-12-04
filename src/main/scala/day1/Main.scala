package day1


object Main {

  val file = "./src/main/resources/day1.txt"

  def main(args: Array[String]): Unit = {
    println(readFileAndCreateNumberList(file).sum)
  }

  def readFileAndCreateNumberList(path: String): List[Int] = {
    import scala.io.Source
    Source.fromFile(path)
      .getLines
      .map(_.toInt)
      .toList
  }
}