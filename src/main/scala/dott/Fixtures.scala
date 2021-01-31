package dott

import java.time.Instant

import dott.model.{Item, Order, Product}

object Fixtures {
  val product1: Product = Product("product1", "category1", 0.1f, BigDecimal(1.99),
    Instant.parse("2020-01-01T00:00:00.00Z"))
  val product2: Product = Product("product2", "category1", 2.1f, BigDecimal(11.99),
    Instant.parse("2020-02-29T00:00:00.00Z"))
  val product3: Product = Product("product3", "category2", 3.1f, BigDecimal(12.99),
    Instant.parse("2020-03-30T00:00:00.00Z"))
  val product4: Product = Product("product4", "category3", 2.1f, BigDecimal(13.99),
    Instant.parse("2020-04-12T00:00:00.00Z"))
  val product5: Product = Product("product5", "category3", 2.1f, BigDecimal(13.99),
    Instant.parse("2020-05-11T00:00:00.00Z"))
  val product6: Product = Product("product6", "category4", 1.0f, BigDecimal(129.99),
    Instant.parse("2020-06-30T00:00:00.00Z"))
  val product7: Product = Product("product7", "category4", 1.0f, BigDecimal(18.99),
    Instant.parse("2020-07-03T00:00:00.00Z"))
  val product8: Product = Product("product8", "category44", 1.0f, BigDecimal(9.99),
    Instant.parse("2020-08-30T00:00:00.00Z"))
  val product9: Product = Product("product9", "category4", 1.0f, BigDecimal(3.99),
    Instant.parse("2020-09-01T00:00:00.00Z"))
  val product10: Product = Product("product10", "category1", 1.0f, BigDecimal(199.99),
    Instant.parse("2020-10-01T00:00:00.00Z"))
  val product11: Product = Product("product11", "category6", 1.0f, BigDecimal(63.99),
    Instant.parse("2020-11-01T00:00:00.00Z"))
  val product12: Product = Product("product12", "category9", 1.0f, BigDecimal(6.99),
    Instant.parse("2020-12-01T00:00:00.00Z"))

  val item1: Item = Item(product1, product1.price * 1.05, BigDecimal(0.99), product1.price * 0.05)
  val item2: Item = Item(product2, product2.price * 1.05, BigDecimal(0.99), product2.price * 0.05)
  val item3: Item = Item(product3, product3.price * 1.05, BigDecimal(0.99), product3.price * 0.05)
  val item4: Item = Item(product4, product4.price * 1.05, BigDecimal(0.99), product4.price * 0.05)
  val item5: Item = Item(product5, product5.price * 1.05, BigDecimal(0.99), product5.price * 0.05)
  val item6: Item = Item(product6, product6.price * 1.05, BigDecimal(0.99), product6.price * 0.05)
  val item7: Item = Item(product7, product7.price * 1.05, BigDecimal(0.99), product7.price * 0.05)
  val item8: Item = Item(product8, product8.price * 1.05, BigDecimal(0.99), product8.price * 0.05)
  val item9: Item = Item(product9, product9.price * 1.05, BigDecimal(0.99), product9.price * 0.05)
  val item10: Item = Item(product10, product10.price * 1.05, BigDecimal(0.99), product10.price * 0.05)
  val item11: Item = Item(product11, product11.price * 1.05, BigDecimal(0.99), product11.price * 0.05)
  val item12: Item = Item(product12, product12.price * 1.05, BigDecimal(0.99), product12.price * 0.05)

  val orders = List(
    Order("1", "customer1", "9999-9999", "A Street", BigDecimal(100.00),
      Instant.parse("2020-01-30T00:00:00.00Z"), List(item1, item2, item10)),
    Order("2", "customer2", "9999-9999", "A Street", BigDecimal(100.00),
      Instant.parse("2020-01-30T00:00:00.00Z"), List(item1)),
    Order("3", "customer3", "9999-9999", "B Street", BigDecimal(199.00),
      Instant.parse("2020-02-20T00:00:00.00Z"), List(item2, item3, item7)),
    Order("4", "customer4", "9999-9999", "C Street", BigDecimal(299.00),
      Instant.parse("2020-03-30T00:00:00.00Z"), List(item3, item4, item12, item8)),
    Order("5", "customer5", "9999-9999", "C Street", BigDecimal(399.00),
      Instant.parse("2020-08-30T00:00:00.00Z"), List(item4, item5, item11)),
    Order("6", "customer6", "9999-9999", "D Street", BigDecimal(399.00),
      Instant.parse("2020-12-30T00:00:00.00Z"), List(item1, item5, item9)),
  )
}
