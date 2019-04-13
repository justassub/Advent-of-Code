package year2018

import util.FileReader

import scala.annotation.tailrec

object Day1 extends App {
  implicit val file = "./src/main/resources/day1.txt"
  implicit val seq = FileReader.readAndMapToInt

  println(part1)
  println(part2)

  def part1(implicit seq: Seq[Int]): Int = seq.sum

  def part2(implicit seq: Seq[Int]): Int = findDuplicateFromStream(prepareContinuallyStream)


  private def prepareContinuallyStream(implicit seq: Seq[Int]) = Stream.continually(seq).flatten.scanLeft(0)(_ + _)


  private def findDuplicateFromStream(seq: Seq[Int]) = {
    import scala.collection.mutable.{Set => MutableSet}

    @tailrec
    def iterate(remaining: Stream[Int], seen: MutableSet[Int] = MutableSet[Int]()): Option[Int] = remaining match {
      case h #:: _ if seen(h) => Some(h) //x #:: xs returns Stream.cons(x, xs) -returns element x followed by a Stream xs
      case h #:: t => iterate(t, seen += h)
      case _ => None
    }

    iterate(seq.toStream).getOrElse(0)
  }

}
