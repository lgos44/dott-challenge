package dott.options

import java.time.Instant
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.ZoneId

import scopt.{OParser, OParserBuilder}

case class Options(start: Instant = Instant.now(),
                   end: Instant = Instant.now(),
                   intervals: Seq[Interval] = Options.defaultInterval)

trait Interval {
  val start: Int
  def isIn(value: Long): Boolean
}
case class ClosedInterval(start: Int, end: Int) extends Interval {
  override def isIn(value: Long): Boolean = value >= start && value <= end
}
case class OpenInterval(start: Int) extends Interval {
  override def isIn(value: Long): Boolean = value >= start
}

object Options {
  val defaultInterval: Seq[Interval] =
    Seq[Interval](ClosedInterval(1,3),ClosedInterval(4,6),ClosedInterval(7,12), OpenInterval(12))

  val builder: OParserBuilder[Options] = OParser.builder[Options]

  val parser1: OParser[Unit, Options] = {
    import builder._
    OParser.sequence(
      programName("orders"),
      head("Orders", "0.1"),
      opt[String]('s', "start")
        .action((x, c) => c.copy(start = parseInstant(x)))
        .text("start is a datetime with the following pattern: yyyy-MM-dd HH:mm:ss"),
      opt[String]('e', "end")
        .action((x, c) => c.copy(end = parseInstant(x)))
        .text("end is a datetime with the following pattern: yyyy-MM-dd HH:mm:ss"),
      opt[Seq[String]]('i', "intervals")
        .action((x, c) => c.copy(intervals = x.map(parseInterval)))
        .text("interval is an array of ranges, e.g. 1-3,4-6,7-12,>12")
    )
  }

  def parseInstant(str: String): Instant = {
    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
    val dateTime = LocalDateTime.parse(str, formatter)
    dateTime.atZone(ZoneId.systemDefault()).toInstant
  }

  def validateIntervals(intervals: Seq[Interval]): String = {
    ""
  }

  def parseInterval(str: String): Interval =  {
    val closedPattern =  raw"(\d+)-(\d+)".r
    val openPattern =  raw">(\d+)".r
    str match {
      case closedPattern(start, end, _*) => ClosedInterval(start.toInt, end.toInt)
      case openPattern(start, _*) =>  OpenInterval(start.toInt)
    }
  }

  def fromArgs(args: Array[String]): Options = {
    OParser.parse(parser1, args, Options()) match {
      case Some(config) =>
        config
      case _ =>
        throw new IllegalArgumentException("Could not parse arguments, please check usage message.")
    }
  }
}