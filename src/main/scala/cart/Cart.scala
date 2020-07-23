package cart

import cart.Cart.calculateTotal

case class Cart(items: List[Item] = Nil) {

  def addItems(items: Item*): Cart = addItems(items.toList)

  def addItems(items: List[Item]): Cart = Cart(items)

  val totalPrice: BigDecimal = calculateTotal(items)
}

object Cart {
  private def calculateTotal(items: List[Item]) =
    items.groupBy(identity).view
      .mapValues(_.size)
      .map { case (item, count) => item.pricingFunction(count) }
      .sum
}
