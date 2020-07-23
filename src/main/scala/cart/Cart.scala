package cart

case class Cart(totalPrice: BigDecimal = BigDecimal(0.0)) {
  def addItems(items: Item*): Cart = Cart(items.size * 0.25)
}

sealed trait Item

case object Orange extends Item