package com.checkout

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class CheckoutServiceTest extends AnyWordSpec with Matchers {

  "calculateCost" should {

    "calculate total cost when no items" in new CheckoutService {
      //given
      val items = List.empty

      //when
      val cost = calculateCost(items)

      //then
      cost shouldEqual "£0.0"
    }

    "calculate total cost of given items" in new CheckoutService {
      //given
      val items = List("Apple", "Orange")

      //when
      val cost = calculateCost(items)

      //then
      cost shouldEqual "£0.85"
    }

    "calculate total cost when multiple items of same type" in new CheckoutService {
      //given
      val items = List("Orange", "Orange", "Apple")

      //when
      val cost = calculateCost(items)

      //then
      cost shouldEqual "£1.1"
    }

    "throw error when item type is unknown" in new CheckoutService {
      val error = intercept[IllegalArgumentException] {
        calculateCost(List("unknown"))
      }

      error.getMessage shouldBe "Item not recognized: unknown"
    }

    "calculate total cost with promo discount" in new CheckoutService {
      //given
      val items = List("Apple", "Apple", "Orange")

      //when
      val cost = calculateCost(items)

      //then
      cost shouldEqual "£0.85"
    }
  }
}
