package dott

import java.time.{Duration, Instant}

import com.typesafe.scalalogging.LazyLogging
import dott.model.Order
import dott.options.{ClosedInterval, Interval, OpenInterval, Options}

class OrderAggregator(options: Options, now: Instant = Instant.now()) extends LazyLogging {

  /**
   * Finds the interval a given age is
   * @param value age
   * @param intervals list of intervals
   * @return
   */
  def getInterval(value: Long, intervals: Seq[Interval]): Option[Interval] = {
    intervals.find(i => i.isIn(value))
  }

  /**
   * Calculates age of a product
   * @param product a product entity
   * @return
   */
  def calculateAge(product: model.Product): Long =
    Duration.between(product.createdAt, now).toDays / 30

  /**
   * Filters and aggregates orders counting the number of orders with products in a given interval
   * @param orders List of orders
   * @return Map of Intervals to number of orders
   */
  def aggregate(orders: List[Order]): Map[Option[Interval], Int] = {
    orders
      .filter(order => order.placedAt.isAfter(options.start) && order.placedAt.isBefore(options.end))
      .flatMap(order => {
        order.items.map(it => (order.id, getInterval(calculateAge(it.product), options.intervals)))
      })
      .groupBy(x => x._2)
      .map(x => x._1 -> x._2.distinct.size)
  }

  def render(result: Map[Option[Interval], Int]): Unit = {
    result.toList.filter(_._1.isDefined).sortBy(_._1.get.start).foreach(group => {
      group._1 match {
        case Some(ClosedInterval(start, end)) =>
          logger.info(s"${start}-$end months: ${group._2} orders")
        case Some(OpenInterval(start)) =>
          logger.info(s">${start} months: ${group._2} orders")
        case _ =>
          logger.info(s"Out of bounds: ${group._2} orders")
      }
    })
  }
}
