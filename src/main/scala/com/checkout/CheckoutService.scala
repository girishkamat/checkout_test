package com.checkout

trait CheckoutService {

  def calculateCost(items: List[String]): String = {
    val total = items.map(costOfItem).sum
    s"£${total.toDouble/100}"
  }

  private def costOfItem(item: String): Int = item match {
    case "Apple" => 60
    case "Orange" => 25
    case other => throw new IllegalArgumentException(s"Item not recognized: $other")
  }
}
