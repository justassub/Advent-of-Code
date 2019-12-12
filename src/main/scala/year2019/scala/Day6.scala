package year2019.scala

import scala.annotation.tailrec

case class OrbitParameters(name: String, pointsTo: String) {}

object Day6 extends Main2019[String, Int, Int] {
  override def part1(seq: Seq[String]): Int = {
    val orbits = seq.map(Day6Util.createParameters).map(orbit => (orbit.pointsTo, orbit)).toMap

    val values = orbits.map(o => (o, Day6Util.calculateDistanceToCom(o._2, orbits))).toList.sortBy(_._2)
    values.map({ case (_, number) => number }).sum
  }

  override def part2(seq: Seq[String]) = 5

  println(part1(seqString))
}

object Day6Util {
  val ending = "COM"

  def createParameters(data: String): OrbitParameters = {
    val splitData = data.split(')')
    OrbitParameters(splitData.head, splitData.tail.head)
  }

  @tailrec
  def calculateDistanceToCom(orbit: OrbitParameters, orbits: Map[String, OrbitParameters], distance: Int = 0): Int = {
    if (orbits(orbit.pointsTo).name == ending) {
      distance + 1
    }
    else calculateDistanceToCom(orbits(orbit.name), orbits, distance + 1)
  }
}