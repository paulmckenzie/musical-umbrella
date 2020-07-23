package cart

import cart.Cart.calculateTotal

case class Cart(totalPrice: BigDecimal = BigDecimal(0.0)) {
  def addItems(items: Item*): Cart = addItems(items.toList)

  def addItems(items: List[Item]): Cart = Cart(calculateTotal(items))
}

object Cart {
  private def calculateTotal(items: List[Item]) = {
    items.foldLeft(BigDecimal(0.0)) {
      (acc, item) => acc + item.price
    }
  }
}

sealed trait Item {
  val price: BigDecimal
}

case object Orange extends Item {
  override val price: BigDecimal = 0.25
}

case object Apple extends Item {
  override val price: BigDecimal = 0.60
}