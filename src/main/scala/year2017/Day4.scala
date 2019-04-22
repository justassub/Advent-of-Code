package year2017

import year2017.Day4Util._

object Day4 extends Main2017[String, Int, Int] {
  println(part1(seqString))
  println(part2(seqString))

  override def part1(seq: Seq[String]) = {
    seq
      .map(splitLine)
      .filter(lineContainsSamePasswords)
      .size
  }

  override def part2(seq: Seq[String]) = {
    seq
      .map(splitLine)
      .filter(lineContainsNoAnagrams)
      .size
  }
}

object Day4Util {
  def splitLine(line: String) = line.split("\\s+")

  def lineContainsSamePasswords(passwords: Array[String]) = passwords.size == passwords.distinct.size

  def lineContainsNoAnagrams(passwords: Array[String]) = passwords.size == passwords.map(_.sorted).distinct.size
}