package cart

case class Cart(totalPrice: BigDecimal = BigDecimal(0.0)) {
  def addItems(item: Item): Cart = Cart(0.25)
}

sealed trait Item

case object Orange extends Item