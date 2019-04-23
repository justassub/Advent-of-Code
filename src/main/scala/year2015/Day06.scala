package year2015

import year2015.State.State

case class Lamp(x: Int, y: Int) {
  var isOn: Boolean = false

  def turnOn(): Unit = {
    isOn = true
  }

  def turOff(): Unit = {
    isOn = false
  }

  def changeState(): Unit = {
    isOn = !isOn
  }
}

case class StateHistory(state: State, fromX: Int, fromY: Int, tillX: Int, tillY: Int)

object State extends Enumeration {
  type State = Value
  val OFF, ON, TOGGLE = Value
}

object Day06 extends Main2015[String, Int, Int] {

  import State._

  println(part1(seqString))

  override def part1(seq: Seq[String]) = {
    val lamps = Day06Util.createLamps
    val history = seq.flatMap(Day06Util.createHistory)
    changeState(history, lamps).filter(_.isOn).size
  }

  def changeState(history: Seq[StateHistory], lamps: Seq[Lamp]): Seq[Lamp] = {
    def editState(state: State, lamp: Lamp): Unit = {
      state match {
        case OFF => lamp.turOff()
        case ON => lamp.turnOn()
        case TOGGLE => lamp.changeState()
      }
    }

    for (his <- history) {
      lamps
        .withFilter(lamp => lamp.x >= his.fromX && lamp.x <= his.tillX)
        .withFilter(lamp => lamp.y >= his.fromY && lamp.y <= his.tillY)
        .foreach(editState(his.state, _))
    }
    lamps
  }

  override def part2(seq: Seq[String]) = ???
}

object Day06Util {

  import State._

  def createLamps = {
    for {
      x <- 1 to 999
      y <- 1 to 999
    } yield Lamp(x, y)
  }

  def createHistory(line: String) = {
    //toggle 461,550 through 564,900
    val historyRegex = "(.*) ([0-9]*),([0-9]*) through ([0-9]*),([0-9]*)".r
    line match {
      case historyRegex(state, fromX, fromY, toX, toY) => Option(StateHistory(createStateFromString(state), fromX.toInt, fromY.toInt, toX.toInt, toY.toInt))
      case _ => None
    }
  }

  def createStateFromString(string: String) = string match {
    case "turn on" => ON
    case "turn off" => OFF
    case "toggle" => TOGGLE
  }
}