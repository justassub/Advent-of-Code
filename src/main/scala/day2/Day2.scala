package day2

object Day2 {
  val file = "./src/main/resources/day1-2.txt"


  def main(args: Array[String]): Unit = {
    var numberList = readFileAndCreateNumberList(file)
    var sums = returnSums(numberList)

    var firstDuplicate = calculatesFirstDuplicatedSum(numberList, returnSums(numberList))
    println(firstDuplicate)
  }

  def readFileAndCreateNumberList(path: String): List[Int] = {
    import scala.io.Source
    Source.fromFile(path)
      .getLines
      .map(_.toInt)
      .toList
  }

  def returnSums(numbers: Seq[Int]) = {
    var allSums = Seq(0);
    numbers.foreach(number => allSums = allSums :+ allSums.last + number)
    allSums
  }

  def calculatesFirstDuplicatedSum(numbers: Seq[Int], sums: Seq[Int]): Int = {
    var allSums = sums;
    numbers.foreach(number => {
      number match {
        case number if (allSums.contains(allSums.last + number)) => return allSums.last + number
        case number => allSums = allSums :+ allSums.last + number;
      }
    })
    calculatesFirstDuplicatedSum(numbers,allSums)


  }
}
