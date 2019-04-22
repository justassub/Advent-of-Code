package year2018

import java.time.format.DateTimeFormatter
import java.time.{LocalDate, LocalDateTime, ZoneOffset}

import year2018.Day04SupportClasses.{Note, SleepSchedule}

import scala.annotation.tailrec
import scala.util.Try

object Day04SupportClasses {

  case class Note(timestamp: LocalDateTime, note: String)

  case class SleepSchedule(date: LocalDate, minutesAsleep: Seq[Int])

}

object Day4 extends Main2018[String, Int, Int] {

  println(part1(seqString))
  println(part2(seqString))

  override def part1(seq: Seq[String]) = {
    val notes = seq.map(Parsers.parseToNote).flatten
    val (id, sleepTimes) = sleepSchedule(notes).maxBy(_._2.map(_.minutesAsleep.size).sum)
    val minute = sleepTimes
      .flatMap(_.minutesAsleep)
      .groupBy(identity)
      .mapValues(_.size)
      .maxBy(_._2)
      ._1
    minute * id
  }

  def sleepSchedule(notes: Seq[Note]): Map[Int, Seq[SleepSchedule]] = {
    val guardPattern = "Guard #(.*?) begins shift".r
    val sleepPattern = "falls asleep".r
    val wakePattern = "wakes up".r

    def addToMap(map: Map[Int, Seq[SleepSchedule]])(id: Int, date: LocalDate, start: Int, end: Int): Map[Int, Seq[SleepSchedule]] =
      map.updated(id, map(id) :+ SleepSchedule(date, start until end))

    @tailrec
    def iterate(remaining: Seq[Note],
                tempId: Option[Int],
                tempStart: Option[Int],
                built: Map[Int, Seq[SleepSchedule]] = Map.empty.withDefaultValue(Seq[SleepSchedule]())): Map[Int, Seq[SleepSchedule]] = remaining match {
      case Note(time, note) +: rest =>
        note match {
          case guardPattern(idS) =>
            iterate(rest, Try(idS.toInt).toOption, None, built)
          case sleepPattern() =>
            iterate(rest, tempId, Some(time.getMinute), built)
          case wakePattern() =>
            iterate(rest, tempId, None, addToMap(built)(tempId.get, time.toLocalDate, tempStart.get, time.getMinute))
          case _ => iterate(rest, tempId, None, built)
        }
      case _ => built
    }

    val sorted = notes.sortBy(_.timestamp.atOffset(ZoneOffset.UTC).toEpochSecond)
    iterate(sorted, None, None)
  }

  override def part2(seq: Seq[String]) = {
    val notes = seq.map(Parsers.parseToNote).flatten
    val schedules = sleepSchedule(notes)
    val mostFreqMinMap = schedules.mapValues(_.flatMap(_.minutesAsleep).groupBy(identity).mapValues(_.length).maxBy(_._2))
    val (id, (minute, _)) = mostFreqMinMap.maxBy(_._2._2)
    id * minute
  }

}

object Parsers {
  def parseToNote(row: String): Option[Note] = {
    val pattern = "\\[(.*)\\] (.*)".r
    row match {
      case pattern(timeStamp, note) => Try(LocalDateTime.parse(timeStamp, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"))).toOption.map(Note(_, note))
      case _ => None
    }
  }
}
