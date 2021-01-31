package dott.model

import java.time.Instant

case class Product(name: String,
                   category: String,
                   weight: Float,
                   price: BigDecimal,
                   createdAt: Instant)
