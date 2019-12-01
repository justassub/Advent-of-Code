package year2019.scala

import scala.annotation.tailrec

object Day1 extends Main2019[Int, Int, Int] {
  println(part1(seqInt))
  println(part2(seqInt))

  override def part1(seq: Seq[Int]) = {
    seq.map(transformFuel).sum
  }

  def transformFuel(fuel: Int) = fuel / 3 - 2

  @tailrec
  def transformFuel(fuel: Int, sum: Int): Int = {
    val transformed = transformFuel(fuel);
    if (transformed <= 0) {
      return sum
    }
    transformFuel(transformed, sum + transformed)
  }

  override def part2(seq: Seq[Int]) = {
    seq.map(transformFuel(_, 0)).sum
  }
}
