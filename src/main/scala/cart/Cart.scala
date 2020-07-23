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
      .mapValues (_.size)
      .map { case (item: Item, count: Int) => item.pricingFunction(count) }
      .sum
}

sealed trait Item {
  type PricingFunction = Int => BigDecimal
  val pricingFunction: PricingFunction

}

case object Orange extends Item {
  override val pricingFunction: PricingFunction = count => count * 0.25
}

case object Apple extends Item {
  override val pricingFunction: PricingFunction = count => ((count / 2) + (count % 2)) * 0.6
}