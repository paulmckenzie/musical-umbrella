package cart

sealed trait Item {
  type PricingFunction = Int => BigDecimal

  def buyOneGetOneFree(price: BigDecimal)(count: Int): BigDecimal = ((count / 2) + (count % 2)) * price

  def threeForPriceOfTwo(price: BigDecimal)(count: Int): BigDecimal = ((2 * (count / 3)) + (count % 3)) * price

  val pricingFunction: PricingFunction

}

case object Orange extends Item {
  override val pricingFunction: PricingFunction = threeForPriceOfTwo(0.25)
}

case object Apple extends Item {
  override val pricingFunction: PricingFunction = buyOneGetOneFree(0.6)
}