package year2018

import org.scalatest.{FlatSpec, Matchers}
import util.FileReader

class Day2Test extends FlatSpec with Matchers {

  "Day 2 part 1 " should "be equal to given examples" in {
    implicit val boxes = Seq(
      "abcdef",
      "bababc",
      "abbcde",
      "abcccd",
      "aabcdd",
      "abcdee",
      "ababab"
    )
    Day2.part1(boxes) shouldEqual 12
  }

  "Day 2 part 2 " should "be equal to given examples" in {
    implicit val boxes = Seq(
      "abcde",
      "fghij",
      "klmno",
      "pqrst",
      "fguij",
      "axcye",
      "wvxyz"
    )
    Day2.part2(boxes) shouldEqual "fgij"
  }

  "Day 2 part 2 " should "be equal to correct Answer" in {
    implicit val file = Day2.file
    implicit val seq = FileReader.readResource.toList

    Day2.part2(seq) shouldEqual "asgwjcmzredihqoutcylvzinx"
  }
}
