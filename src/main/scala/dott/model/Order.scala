package dott.model

import java.time.Instant

case class Order(id: String,
                 customerName: String,
                 contact: String,
                 shippingAddress: String,
                 grandTotal: BigDecimal,
                 placedAt: Instant,
                 items: List[Item])