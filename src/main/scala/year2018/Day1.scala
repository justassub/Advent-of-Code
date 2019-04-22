package year2018

import scala.annotation.tailrec

object Day1 extends Main2018[Int, Int, Int] {

  println(part1(seqInt))
  println(part2(seqInt))

  override def part1(seq: Seq[Int]): Int = seq.sum

  override def part2(seq: Seq[Int]): Int = findDuplicateFromStream(prepareContinuallyStream(seq))

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
