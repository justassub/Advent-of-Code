package year2015

case class Box1(length: Int, width: Int, height: Int) {
  private val area1 = length * width
  private val area2 = width * height
  private val area3 = height * length
  private val minArea = Set(area1, area2, area3).min
  private val surfaceArea = 2 * area1 + 2 * area2 + 2 * area3

  def howMuchPaper = surfaceArea + minArea
}

case class Box2(length: Int, width: Int, height: Int) {
  private val doubleLength = length * 2
  private val doubleWidth = width * 2
  private val doubleHeigth = height * 2
  private val sortedBoxParameters = List(doubleLength, doubleWidth, doubleHeigth).sorted

  def howMuchRibbon = sortedBoxParameters.take(2).sum + (length * width * height)
}

object Day02 extends Main2015[String, Int, Int] {
  println(part1(seqString))
  println(part2(seqString))

  override def part1(seq: Seq[String]) = {
    seq
      .flatMap(Day02Util.createBox1)
      .map(_.howMuchPaper)
      .sum
  }

  override def part2(seq: Seq[String]) = {
    seq
      .flatMap(Day02Util.createBox2)
      .map(_.howMuchRibbon)
      .sum
  }
}

object Day02Util {
  private val boxRegex = "(.*)x(.*)x(.*)".r

  def createBox1(line: String) =
    line match {
      case boxRegex(length, width, height) => Some(Box1(length.toInt, width.toInt, height.toInt))
      case _ => None
    }

  def createBox2(line: String) =
    line match {
      case boxRegex(length, width, height) => Some(Box2(length.toInt, width.toInt, height.toInt))
      case _ => None
    }
}