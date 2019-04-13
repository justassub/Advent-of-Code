package util

import scala.io.Source

object FileReader {
  def readResource(implicit path: String): Seq[String] =
    Source.fromFile(path).getLines().toSeq

  def readAndMapToInt(implicit path: String) = readResource.map(_.toInt)
}
