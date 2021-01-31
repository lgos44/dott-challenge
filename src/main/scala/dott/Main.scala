package dott

import com.typesafe.scalalogging.LazyLogging
import dott.options.Options

import scala.util.{Failure, Success, Try}

object Main extends App with LazyLogging {
  Try {Options.fromArgs(args)} match {
    case Success(options) =>
      val aggregator = new OrderAggregator(options)
      val result = aggregator.aggregate(Fixtures.orders)
      print(result)
      aggregator.render(result)
    case Failure(exception) =>
       logger.info(s"Failed with: ${exception.getMessage}")
  }
}
