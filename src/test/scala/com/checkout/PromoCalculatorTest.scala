package com.checkout

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class PromoCalculatorTest extends AnyWordSpec with Matchers {

  "calculateApplePromoDiscount" should {

    "return promotional discount for Apples based on BOGOF, when apples are multiples of 2" in new PromoCalculator {

      val items = List("Apple", "Apple")

      val discount = calculateApplePromoDiscount(items)

      discount shouldBe 60
    }

    "return promotional discount for Apples based on BOGOF, when apples are multiples of 2 and has oranges" in new PromoCalculator {

      val items = List("Apple", "Apple", "Orange")

      val discount = calculateApplePromoDiscount(items)

      discount shouldBe 60
    }

    "return promotional discount for Apples based on BOGOF, when apples are not multiples of 2" in new PromoCalculator {

      val items = List("Apple", "Apple", "Apple")

      val discount = calculateApplePromoDiscount(items)

      discount shouldBe 60
    }

    "return no discount for Apples based on BOGOF, when single apple" in new PromoCalculator {

      val items = List("Apple")

      val discount = calculateApplePromoDiscount(items)

      discount shouldBe 0
    }

    "return no discount when only Oranges" in new PromoCalculator {

      val items = List("Orange")

      val discount = calculateApplePromoDiscount(items)

      discount shouldBe 0
    }
  }

  "calculateOrangePromoDiscount" should {

    "return promotional discount for Orange based on '3 for for the price of 2', when multiple of 3" in new PromoCalculator {
      val items = List("Orange", "Orange", "Orange")

      val discount = calculateOrangePromoDiscount(items)

      discount shouldBe 25
    }

    "return promotional discount for Orange based on '3 for for the price of 2', when multiple of 3 and has apples" in new PromoCalculator {
      val items = List("Orange", "Orange", "Orange", "Apple")

      val discount = calculateOrangePromoDiscount(items)

      discount shouldBe 25
    }

    "return promotional discount for Orange based on '3 for for the price of 2', when not multiple of 3" in new PromoCalculator {
      val items = List("Orange", "Orange", "Orange", "Orange")

      val discount = calculateOrangePromoDiscount(items)

      discount shouldBe 25
    }

    "return no promotional discount for Orange based on '3 for for the price of 2', when less than 3" in new PromoCalculator {
      val items = List("Orange", "Orange")

      val discount = calculateOrangePromoDiscount(items)

      discount shouldBe 0
    }

    "return no promotional discount for Orange based on '3 for for the price of 2', when only Apples" in new PromoCalculator {
      val items = List("Apple", "Apple", "Apple")

      val discount = calculateOrangePromoDiscount(items)

      discount shouldBe 0
    }
  }
}
