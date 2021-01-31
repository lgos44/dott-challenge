package dott.model

case class Item(product: Product,
                cost: BigDecimal,
                shippingFee: BigDecimal,
                taxAmount: BigDecimal)
