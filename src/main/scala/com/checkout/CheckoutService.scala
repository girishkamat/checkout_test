package com.checkout

trait CheckoutService extends PromoCalculator {

  def calculateCost(items: List[String]): String = {
    val total = items.map(costOfItem).sum
    val promoDiscount = calculateApplePromoDiscount(items) + calculateOrangePromoDiscount(items)
    s"£${(total.toDouble - promoDiscount) / 100}"
  }
}
