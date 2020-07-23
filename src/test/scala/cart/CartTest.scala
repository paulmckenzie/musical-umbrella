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

      "two oranges as a list" in {
        val newCart = Cart().addItems(List(Orange, Orange))
        assert(0.50 === newCart.totalPrice)
      }
    }

    "Apples" - {
      "one apple" in {
        val newCart = Cart().addItems(Apple)
        assert(0.60 === newCart.totalPrice)
      }
    }

    "Mixed shopping" - {
      "Apple, Apple, Orange, Apple" in {
        val newCart = Cart().addItems(Apple, Apple, Orange, Apple)
        assert(2.05 === newCart.totalPrice)
      }
    }
  }
}
