package dott

import java.time.Instant

import dott.options.{ClosedInterval, OpenInterval, Options}
import org.scalatest._
import org.scalatest.wordspec.AnyWordSpec
import matchers._

class OrderAggregatorSpec extends AnyWordSpec with must.Matchers {
  val mockOptions: Options = Options(
    Instant.parse("2020-01-01T00:00:00Z"),
    Instant.parse("2021-01-01T00:00:00Z")
  )

  "calculateAge" should {
    "calculate the age of a product in months" in {
      val aggregator = new OrderAggregator(mockOptions, Instant.parse("2021-01-30T00:00:00Z"))
      aggregator.calculateAge(Fixtures.product1) mustBe 13L
    }
  }

  "aggregate" should {
    "build a map that counts the number of orders with products in a given interval" in {
      val aggregator = new OrderAggregator(mockOptions, Instant.parse("2021-01-30T00:00:00Z"))
      val result = aggregator.aggregate(Fixtures.orders)
      val expected =
        Map(
          Some(ClosedInterval(7, 12)) -> 5,
          Some(ClosedInterval(4, 6)) -> 3,
          Some(ClosedInterval(1, 3)) -> 2,
          Some(OpenInterval(12)) -> 3
        )
      result mustBe expected
    }
  }

}
