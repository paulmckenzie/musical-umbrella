package cart

import org.junit.runner.RunWith
import org.scalatest.freespec.AnyFreeSpec
import org.scalatestplus.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class CartTest extends AnyFreeSpec {

  "A Cart" - {
    "Can be created" in {
      Cart()
    }

    "newly created has zero total" in {
      assert(0.0 === Cart().totalPrice)
    }

    "Oranges" - {
      "one orange" in {
        val newCart = Cart().addItems(Orange)
        assert(0.25 === newCart.totalPrice)
      }

      "two oranges" in {
        val newCart = Cart().addItems(Orange, Orange)
        assert(0.50 === newCart.totalPrice)
      }
    }
  }
}