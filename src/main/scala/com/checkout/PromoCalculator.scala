package com.checkout

trait PromoCalculator extends PriceService {

  def calculateApplePromoDiscount(items: List[String]): Int = calculatePromoDiscount(items, "Apple")

  def calculateOrangePromoDiscount(items: List[String]): Int = calculatePromoDiscount(items, "Orange")

  private def calculatePromoDiscount(items: List[String], itemType: String): Int = {
    (items.count(_ == itemType) / (itemType match {
      case "Apple" => 2
      case "Orange" => 3
    })) * costOfItem(itemType)
  }
}
